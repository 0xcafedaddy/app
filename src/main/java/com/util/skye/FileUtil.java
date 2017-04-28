package com.util.skye;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;


/**
 * 文件操作公共类
 * 
 * @author 刘勇涛
 * 
 */
public class FileUtil {
	/**
	 * 拷贝文件
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param targetFile
	 *            目的地文件
	 * @throws IOException
	 */
	public static void copyFile(File sourceFile, File targetFile) throws Exception {
		// System.out.println("sourceFile = " + sourceFile.getPath());
		// System.out.println("targetFile = " + targetFile.getPath());
		isDir(targetFile.getParentFile());
		FileInputStream input = null;
		BufferedInputStream inBuff = null;
		FileOutputStream output = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			input = new FileInputStream(sourceFile);
			inBuff = new BufferedInputStream(input);

			// 新建文件输出流并对它进行缓冲
			output = new FileOutputStream(targetFile);
			outBuff = new BufferedOutputStream(output);

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
		} finally {
			// 刷新此缓冲的输出流
			if (outBuff != null) {
				outBuff.flush();
			}
			// 关闭流
			IOUtils.closeQuietly(inBuff);
			IOUtils.closeQuietly(outBuff);
			IOUtils.closeQuietly(output);
			IOUtils.closeQuietly(input);
		}
	}

	/**
	 * 拷贝目录
	 * 
	 * @param sourceDir
	 *            源目录
	 * @param targetDir
	 *            目的地目录
	 * @throws IOException
	 */
	public static void copyDirectiory(String sourceDir, String targetDir) throws Exception {
		File toDir = new File(targetDir);
		deleteAll(toDir);

		// 判断目标目录是否存在
		isDir(toDir);

		File fromDir = new File(sourceDir);

		// 获取源文件夹当前下的文件或目录
		File[] file = fromDir.listFiles();
		for (File sourceFile : file) {
			if (sourceFile.isFile()) {
				// 目标文件
				File targetFile = new File(toDir.getAbsolutePath() + File.separator + sourceFile.getName());
				copyFile(sourceFile, targetFile);
			}
			if (sourceFile.isDirectory()) {
				// 准备复制的源文件夹
				String dir1 = sourceDir + "/" + sourceFile.getName();
				// 准备复制的目标文件夹
				String dir2 = targetDir + "/" + sourceFile.getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}

	/**
	 * 删除目录下的所有文件
	 * 
	 * @param f
	 *            目录文件
	 */
	public static void deleteAll(File f) throws Exception {
		if (f.exists()) {
			// 文件
			if (f.isFile()) {
				if (!f.delete()) {
					String message = "不能删除文件 " + f + ".";
					throw new Exception(message);
				}
			} else {
				// 文件夹
				// 获得当前文件夹下的所有子文件和子文件夹
				File f1[] = f.listFiles();

				// 循环处理每个对象

				int len = f1.length;

				for (int i = 0; i < len; i++) {
					// 递归调用，处理每个文件对象
					deleteAll(f1[i]);
				}

				// 删除当前文件夹
				if (!f.delete()) {
					String message = "不能删除目录 " + f + ".";
					throw new Exception(message);
				}
			}
		}
	}
	/**
	 * 删除目录下的除某个文件外的所有文件
	 * 
	 * @param f
	 *            目录文件
	 */
	public static void deleteAllExceptOne(File f,String filename) throws Exception {
	    if (f.exists()) {
	        // 文件
	        if (f.isDirectory()) {
	            // 文件夹
	            // 获得当前文件夹下的所有子文件和子文件夹
	            File f1[] = f.listFiles();
	            for(File file:f1){
	                System.out.println(file.getName());
	                if(!filename.equals(file.getName())){
	                    // 递归调用，处理每个文件对象
	                    deleteAll(file);
	                }
	            }
	        }
	    }
	}


	/**
	 * 拷贝远程文件
	 * 
	 * @param fromUrl
	 *            远程文件地址
	 * @param toUrl
	 *            要拷贝到的本地地址
	 * @throws Exception
	 */
	public static void copyRemoteFile(String fromUrl, String toUrl) throws Exception {
		URL url = new URL(fromUrl);
		HttpURLConnection conn = null;
		InputStream fis = null;
		BufferedInputStream inBuff = null;
		FileOutputStream fos = null;
		BufferedOutputStream outBuff = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(Constants.httpTimeOut);
			conn.setReadTimeout(Constants.httpTimeOut);

			conn.setDoInput(true);
			conn.connect();

			// 看是否存在目录，不存在新建一个
			String toDir = toUrl.substring(0, toUrl.lastIndexOf(File.separator));
			isDir(new File(toDir));

			fis = conn.getInputStream();
			inBuff = new BufferedInputStream(fis);
			fos = new FileOutputStream(toUrl);
			outBuff = new BufferedOutputStream(fos);

			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inBuff.read(buffer)) > 0) {
				outBuff.write(buffer, 0, len);
			}
		} catch (IOException e) {

		} finally {
			if (outBuff != null) {
				outBuff.flush();
			}
			IOUtils.closeQuietly(inBuff);
			IOUtils.closeQuietly(outBuff);
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(fis);
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	/**
	 * 读取指定的输入流内容
	 * 
	 * @param stream
	 *            输入流
	 * @return 读取的内容
	 * @throws Exception
	 */
	public static String readStreamText(InputStream stream, String encoding) throws Exception {
		BufferedReader br = null;
		StringBuilder str = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(stream, encoding));

			String line = null;
			while ((line = br.readLine()) != null) {
				str.append(line).append("\r\n");
			}
		} finally {
			IOUtils.closeQuietly(br);
		}

		return str.toString();
	}

	/**
	 * 按指定编码向文件里写入内容
	 * 
	 * @param content
	 *            需要写入的内容
	 * @param fileAddr
	 *            文件地址
	 * @param joins
	 *            是否在文件最后加入写入内容，true:在最后加入，false:整体覆盖
	 * @param encoding
	 *            按指定编码格式写入
	 * @throws Exception
	 */
	public static void writeFileEncoding(String content, String fileAddr, boolean joins, String encoding) throws Exception {
		BufferedWriter pw = null;
		try {
			pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileAddr, joins), encoding));
			pw.write(content);
		} finally {
			if (pw != null) {
				pw.flush();
			}

			IOUtils.closeQuietly(pw);
		}
	}

	/**
	 * 向文件里写入内容
	 * 
	 * @param content
	 *            需要写入的内容
	 * @param fileAddr
	 *            文件地址
	 * @param joins
	 *            是否在文件最后加入写入内容，true:在最后加入，false:整体覆盖
	 * @throws Exception
	 */
	public static void writeFile(String content, String fileAddr, boolean joins) throws Exception {
		BufferedWriter pw = null;
		try {
			pw = new BufferedWriter(new FileWriter(fileAddr, joins));
			pw.write(content);
		} finally {
			if (pw != null) {
				pw.flush();
			}

			IOUtils.closeQuietly(pw);
		}
	}

	/**
	 * 判断目录是否存在,不存在创建一个，存在就返回目录
	 * 
	 * @param dirName
	 *            目录名字
	 * @return
	 */
	public static File isDir(File dirName) throws Exception {
		if (!dirName.exists())// 不存在就创建目录
		{
			dirName.mkdirs();
		}

		return dirName;
	}

	/**
	 * 判断文件是否存在,不存在创建一个，存在就返回文件
	 * 
	 * @param fileName
	 *            文件名字
	 * @return
	 */
	public static File isFile(File fileName) throws Exception {
		isDir(fileName.getParentFile());
		if (!fileName.exists())// 不存在就创建文件
		{
			fileName.createNewFile();
		}

		return fileName;
	}

	/**
     * 判断目录是否存在
     * 
     * @param fileName
     * @return
     */
    public static File createDirectory(String fileName) {
        File file = new File(fileName);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }
	
	
	
	
	
	
	public static String replaceRemoteImg(String content, long enterpriseId, String dirName) throws Exception {
		StringBuilder sb = new StringBuilder();
		while (true) {
			int startIndex = content.indexOf("<img");
			if (startIndex > -1) {
				int endIndex = content.indexOf("/>", startIndex);

				String startText = content.substring(0, startIndex);
				String img = content.substring(startIndex, endIndex + 2);
				String startImg = startText + img;
				content = StringUtils.removeStart(content, startImg);
				if (img.indexOf("src=\"http:") > -1) {
					// 得到图片下载地址
					String srcurl = img.substring(img.indexOf("src=\"") + 5);
					srcurl = srcurl.substring(0, srcurl.indexOf("\""));
					// 得到图片名称
					String toName = srcurl.substring(srcurl.lastIndexOf("/") + 1);
					// 根据时分秒自动生成新名
					String toTimeName = ImageUtils.getImageNameByTime(toName);
					String toUrl = AppPath.getInstance().getRootPath().replaceAll("\\\\", "/") + "userfiles/image/original/" + enterpriseId
							+ "/remote/" + dirName + "/" + toTimeName;
					FileUtil.copyRemoteFile(srcurl, toUrl);

					File sourceFile = new File(toUrl);
					File dir1 = new File(AppPath.getInstance().getRootPath().replaceAll("\\\\", "/") + "userfiles/image/big/" + enterpriseId
							+ "/remote/" + dirName + "/");
					File dir2 = new File(AppPath.getInstance().getRootPath().replaceAll("\\\\", "/") + "userfiles/image/midsize/" + enterpriseId
							+ "/remote/" + dirName + "/");
					File dir3 = new File(AppPath.getInstance().getRootPath().replaceAll("\\\\", "/") + "userfiles/image/small/" + enterpriseId
							+ "/remote/" + dirName + "/");
					if (!dir1.exists()) {
						dir1.mkdirs();
					}
					if (!dir2.exists()) {
						dir2.mkdirs();
					}
					if (!dir3.exists()) {
						dir3.mkdirs();
					}
					ImageUtils.imageScaleWidth(sourceFile, new File(AppPath.getInstance().getRootPath().replaceAll("\\\\", "/")
							+ "userfiles/image/big/" + enterpriseId + "/remote/" + dirName + "/", toTimeName), Constants.PHOTO_WIDTH_BIG);
					ImageUtils.imageScaleWidth(sourceFile, new File(AppPath.getInstance().getRootPath().replaceAll("\\\\", "/")
							+ "userfiles/image/midsize/" + enterpriseId + "/remote/" + dirName + "/", toTimeName), Constants.PHOTO_WIDTH_MIDSIZE);
					ImageUtils.imageScaleWidth(sourceFile, new File(AppPath.getInstance().getRootPath().replaceAll("\\\\", "/")
							+ "userfiles/image/small/" + enterpriseId + "/remote/" + dirName + "/", toTimeName), Constants.PHOTO_WIDTH_SMALL);

					String timg = img.replaceAll(srcurl, toUrl.substring(toUrl.indexOf("/twitter")));
					startImg = startImg.replace(img, timg);
					sb.append(startImg);
				} else {
					sb.append(startImg);
				}
			} else {
				sb.append(content);
				break;
			}
		}

		return sb.toString();
	}
}