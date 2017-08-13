package com.uflowertv.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 * 
 * title : Description : 获取工程路径类 Date : 2010-7-28 Company : 新网互联
 * 
 * @author : LiuYT
 * @version : 1.0
 */
public class AppPath {
	private static AppPath APP_PATH = null;
	private String APP_ROOT_PATH;// 应用部署的根路径

	public static synchronized AppPath getInstance() {
		if (APP_PATH == null) {
			APP_PATH = new AppPath();
		}

		return APP_PATH;
	}

	public String setRootPath(String rootPath) {
		return APP_ROOT_PATH = rootPath;
	}

	/**
	 * 获取应用部署的根路径
	 * 
	 * @return
	 */
	public String getRootPath() {
		return APP_ROOT_PATH;
	}

	/**
	 * 获取应用部署的classes的绝对路径
	 * 
	 * @return
	 */
	public String getAppClassesPath() {
		return APP_ROOT_PATH + "WEB-INF/classes/";
	}
	
	public String getAppWebInfo(){
		return APP_ROOT_PATH+"WEB-INF/";
	}

	public HttpServletRequest getRequest(HttpServletRequest... isRequest) {
		HttpServletRequest request;
		if (isRequest.length > 0) {
			request = isRequest[0];
		} else {
		    //这种方式需要在web.xml里配置监听器 org.springframework.web.context.request.RequestContextListener
            request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		}

		return request;
	}

	/**
	 * 获取Tomcat下的webapp的绝对路径 E:\Java\Tomcat6\apache-tomcat-6.0.35\webapps
	 * 
	 * @return
	 */
	public String getWebappPath() {
		String proPath=APP_ROOT_PATH.substring(0, APP_ROOT_PATH.length() - 1);
		return proPath.substring(0, proPath.lastIndexOf(File.separator));
	}

	public String getProjectName() {
		String proUrl = APP_ROOT_PATH.substring(0, APP_ROOT_PATH.length() - 1);
		return proUrl.substring(proUrl.lastIndexOf(File.separator) + 1);
	}

	/**
	 * 获取操作协议,如http,https,ftp等
	 * 
	 * @return
	 */
	public String getScheme(HttpServletRequest... isRequest) {
		return getRequest(isRequest).getScheme();
	}

	/**
	 * 获取IP
	 * 
	 * @return
	 */
	public String getIp(HttpServletRequest... isRequest) {
		return getRequest(isRequest).getServerName();
	}

	/**
	 * 获取端口
	 * 
	 * @return
	 */
	public int getPort(HttpServletRequest... isRequest) {
		return getRequest(isRequest).getServerPort();
	}

	/**
	 * 获取根路径别名
	 * 
	 * @return
	 */
	public String getContextPath(HttpServletRequest... isRequest) {
		return getRequest(isRequest).getContextPath();
	}

	public String getHttpUrl(HttpServletRequest... isRequest) {
		String port = "";
		Integer portValue = getPort(isRequest);
		if (portValue != 80) {
			port = ":" + portValue.toString();
		}

		StringBuilder str = new StringBuilder();
		str.append(getScheme(isRequest)).append("://").append(getIp(isRequest)).append(port);

		return str.toString();
	}

	public String getProjectUrl(HttpServletRequest... isRequest) {
		StringBuilder str = new StringBuilder();
		str.append(getHttpUrl(isRequest)).append(getContextPath(isRequest)).append("/");

		return str.toString();
	}

	/**
	 * 获取上传图片根路径
	 * 
	 * @return
	 */
	public String getImgUploadPath(String name) {
		return APP_ROOT_PATH + name;
	}

	public String getProjectPath() {
		StringBuilder str = new StringBuilder();
		str.append(getHttpUrl()).append(getContextPath()).append("/");

		return str.toString();
	}

	public String getHttpAddr() {
		return "http://" + getIp() + ":" + getPort();
	}
}