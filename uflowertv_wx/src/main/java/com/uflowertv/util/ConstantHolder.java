package com.uflowertv.util;


/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：系统业务常量
 * 类名称：com.uflowertv.util.ConstantHolder     
 * 创建人：liguoliang 
 * 创建时间：2016年8月9日 下午7:50:09   
 * 修改人：
 * 修改时间：2016年8月9日 下午7:50:09   
 * 修改备注：   
 * @version   V1.0
 */
public interface ConstantHolder {
	//文件远程服务器参数
//	String SERVER_ROOT = "/usr/local/tomcat_8088/webapps/img_web/";
//	String IMG_SERVER = ConstantConfig.getProperty("IMG_WEB");
//	String IMG_FLODER = "test/img/";
//	String HTML_FLODER = "test/html/";
	/*******************************************************************************************/
	String FILE_SERVER = ConstantConfig.getProperty("file_web");
	String IMG_FLODER =  ConstantConfig.getProperty("img_folder");
	String HTML_FLODER =  ConstantConfig.getProperty("html_folder");
	//SFTP参数
	String SFTP_REQ_HOST = "123.56.244.170";
	String SFTP_REQ_PORT = "22";
	int SFTP_DEFAULT_PORT = 22;
	String SFTP_REQ_USERNAME = "root";
	String SFTP_REQ_PASSWORD = "19850212Matao";
	//短信参数
	String APIKEY = ConstantConfig.getProperty("apikey");
	String SECRETKEY = ConstantConfig.getProperty("secretekey");
	String TEMPLATEID = ConstantConfig.getProperty("templateid");
	String SMSURL = ConstantConfig.getProperty("smsurl");
	String SEND_MESSAGE = ConstantConfig.getProperty("sendmessage");
	//微信参数
	String APPID = ConstantConfig.getProperty("appid");
	String MPID = ConstantConfig.getProperty("mpid");
	String APPSECRET = ConstantConfig.getProperty("appsecrete");
	String TOKEN = ConstantConfig.getProperty("token");
	String WXTEMPLATEID = ConstantConfig.getProperty("wxtemplateid");
	String COMPANY_JS = ConstantConfig.getProperty("company_js");
	//百度翻译参数
	String FANYI_APPID = ConstantConfig.getProperty("fanyi_appid");
	String FANYI_FROM = ConstantConfig.getProperty("fanyi_from");
	String FANYI_TO = ConstantConfig.getProperty("fanyi_to");
	String FANYI_SALT = ConstantConfig.getProperty("fanyi_salt");
	String FANYI_TOKEN = ConstantConfig.getProperty("fanyi_token");
	
	//微信菜单接口
	String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	//百度翻译接口
	String BAIDUFANYI = "http://api.fanyi.baidu.com/api/trans/vip/translate";
	
}
