package com.util.skye;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * <p>
 * decribing : FTP工具实现类
 * </p>
 * <p>
 * copyright : Copyright @ 2012 hansy
 * </p>
 * <p>
 * </p>
 * <p>
 * time : 2013-2-27上午11:19:41
 * </p>
 * 
 * @author Maxp
 * @version v1.0
 */
public class FTPUtil {

    //枚举类UploadStatus代码
    public enum UploadStatus {
        Create_Directory_Fail, //远程服务器相应目录创建失败
        Create_Directory_Success, //远程服务器闯将目录成功
        Upload_New_File_Success, //上传新文件成功
        Upload_New_File_Failed, //上传新文件失败
        File_Exits, //文件已经存在
        Remote_Bigger_Local, //远程文件大于本地文件
        Upload_From_Break_Success, //断点续传成功
        Upload_From_Break_Failed, //断点续传失败
        Delete_Remote_Faild, //删除远程文件失败
        Parameters_Error;//参数错误
    }

    //枚举类DownloadStatus代码
    public enum DownloadStatus {
        Remote_File_Noexist, //远程文件不存在
        Local_Bigger_Remote, //本地文件大于远程文件
        Download_From_Break_Success, //断点下载文件成功
        Download_From_Break_Failed, //断点下载文件失败
        Download_New_Success, //全新下载文件成功
        Download_New_Failed; //全新下载文件失败
    }

    // 申请提交路径 FTP 路径
    public static final String importPath    = "\\import";
    // 申请处理路径
    public static final String exportPath    = "\\export";
    // 读取完成申请文件后拷贝文件路径
    public static final String copyPath      = "\\copy";
    
    public static final String FTP_URL       = FuncConfig.getProperty("connectMsgIp");
    public static final int    FTP_PORT      = 21;
    public static final String FTP_USER_NAME = FuncConfig.getProperty("connectImgUsername");
    public static final String FTP_PASSWORD  = FuncConfig.getProperty("connectImgPassword");
    public static final String RESP_URL      = FuncConfig.getProperty("tarPath");

    //    public static final String FTP_URL       = "123.57.44.58";
    //    public static final int FTP_PORT = 21;
    //    public static final String FTP_USER_NAME = "testftp";
    //    public static final String FTP_PASSWORD  = "test123";

    public static final String USERNAME      = FuncConfig.getProperty("connectImgUsername");
    public static final String PASSWORD      = FuncConfig.getProperty("connectImgPassword");

    public static FTPClient    ftp           = new FTPClient();

    private static FTPUtil     instance;

    private FTPUtil() {
    }

    public static FTPUtil getInstance() {
        if (instance == null) {
            instance = new FTPUtil();
        }
        return instance;
    }

    /**
     * java编程中用于连接到FTP服务器
     * 
     *            主机名
     *            端口
     *            用户名
     *            密码
     * @return 是否连接成功
     * @throws IOException
     */
    public boolean connect() {
        try {
            System.out.println(FTP_URL + "," + FTP_PORT + "," + FTP_USER_NAME + "," + FTP_PASSWORD);
            ftp.connect(FTP_URL, FTP_PORT);
            if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                if (ftp.login(FTP_USER_NAME, FTP_PASSWORD)) {
                    return true;
                }
            }
            disconnect();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 断开与远程服务器的连接
     * 
     * @throws IOException
     */
    public void disconnect() throws IOException {
        if (ftp.isConnected()) {
            ftp.disconnect();
        }
    }

    /**
     * 上传文件到FTP服务器，支持断点续传
     * 
     *            本地文件名称，绝对路径
     * @param remote
     *            远程文件路径，使用/home/directory1/subdirectory/ 按照Linux上的路径指定方式，支持多级目录嵌套，支持递归创建不存在的目录结构
     * @param filename
     *            远程文件名
     * @return 上传结果
     * @throws IOException
     */
    public static UploadStatus upload(File localFile, String remote, String filename) {
        FTPUtil.getInstance().connect();
        UploadStatus result = null;
        //设置PassiveMode传输
        try {
            ftp.enterLocalPassiveMode();
            //设置以二进制流的方式传输
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            if (remote.contains("/")) {

                if (!remote.equalsIgnoreCase("/") && !ftp.changeWorkingDirectory(remote)) {
                    //如果远程目录不存在，则递归创建远程服务器目录
                    int start = 0;
                    int end = 0;
                    if (remote.startsWith("/")) {
                        start = 1;
                    } else {
                        start = 0;
                    }
                    end = remote.indexOf("/", start);
                    while (true) {
                        String subDirectory = remote.substring(start, end);
                        if (!ftp.changeWorkingDirectory(subDirectory)) {
                            if (ftp.makeDirectory(subDirectory)) {
                                ftp.changeWorkingDirectory(subDirectory);
                            } else {
                                System.out.println("创建目录失败");
                                return UploadStatus.Create_Directory_Fail;
                            }
                        }

                        start = end + 1;
                        end = remote.indexOf("/", start);

                        //检查所有目录是否创建完毕
                        if (end <= start) {
                            break;
                        }
                    }
                }
            }

            //检查远程是否存在文件
            FTPFile[] files = ftp.listFiles(filename);
            if (files.length == 1) {
                long remoteSize = files[0].getSize();
                long localSize = localFile.length();
                if (remoteSize == localSize) {
                    return UploadStatus.File_Exits;
                } else if (remoteSize > localSize) {
                    return UploadStatus.Remote_Bigger_Local;
                }

                //尝试移动文件内读取指针,实现断点续传
                InputStream is = new FileInputStream(localFile);
                if (is.skip(remoteSize) == remoteSize) {
                    ftp.setRestartOffset(remoteSize);
                    if (ftp.storeFile(remote, is)) {
                        return UploadStatus.Upload_From_Break_Success;
                    }
                }

                //如果断点续传没有成功，则删除服务器上文件，重新上传
                if (!ftp.deleteFile(filename)) {
                    return UploadStatus.Delete_Remote_Faild;
                }
                is = new FileInputStream(localFile);
                if (ftp.storeFile(remote, is)) {
                    result = UploadStatus.Upload_New_File_Success;
                } else {
                    result = UploadStatus.Upload_New_File_Failed;
                }
                is.close();
            } else {
                InputStream is = new FileInputStream(localFile);
                if (ftp.storeFile(filename, is)) {
                    result = UploadStatus.Upload_New_File_Success;
                } else {
                    result = UploadStatus.Upload_New_File_Failed;
                }
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    /**
     * 批量上传文件到FTP服务器，支持断点续传
     * 
     * @param localFiles
     *            本地文件数组
     * @param remote
     *            远程文件路径，使用/home/directory1/subdirectory/ 按照Linux上的路径指定方式，支持多级目录嵌套，支持递归创建不存在的目录结构
     * @param filenames
     *            远程文件名数组
     * @return 上传结果
     * @throws IOException
     */
    @SuppressWarnings("null")
    public static UploadStatus uploadBatch(List<File> localFiles, String remote, List<String> filenames) {
        FTPUtil.getInstance().connect();
        UploadStatus result = null;
        if (localFiles == null || localFiles.size() == 0 || filenames == null || filenames.size() == 0) {
            result = UploadStatus.Parameters_Error;
        }
        try {
            //设置PassiveMode传输
            ftp.enterLocalPassiveMode();
            //设置以二进制流的方式传输
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            if (remote.contains("/")) {
                if (!remote.equalsIgnoreCase("/") && !ftp.changeWorkingDirectory(remote)) {
                    //如果远程目录不存在，则递归创建远程服务器目录
                    int start = 0;
                    int end = 0;
                    if (remote.startsWith("/")) {
                        start = 1;
                    } else {
                        start = 0;
                    }
                    end = remote.indexOf("/", start);
                    while (true) {
                        String subDirectory = remote.substring(start, end);
                        if (!ftp.changeWorkingDirectory(subDirectory)) {
                            if (ftp.makeDirectory(subDirectory)) {
                                ftp.changeWorkingDirectory(subDirectory);
                            } else {
                                System.out.println("创建目录失败");
                                return UploadStatus.Create_Directory_Fail;
                            }
                        }

                        start = end + 1;
                        end = remote.indexOf("/", start);

                        //检查所有目录是否创建完毕
                        if (end <= start) {
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < filenames.size(); i++) {
                //检查远程是否存在文件
                FTPFile[] files = ftp.listFiles(filenames.get(i));
                if (files.length == 1) {
                    long remoteSize = files[0].getSize();
                    long localSize = localFiles.get(i).length();
                    if (remoteSize == localSize) {
                        return UploadStatus.File_Exits;
                    } else if (remoteSize > localSize) {
                        return UploadStatus.Remote_Bigger_Local;
                    }

                    //尝试移动文件内读取指针,实现断点续传
                    InputStream is = new FileInputStream(localFiles.get(i));
                    if (is.skip(remoteSize) == remoteSize) {
                        ftp.setRestartOffset(remoteSize);
                        if (ftp.storeFile(remote, is)) {
                            return UploadStatus.Upload_From_Break_Success;
                        }
                    }

                    //如果断点续传没有成功，则删除服务器上文件，重新上传
                    if (!ftp.deleteFile(filenames.get(i))) {
                        return UploadStatus.Delete_Remote_Faild;
                    }
                    is = new FileInputStream(localFiles.get(i));
                    if (ftp.storeFile(remote, is)) {
                        result = UploadStatus.Upload_New_File_Success;
                    } else {
                        result = UploadStatus.Upload_New_File_Failed;
                    }
                    is.close();
                } else {
                    InputStream is = new FileInputStream(localFiles.get(i));
                    if (ftp.storeFile(filenames.get(i), is)) {
                        result = UploadStatus.Upload_New_File_Success;
                    } else {
                        result = UploadStatus.Upload_New_File_Failed;
                    }
                    is.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    /**
     * 上传文件 apache Description: 向FTP服务器上传文件
     * 
     * @param filename
     *            上传到FTP服务器上的文件名
     * @param input
     *            输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String filename, InputStream input) {
        boolean success = false;
        FTPUtil.getInstance().connect();
        try {
            ftp.makeDirectory(exportPath);
            ftp.changeWorkingDirectory(exportPath);
            ftp.storeFile(filename, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     * Description: 从FTP服务器下载文件
     * 
     * @param remotePath
     *            FTP服务器上文件路径
     * @param localPath
     *            下载后保存到本地的路径 必须以\结束
     * @return
     */
    public static List<String> downFile(String remotePath, String localPath) {
        List<String> fileLst = new ArrayList<String>();
        FTPUtil.getInstance().connect();
        try {
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            // 获取文件列表
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (!ff.isDirectory()) {
                    String localPath_ = localPath + ff.getName();
                    // 下载新文件
                    File localFile = new File(localPath_);
                    if (!localFile.exists()) {
                        localFile.getParentFile().mkdirs();
                        localFile.createNewFile();
                    }
                    OutputStream is = new FileOutputStream(localFile);
                    ftp.setControlEncoding("UTF-8");
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                    fileLst.add(localPath_);
                }
            }
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return fileLst;
    }

    public static float countWH(String imgString) {
        try {
            java.net.URL url = new java.net.URL(imgString);
            BufferedImage bi = javax.imageio.ImageIO.read(url);
            float w = bi.getWidth();
            float h = bi.getHeight();
            return w / h;
        } catch (IOException e) {
            return 0;
        }
    }

    /**
     * 拷贝文件
     * 
     * @param src
     *            本地文件
     * @throws IOException
     */
    public static void copyFile(String src) {
        FTPClient ftp = null;
        FTPUtil.getInstance().connect();
        File file = new File(src);
        // 如果路径是个目录
        if (file.isDirectory()) {
            String[] fs = file.list();
            for (String element : fs) {
                File f = new File(element);
                copyFile(src + f.getName());
            }

        } else {
            if (file.exists()) {
                InputStream is = null;
                try {
                    is = new FileInputStream(file);
                    ftp.setControlEncoding("UTF-8");
                    ftp.setFileType(FTP.BINARY_FILE_TYPE);
                    ftp.makeDirectory(copyPath);
                    ftp.changeWorkingDirectory(copyPath);
                    ftp.storeFile(file.getName(), is);
                    is.close();
                } catch (FileNotFoundException e) {
                    // 
                    e.printStackTrace();
                } catch (IOException e) {
                    // 
                    e.printStackTrace();
                } finally {
                    if (ftp.isConnected()) {
                        try {
                            ftp.disconnect();
                        } catch (IOException ioe) {
                        }
                    }
                }

            }
        }

    }

    /**
     * 删除某目录下的全部文件 传入远端目录
     * 
     * @param remotePath
     */
    public static void deleFTPFile(String remotePath) {
        FTPUtil.getInstance().connect();
        try {
            ftp.changeWorkingDirectory(remotePath);
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                System.out.println(ff.getName());

                if (!ff.isDirectory()) {
                    System.err.println(ftp.deleteFile(ff.getName()));
                }
            }
        } catch (IOException e) {
            // 
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
    }

    /**
     * 删除远程目录的某文件
     * 
     * @param remotePath
     *            目录
     * @param fileName
     *            文件
     */
    public static void deleFTPFile(String remotePath, String fileName) {
        FTPUtil.getInstance().connect();
        try {
            ftp.changeWorkingDirectory(remotePath);
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                System.out.println(ff.getName());

                if (!ff.isDirectory() && fileName.equals(ff.getName())) {
                    System.err.println(ftp.deleteFile(ff.getName()));
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
    }

    /**
     * 删除远程目录中除了给定文件名的文件
     * 
     * @param remotePath
     *            目录
     * @param fileName
     *            文件
     */
    public static void deleAllExceptOne(String remotePath, String fileName) {
        FTPUtil.getInstance().connect();
        try {
            ftp.changeWorkingDirectory(remotePath);
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                System.out.println(ff.getName());

                if (!ff.isDirectory() && !fileName.equals(ff.getName())) {
                    System.err.println(ftp.deleteFile(ff.getName()));
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
    }

    /**
     * 删除远程目录中除了给定文件名的文件
     * 
     * @param remotePath
     *            目录
     * @param fileName
     *            文件
     */
    public static boolean isFileExist(String remotePath, String fileName) {
        FTPUtil.getInstance().connect();
        try {
            ftp.changeWorkingDirectory(remotePath);
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                System.out.println(ff.getName());
                if (!ff.isDirectory() && fileName.equals(ff.getName())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return false;
    }

    /**
     * 测试使用
     * 
     * @param args
     */
    public static void main(String[] args) {
        //        //下载文件
        //        downFile("/import", "c:\\");
        //上传文件
        //        try {
        //            uploadFile("a.txt", new FileInputStream(new File("c:\\aa.txt")));
        //        } catch (FileNotFoundException e) {
        //            // 
        //            e.printStackTrace();
        //        }
        //删除文件
        //      deleFTPFile("\\02");
        //        copyFile("C:\\ftpRoot\\import\\");
        //        deleFTPFile("/img/data/user/1731/");
        //        deleFTPFile("/img/data/user/51/small", "1418726892062.jpg");

        //            //测试批量从本地上传到远程目录
        File f = new File("E:\\垃圾站\\309487549\\Image\\0");
        List<File> localFiles = new ArrayList<File>();
        localFiles.add(f);
        localFiles.add(f);
        localFiles.add(f);
        List<String> filenames = new ArrayList<String>();
        filenames.add("0");
        filenames.add("2");
        filenames.add("1");
        //        System.out.println(uploadBatch(localFiles, "/test/", filenames));

        //        System.out.println(FTPUtil.isFileExist("/img/data/sale/205/small", "1419223948945.jpg"));

        //        FTPUtil.deleFTPFile("/test/");
        //        FTPUtil.deleFTPFile("/test/", "0");
        //        FTPUtil.deleAllExceptOne("/test/", "1");

        //        FTPUtil.deleFTPFile("/img/data/laugh/301/original/");
        //        FTPUtil.deleFTPFile(Constants.USER + "51/original/", "1418726204172.jpg");
        //FTPUtil.deleFTPFile("/img/data/sale/205/small", "1419223948943.jpg");

        //        FTPUtil.deleFTPFile("/", "1504.shtml");

        //        System.out.println(FTPUtil.readFile("http://123.57.44.58:6060/img_server/img/data/sale/205/original/1419223948943.jpg"));

        //        upload(new File("/img/data/sale/205/original/1419223948945.jpg"), "/test/", "test.jpg");
        //        copyFile("/img/data/sale/205/original/1419223948945.jpg");

        System.out.println(countWH("http://123.57.44.58:6060/img_server/img/data/laugh/330/small/1419495653068.png"));
    }

}