package com.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Tools {
	public static String copyFileByRelativePath(String sourceAbsoluteUrl, String sourceRootPath, String targetRootPath) throws Exception {
		String targetUrl = sourceAbsoluteUrl.substring(sourceRootPath.length());
		if (targetUrl.startsWith(File.separator)) {
			targetUrl = targetUrl.substring(1);
		}
		if (targetRootPath.endsWith(File.separator)) {
			targetUrl = targetRootPath + targetUrl;
		} else {
			targetUrl = targetRootPath + File.separator + targetUrl;
		}
		return copyFile(sourceAbsoluteUrl, targetUrl);
	}
	
	
	public static String copyFile(String sourceUrl, String targetUrl) throws Exception {
		File sourceFile = new File(sourceUrl);
		File targetFile = new File(targetUrl);
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
		} catch (Exception e) {
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
}
