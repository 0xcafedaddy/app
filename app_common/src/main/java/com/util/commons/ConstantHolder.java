package com.util.commons;

import com.util.properties.ConfigReader;

public interface ConstantHolder {
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
	//读取配置文件
	ConfigReader _cr = new ConfigReader("/constant.properties");
    //用户信息查询接口
    String USER_INFO_URL = _cr.get("IP")+"/bhms/webservice/getUserInfo.action?card=%s&cardType=U";
    String QRCODE_URL = _cr.get("QrUrl")+"/xxjMobileAPI/Order/OrderIndex.do?p=%s&c=%s&t=%s&o=%s&u=%s&j=%s";
    //Boss接口参数
    String QUERY_TYPE = _cr.get("queryType");
    String CHANNEL_CODE = _cr.get("channelCode");
    String PLATFORM_ID = _cr.get("platformId");
    //图片服务器URL
    String IMG_SERVER = _cr.get("img_server");
    //redis config
    String HOST = _cr.get("host");
    String PORT = _cr.get("port");
    String DB = _cr.get("db");
    //redis key
    String NOTICE = _cr.get("noticeKey");
    String BLACK_CARD = _cr.get("blackCard");
    String WHITE_CARD = _cr.get("whiteCard");
    String RECORD_VIDEO_LIST = _cr.get("recordListKey");
    String CARD = _cr.get("cardKey");
    String USER = _cr.get("userKey");
    String HOME_LIST = _cr.get("homeListKey");
    String HOME_OBJ = _cr.get("homeObjKey");
    String HOME_VIDEO_LIST = _cr.get("homeVideoListKey");
    String CONTENT_JSON = _cr.get("contentJsonKey");
    String SPECIAL_JSON = _cr.get("specialJsonKey");
    String SYN_PRODUCT_LIST = _cr.get("productListKey");
    String SPECIAL_PRODUCT_LIST = _cr.get("specialListKey");
	String PRODUCT_OBJ = _cr.get("productObjKey");
	String CONTENT_OBJ = _cr.get("contentObjKey");
	String SPECIAL_OBJ = _cr.get("specialObjKey");
	String TEMPLATE_OBJ = _cr.get("templateObjKey");
    String XUED_OBJ = _cr.get("xuedObjKey");
    String GRADE_OBJ = _cr.get("gradeObjKey");
    String SUBJECT_OBJ = _cr.get("subjectObjKey");
    String TERM_OBJ = _cr.get("termObjKey");
    String XUED_LIST = _cr.get("xuedListKey");
    String GRADE_PRODUCT = _cr.get("gradeProductKey");
    String XUED_GRADE_LIST = _cr.get("xuedGradeListKey");
    String VIDEO_URL = _cr.get("videoUrlKey");
    String GRADE_SUBJECT_LIST = _cr.get("gradeSubjectListKey");
    String TEACHER_GRADE_LIST = _cr.get("teacherGradeListKey");
    String TEACHER_SUBJECT_LIST = _cr.get("teacherSubjectListKey");
	String TEACHER_OBJ = _cr.get("teacherObjKey");
    String POINT_OBJ = _cr.get("pointObjKey");
    String VIDEO_OBJ = _cr.get("videoObjKey");
	String SUBJECT_JSON = _cr.get("teacherSubjectJsonKey");
	String FREE_VIDEO_LIST = _cr.get("freeVideoListKey");


    /*****************************uflowertv_wx********************************************/
    //文件远程服务器参数
//	String SERVER_ROOT = "/usr/local/tomcat_8088/webapps/img_web/";
//	String IMG_SERVER = _cr.get("IMG_WEB");
//	String IMG_FLODER = "test/img/";
//	String HTML_FLODER = "test/html/";
    /*******************************************************************************************/
    String FILE_SERVER = _cr.get("file_web");
    String IMG_FLODER =  _cr.get("img_folder");
    String HTML_FLODER =  _cr.get("html_folder");
    //SFTP参数
    String SFTP_REQ_HOST = "123.56.244.170";
    String SFTP_REQ_PORT = "22";
    int SFTP_DEFAULT_PORT = 22;
    String SFTP_REQ_USERNAME = "root";
    String SFTP_REQ_PASSWORD = "19850212Matao";
    //短信参数
    String APIKEY = _cr.get("apikey");
    String SECRETKEY = _cr.get("secretekey");
    String TEMPLATEID = _cr.get("templateid");
    String SMSURL = _cr.get("smsurl");
    String SEND_MESSAGE = _cr.get("sendmessage");
    //微信参数
    String APPID = _cr.get("appid");
    String MPID = _cr.get("mpid");
    String APPSECRET = _cr.get("appsecrete");
    String TOKEN = _cr.get("token");
    String WXTEMPLATEID = _cr.get("wxtemplateid");
    String COMPANY_JS = _cr.get("company_js");
    //百度翻译参数
    String FANYI_APPID = _cr.get("fanyi_appid");
    String FANYI_FROM = _cr.get("fanyi_from");
    String FANYI_TO = _cr.get("fanyi_to");
    String FANYI_SALT = _cr.get("fanyi_salt");
    String FANYI_TOKEN = _cr.get("fanyi_token");

    //微信菜单接口
    String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    //百度翻译接口
    String BAIDUFANYI = "http://api.fanyi.baidu.com/api/trans/vip/translate";

}
