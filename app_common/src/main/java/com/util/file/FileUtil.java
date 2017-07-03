package com.util.file;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtil {

	public static final int BUFFER_SIZE = 4096;

	public static final String algorithm_md5 = "MD5";

	public static final String algorithm_sha = "SHA";

	private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

	public static String LoadXmlFile(String filePath) {

		String str = null;
		if (filePath == null)
			return str;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
			String s = reader.readLine();

			StringBuffer sb = new StringBuffer();

			while (s != null) {
				sb.append(s);
				sb.append("\r\n");
				s = reader.readLine();
			}

			reader.close();
			str = sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String LoadXmlFile(File file) {
		String str = null;
		if (!file.exists())
			return str;
		BufferedReader reader;
		StringBuffer sb;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gb2312"));
			String s = reader.readLine();
			sb = new StringBuffer();
			while (s != null) {
				sb.append(s);
				sb.append("\r\n");
				s = reader.readLine();
			}
			//logger.info(sb.toString());
			reader.close();
			str = sb.toString();
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return str;
	}

	public static Boolean saveStringtoFile(String path, String content, String encode) {
		try {
			if (encode == null || encode.equals("")) {
				encode = "utf-8";
			}
			File f = new File(path);
			f.deleteOnExit();
			f.createNewFile();

			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), encode));
			output.write(content);
			output.close();
		} catch (Exception e) {
			log.error("保存文件" + path + "异常", e);
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(true);
	}

	public static boolean delete(String fileName) {
		if (fileName == null)
			return false;
		File file = new File(fileName);
		if (!file.exists()) {
			return false;
		}
		if (file.isFile()) {
			return deleteFile(fileName);
		}
		return deleteDirectory(fileName);
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if ((file.isFile()) && (file.exists())) {
			file.delete();

			return true;
		}

		return false;
	}

	public static boolean deleteDirectory(String dir) {
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);

		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {

			return false;
		}
		boolean flag = true;

		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			} else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}
		if (!flag) {

			return false;
		}

		if (dirFile.delete()) {

			return true;
		}

		return false;
	}

	public static int copy(InputStream in, OutputStream out) throws IOException {
		try {
			int byteCount = 0;
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
				byteCount += bytesRead;
			}
			out.flush();
			return byteCount;
		} finally {
			try {
				in.close();
			} catch (IOException ex) {

			}
			try {
				out.close();
			} catch (IOException ex) {

			}
		}
	}

	public static String copyFile(String sourceUrl, String targetUrl) throws Exception {
		log.info("开始拷贝文件,源文件：" + sourceUrl + ";目标文件：" + targetUrl);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File sourceFile = new File(sourceUrl);
			if (!sourceFile.exists()) {
				throw new Exception("源文件" + sourceUrl + "不存在");
			}
			int readLength = 0;
			File targetFile = new File(targetUrl);
			log.debug("源文件：" + sourceFile.length() + "字节，目标文件:" + targetFile.length() + "字节");
			if (targetFile.exists() && targetFile.length() == sourceFile.length()) {
				log.debug("目标文件" + targetUrl + "存在,不进行复制！");
				return "";
				//targetFile.delete();
			} else {
				targetFile.getParentFile().mkdirs();
			}
			fis = new FileInputStream(sourceUrl);
			fos = new FileOutputStream(targetFile);
			byte[] bytes = new byte[1024 * 128];
			while ((readLength = fis.read(bytes)) > 0) {
				fos.write(bytes, 0, readLength);
			}
			log.info("文件拷贝结束");
		} catch (Exception e) {
			log.error("拷贝文件异常", e);
			throw new Exception(e);
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
		return targetUrl;
	}

	/**
	 * @param sourceUrl
	 * @param targetUrl
	 * @param check
	 *            true 验证文件是否全
	 * @return
	 * @throws Exception
	 */
	public static String copyFile(String sourceUrl, String targetUrl, Boolean check) throws Exception {
		log.info("开始拷贝文件,源文件：" + sourceUrl + ";目标文件：" + targetUrl);
		File sourceFile = new File(sourceUrl);
		File targetFile = new File(targetUrl);
		// 验证源文件是否正在拷贝中
		if (check) {
			long size1 = sourceFile.length();
			long size2 = 0;
			do {
				log.info("size1:" + size1);
				Thread.sleep(3000);
				size2 = sourceFile.length();
				log.info("size2:" + size2);
			} while (size1 != size2);
		}
		// end
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] bytes = new byte[32 * 1024];
		try {
			int readLength = 0;
			if (targetFile.exists()) {
				targetFile.delete();
			} else {
				targetFile.getParentFile().mkdirs();
			}
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(targetFile);
			while ((readLength = fis.read(bytes)) > 0) {
				fos.write(bytes, 0, readLength);
			}
			log.info("文件拷贝结束");
		} catch (Exception e) {
			log.error("拷贝文件异常", e);
			throw new Exception(e);
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
		return targetUrl;
	}

    /**
     * 使用文件通道的方式复制文件
     *
     *            源文件
     *            复制到的新文件
     */
    public static void fileChannelCopy(String sourceUrl, String targetUrl) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(new File(sourceUrl));
            fo = new FileOutputStream(new File(targetUrl));
            in = fi.getChannel();// 得到对应的文件通道
            out = fo.getChannel();// 得到对应的文件通道
            in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过URL方式读取文件内容
     * @param file
     * @return
     */
	public static String readNetFile(String file) {
		try {
			BufferedInputStream result = new BufferedInputStream((new URL(file)).openStream());
			byte[] cont = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int conlen;
			while ((conlen = result.read(cont)) >= 0) {
				baos.write(cont, 0, conlen);
			}
			result.close();
			return new String(new String(baos.toByteArray()).getBytes(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    /**
     * 通过文件路径读取文件内容
     * @param file
     * @return
     */
	public static String read(String file) {
		try {
			BufferedInputStream result = new BufferedInputStream(new FileInputStream(file));
			byte[] cont = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int conlen;
			while ((conlen = result.read(cont)) >= 0) {
				baos.write(cont, 0, conlen);
			}
			result.close();
			return new String(baos.toByteArray());
		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * 文件拷贝
	 */
	 public static void copyFile(String sourceFilePath,String sourceFileName,String targetFilePath,String targetFileName) throws Exception {
         FileInputStream is = null;
         FileOutputStream os = null;
         try {
             String sourceFile = sourceFilePath + sourceFileName;
             sourceFile = sourceFile.replaceAll("/", "\\\\");
             log.info("源文件：" + sourceFile +";目标文件：" + targetFilePath + "/" +
             targetFileName);
             long start = System.currentTimeMillis();
             is = new FileInputStream(sourceFile);
             File targetPath = new File(targetFilePath);
             if(!targetPath.exists()) { //目标路径不存在,创建
             targetPath.mkdirs();
             }
             File targetFile = new File(targetFilePath + "/" + targetFileName);
             // 目标文件存在则先将其删除
             targetFile.deleteOnExit();
             targetFile.createNewFile();
             os = new FileOutputStream(targetFile);
             // StreamUtil.copyFile(is, os);
             copy(is, os);
             log.info("拷贝文件完成，用时（秒）:" + (System.currentTimeMillis()-start)/1000);
             }catch(Exception e) {
             log.error("拷贝文件异常:" + e.getMessage());
             throw new Exception("拷贝文件异常",e);
         }finally {
             try {
                 is.close();
                 os.close();
             }catch(Exception e) {

             }
         }
	 }

	/**
	 * 获取文件校验码
	 * 
	 * @return
	 * @throws IOException
	 */
	// public static String getMD5Code(String filePath) throws IOException {
	// InputStream iStream = new FileInputStream(filePath);
	// return DigestUtils.md5Hex(StreamUtil.toByteArray(iStream));
	// }

	public static String verify(String algorithm, InputStream in) throws IOException {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			log.debug("start computing...");
			long st = System.currentTimeMillis();
			while ((bytesRead = in.read(buffer)) != -1) {
				md.update(buffer, 0, bytesRead);
			}
			log.debug("end   computing...");
			long et = System.currentTimeMillis();
			log.debug("time cost: " + (int) ((et - st) / 1000));
			return bytesToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			log.error(algorithm, e);
			return "";
		} finally {
			try {
				in.close();
			} catch (IOException ex) {
				log.warn("Could not close InputStream", ex);
			}
		}
	}

	public static String verify(InputStream in) throws IOException {
		return verify(algorithm_md5, in);
	}

	public static String verify(String algorithm, String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(new File(fileName));
		return verify(algorithm, fis);
	}

	public static String verify(String fileName) throws IOException {
		return verify(algorithm_md5, fileName);
	}

	private static String bytesToString(byte[] data) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		char[] temp = new char[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			byte b = data[i];
			temp[i * 2] = hexDigits[b >>> 4 & 0x0f];
			temp[i * 2 + 1] = hexDigits[b & 0x0f];
		}
		return new String(temp);
	}

	public static void main(String[] args) throws Exception {
		// copyFile("\\\\10.3.3.165\\live\\myeclipse-9.0-offline-installer-windows.exe","D:\\project\\temp\\myeclipse-9.0-offline-installer-windows.exe",true);
		int i = 0;
		do {
			i++;
			System.out.println(i);
		} while (i != 5);
	}


	/*****************************************************************************************************************/
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

    /*public static String replaceRemoteImg(String content, long enterpriseId, String dirName) throws Exception {
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
                    copyRemoteFile(srcurl, toUrl);

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
    }*/
}
