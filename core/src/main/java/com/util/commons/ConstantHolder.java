package com.util.commons;

import com.util.properties.ConstantConfig;

public interface ConstantHolder {
    /***********************uflowertv_api*********************************************/
	//订单状态
	int PAY_FAIL = 0;//支付失败
	int PAY_SUCCESS = 1;//支付成功
	int ORDER_FAIL = 2;//订购失败
	int ORDER_SUCCESS = 3;//订购成功
	int ORDER_OUT_OF_SERVER = 4;//产品暂停服务
	int ORDER_EXPRIES = 5;//订单已退订或已过期
	//订单来源
	int ORDER_BOSS = 0;//Boss接口
	int ORDER_OTHER = 1;//营业厅
	//运营商产品状态
	int OPER_PRODUCT_STATUS_ENABLE = 0;//可用
	int OPER_PRODUCT_STATUS_DISABLE = 1;//不可用
	//订价类型
	int RATED_NORMAL = 0;//正常价
	int RATED_UNNORMAL = 1;//促销价
	//视频状态
	int VIDEO_ENABLE = 1;//可用
	int VIDEO_DISENABLE = 0;//不可用
	//视频价格状态
	int VIDEO_FREE = 0;//免费
	int VIDEO_CHARGE = 1;//收费
	//产品类型
	int PRODUCT_ALL = 1;//全科
	int PRODUCT_ONLY = 2;//单科
	int PRODUCT_SPECIAL = 3;//专题
    //用户信息查询接口
    String USER_INFO_URL = ConstantConfig.getProperty("IP")+"/bhms/webservice/getUserInfo.action?card=%s&cardType=%s";
    String QRCODE_URL = ConstantConfig.getProperty("QrUrl")+"/xxjMobileAPI/Order/OrderIndex.do?p=%s&c=%s&t=%s&o=%s&u=%s&j=%s";
    //Boss接口参数
    String QUERY_TYPE = ConstantConfig.getProperty("queryType");
    String CHANNEL_CODE = ConstantConfig.getProperty("channelCode");
    String PLATFORM_ID = ConstantConfig.getProperty("platformId");
    //图片服务器URL
    String IMG_SERVER = ConstantConfig.getProperty("img_server");
    //redis config
    String HOST = ConstantConfig.getProperty("host");
    String PORT = ConstantConfig.getProperty("port");
    String DB = ConstantConfig.getProperty("db");
    //redis key
    String NOTICE = ConstantConfig.getProperty("noticeKey");
    String RECORD_VIDEO_LIST = ConstantConfig.getProperty("recordListKey");
    String CARD = ConstantConfig.getProperty("cardKey");
    String USER = ConstantConfig.getProperty("userKey");
    String HOME_LIST = ConstantConfig.getProperty("homeListKey");
    String HOME_OBJ = ConstantConfig.getProperty("homeObjKey");
    String HOME_VIDEO_LIST = ConstantConfig.getProperty("homeVideoListKey");
    String CONTENT_JSON = ConstantConfig.getProperty("contentJsonKey");
    String SPECIAL_JSON = ConstantConfig.getProperty("specialJsonKey");
    String SYN_PRODUCT_LIST = ConstantConfig.getProperty("productListKey");
    String SPECIAL_PRODUCT_LIST = ConstantConfig.getProperty("specialListKey");
	String PRODUCT_OBJ = ConstantConfig.getProperty("productObjKey");
	String CONTENT_OBJ = ConstantConfig.getProperty("contentObjKey");
	String SPECIAL_OBJ = ConstantConfig.getProperty("specialObjKey");
	String TEMPLATE_OBJ = ConstantConfig.getProperty("templateObjKey");
    String XUED_OBJ = ConstantConfig.getProperty("xuedObjKey");
    String GRADE_OBJ = ConstantConfig.getProperty("gradeObjKey");
    String SUBJECT_OBJ = ConstantConfig.getProperty("subjectObjKey");
    String TERM_OBJ = ConstantConfig.getProperty("termObjKey");
    String XUED_LIST = ConstantConfig.getProperty("xuedListKey");
    String GRADE_PRODUCT = ConstantConfig.getProperty("gradeProductKey");
    String XUED_GRADE_LIST = ConstantConfig.getProperty("xuedGradeListKey");
    String VIDEO_URL = ConstantConfig.getProperty("videoUrlKey");
    String GRADE_SUBJECT_LIST = ConstantConfig.getProperty("gradeSubjectListKey");
    String TEACHER_GRADE_LIST = ConstantConfig.getProperty("teacherGradeListKey");
    String TEACHER_SUBJECT_LIST = ConstantConfig.getProperty("teacherSubjectListKey");
	String TEACHER_OBJ = ConstantConfig.getProperty("teacherObjKey");
    String POINT_OBJ = ConstantConfig.getProperty("pointObjKey");
    String VIDEO_OBJ = ConstantConfig.getProperty("videoObjKey");
	String SUBJECT_JSON = ConstantConfig.getProperty("teacherSubjectJsonKey");
	String FREE_VIDEO_LIST = ConstantConfig.getProperty("freeVideoListKey");


	/*****************************uflowertv_wx********************************************/
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
