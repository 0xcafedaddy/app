package com.util.ctvit.gather.commons;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * 版权所有：2016年3月14日-天溢中鼎-技术部
 * 项目名称：20160309   
 *
 * 类描述：
 * 类名称：lgl.util.ctvit.gather.CloudConstants     
 * 创建人：liguoliang 
 * 创建时间：2016年3月14日 下午4:22:25   
 * 修改人：
 * 修改时间：2016年3月14日 下午4:22:25   
 * 修改备注：   
 * @version   V1.0
 */
public class CloudConstants {

	/**********************ftp 网址**********************************/
	/**
	 * FTP内网地址
	 */
	public static String FTP_INNET = "";

	/**
	 * FTP外网地址
	 */
	public static String FTP_OUTNET = "";

	/**
	 * FTP用户名
	 */
	public static String FTP_USERNAME = "";

	/**
	 * FTP密码
	 */
	public static String FTP_PASSWORD = "";

	/**
	 * FTP密码
	 */
	public static int FTP_PORT = 21;

	/**
	 * http://[域名][公共参数][接口地址] 域名:服务所提供的内容
	 * 公共参数:参考公共参数说明中的内容说明，由系统统一进行分配，用户调用接口时按分配的内容进行填写。 接口地址:服务提供的内容。
	 * 
	 * http://[域名]/appCode/versionId/companyId/userId/serviceCode/auth/token/getAccessToken/
	 * 
	 */
	/**
	 * 平台秘钥
	 * */
	public static String accessKey = "UfwDQJBi";// 密钥（此密钥由荔枝云平台提供，需严格保密）

	public static String splitStr = "/";

	public static String FILE_SPLIT = File.separator;

	/**
	 * 公共请求参数
	 * */
	public static Map<String, Object> publicParameters = new HashMap<String, Object>();

	/**
	 *  公共请求参数服务类型标识
	 * */
	public static Map<String, Object> serviceCodes = new HashMap<String, Object>();

	/**
	 * 域名
	 * */
	public static Map<String, Object> domainMap = new HashMap<String, Object>();
	/**
	 * 调用接口常量
	 * */
	public static Map<String, Object> interfaceConstant = new HashMap<String, Object>();

	/**
	 * 云迁移任务进度
	 * **/
	public static ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();

	/**
	 * FTP上传任务进度
	 * */
	public static ConcurrentHashMap<String, Map<String, Object>> ftpUploadHashMap = new ConcurrentHashMap<String, Map<String, Object>>();

	/**
	 * Servlet上传任务进度
	 * */
	public static ConcurrentHashMap<String, Map<String, Object>> servletUploadHashMap = new ConcurrentHashMap<String, Map<String, Object>>();

}
