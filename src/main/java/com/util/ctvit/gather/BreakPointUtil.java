package com.util.ctvit.gather;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** 
 * 上传处理工具类，主要处理request请求，封装request信息等 
 *    javax.servlet-3.1新特性    
 */
public class BreakPointUtil {
	private static Log log = LogFactory.getLog(BreakPointUtil.class);
	private static String fileNameExtractorRegex = "filename=\".+\"";

	/**
	 * 
	 * liguoliang
	 * 2015年8月13日上午10:09:06
	 * @param request
	 * @param path
	 * @throws Exception void
	 */
	public static void upload(HttpServletRequest request, String path) {
		/*File fileSaveDir = new File(path);
		if (!fileSaveDir.exists() || !fileSaveDir.isDirectory()) {
			fileSaveDir.mkdir();
		}
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				part.write(path + File.separator + fileName);
			}
		} catch (IOException e) {
			// 
			e.printStackTrace();
		} catch (ServletException e) {
			// 
			e.printStackTrace();
		}*/
		File fileSaveDir = new File(path);
		if (!fileSaveDir.exists() || !fileSaveDir.isDirectory()) {
			fileSaveDir.mkdirs();
		}
		//获取原文件和表单名称
		List<String> fileNames = new ArrayList<String>();
		try {
			request.setCharacterEncoding("UTF-8");
			Collection<Part> parts = request.getParts();
			//遍历所有的表单内容，将表单中的文件写入上传文件目录  
			for (Iterator<Part> iterator = parts.iterator(); iterator.hasNext();) {
				Part part = iterator.next();
				//从Part的content-disposition中提取上传文件的文件名  
				String fileName = getFileName(part);
				if (fileName != null) {
					fileNames.add(fileName);
					part.write(path + File.separator + fileName);
				}
			}
			for (int i = 0; i < fileNames.size(); i++) {
				String msg = fileNames.get(i);
				log.info("表单内属性名称：" + msg);
			}
		} catch (UnsupportedEncodingException e) {
			// 
			log.error("编码不支持" + e.getMessage());
		} catch (IOException e) {
			// 
			log.error("IO" + e.getMessage());
		} catch (ServletException e) {
			// 
			log.error("ServletException" + e.getMessage());
		}
	}

	/**
	 * 从Part的Header信息中提取上传文件的文件名 
	 * liguoliang
	 * 2015年8月13日下午5:57:38
	 * @param part
	 * @return 上传文件的文件名，如果如果没有则返回null 
	 */
	/*private static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}*/

	private static String getFileName(Part part) {
		//获取header信息中的content-disposition，如果为文件，则可以从其中提取出文件名  
		String cotentDesc = part.getHeader("content-disposition");
		String fileName = null;
		Pattern pattern = Pattern.compile(fileNameExtractorRegex);
		Matcher matcher = pattern.matcher(cotentDesc);
		if (matcher.find()) {
			fileName = matcher.group();
			fileName = fileName.substring(10, fileName.length() - 1);
		}
		return fileName;
	}
}
