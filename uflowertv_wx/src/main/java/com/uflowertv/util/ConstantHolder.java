package com.uflowertv.util;


/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：
 * 类名称：com.uflowertv.util.ConstantHolder     
 * 创建人：liguoliang 
 * 创建时间：2016年8月9日 下午7:50:09   
 * 修改人：
 * 修改时间：2016年8月9日 下午7:50:09   
 * 修改备注：   
 * @version   V1.0
 */
public class ConstantHolder {
	//文件远程服务器参数
//	public static final String SERVER_ROOT = "/usr/local/tomcat_8088/webapps/img_web/";
//	public static final String IMG_SERVER = ConstantConfig.getProperty("IMG_WEB");
//	public static final String IMG_FLODER = "test/img/";
//	public static final String HTML_FLODER = "test/html/";
	/*******************************************************************************************/
	public static final String FILE_SERVER = ConstantConfig.getProperty("file_web");
	public static final String IMG_FLODER =  ConstantConfig.getProperty("img_folder");
	public static final String HTML_FLODER =  ConstantConfig.getProperty("html_folder");
	//SFTP参数
	public static final String SFTP_REQ_HOST = "123.56.244.170";
	public static final String SFTP_REQ_PORT = "22";
	public static final int SFTP_DEFAULT_PORT = 22;
	public static final String SFTP_REQ_USERNAME = "root";
	public static final String SFTP_REQ_PASSWORD = "19850212Matao";
	//短信参数
	public static final String APIKEY = ConstantConfig.getProperty("apikey");
	public static final String SECRETKEY = ConstantConfig.getProperty("secretekey");
	public static final String TEMPLATEID = ConstantConfig.getProperty("templateid");
	public static final String SMSURL = ConstantConfig.getProperty("smsurl");
	public static final String SEND_MESSAGE = ConstantConfig.getProperty("sendmessage");
	//微信参数
	public static final String APPID = ConstantConfig.getProperty("appid");
	public static final String MPID = ConstantConfig.getProperty("mpid");
	public static final String APPSECRET = ConstantConfig.getProperty("appsecrete");
	public static final String TOKEN = ConstantConfig.getProperty("token");
	public static final String WXTEMPLATEID = ConstantConfig.getProperty("wxtemplateid");
	public static final String COMPANY_JS = ConstantConfig.getProperty("company_js");
	//百度翻译参数
	public static final String FANYI_APPID = ConstantConfig.getProperty("fanyi_appid");
	public static final String FANYI_FROM = ConstantConfig.getProperty("fanyi_from");
	public static final String FANYI_TO = ConstantConfig.getProperty("fanyi_to");
	public static final String FANYI_SALT = ConstantConfig.getProperty("fanyi_salt");
	public static final String FANYI_TOKEN = ConstantConfig.getProperty("fanyi_token");
	
	//微信菜单接口
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	public static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	public static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	//百度翻译接口
	public static final String BAIDUFANYI = "http://api.fanyi.baidu.com/api/trans/vip/translate";

	
	
	
}
