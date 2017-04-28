package com.util.ctvit.vdp.commons;

public class Constants {
	/******************* 存储类型 *************************/
	public final static String STORAGE_ACHIEVE_MATERIAL = "materialArchiveStorage";//素材归档存储
	public final static String STORAGE_PRODUCT = "productStorage";//成品存储
	public final static String STORAGE_BEGINANDEND = "titlesCreditsStorage";//片头片尾存储
	public final static String STORAGE_ADVERTISE = "adStorage";//广告存储
	public final static String STORAGE_RECOVER_PRODUCT = "productRecyclingStorage";//成品回收存储
	public final static String STORAGE_BEGINANDEND_PUBLISH = "titlesCreditsPostStorage";//片头片尾发布存储
	public final static String STORAGE_ADVERTISE_PUBLISH = "adPostStorage";//广告发布存储
	public final static String STORAGE_CODE_TEMP = "transcodeTempStorage";//转码临时存储
	public final static String STORAGE_IMAGE = "imageStorage";//图片存储
	public final static String STORAGE_LIVE_CACHE = "liveCacheStorage";//直播缓存存储
	public final static String STORAGE_PORTAL_PAGE = "portalPageStorage";//门户页面存储
	public final static String STORAGE_EPG_BK = "bcEPGStorage";//播控EPG区
	public final static String STORAGE_IMAGE_BK = "bcImageStorage";//播控图片区
	public final static String STORAGE_VIDEO_BK = "bcVideoStorage";//播控视频区

	/******************* 存储访问方式 ************************/
	public final static String ACCESS_PLAY = "internalPlay";
	public final static String ACCESS_FILEMOVE = "fileMove";
	public final static String ACCESS_UNC_PATH = "uncPath";
	public final static String ACCESS_UNC_RULE = "uncRule";
	public final static String ACCESS_PUBLISH = "postPreview";
	
	/******************* 文件组类型************************/
	public final static String GROUPTYPE_SD = "标清";
	public final static String GROUPTYPE_HD = "高清";
	public final static String GROUPTYPE_UHD = "超高清";
	
	/*******************任务状态************************/
	public final static String TASK_STATUS_WAITING = "待处理";
	public final static String TASK_STATUS_SUCCESS = "处理成功";
	public final static String TASK_STATUS_DOING = "处理中";
	public final static String TASK_STATUS_ERROR = "处理失败";
	public final static String TASK_STATUS_CANCEL = "被取消";
	public final static String TASK_CANCEL = "人工取消";
	
	/*******************成品编目状态************************/
	public final static String PRODUCT_CATA_STATUS_WAITING = "未编目";
	public final static String PRODUCT_CATA_STATUS_FINISHED = "已编目";
	/*******************成品状态************************/
	public final static String PRODUCT_STATUS_WAIT_AUDIT = "待审核";
	public final static String PRODUCT_STATUS_FAIL_AUDIT = "审核未通过";
	public final static String PRODUCT_STATUS_NOT_PUBLISH = "未发布";
	public final static String PRODUCT_STATUS_DOING = "发布中";
	public final static String PRODUCT_STATUS_SUCCESS = "发布成功";
	public final static String PRODUCT_STATUS_FAILURE = "发布失败";
	public final static String PRODUCT_STATUS_CANCAL = "人工取消";
	
	/*******************回收类型************************/
	
	
	/*******************配置相关属性************************/
//	public final static String PUDUCT_AUTO_PUBLISH = "product_auto_publish";
	public final static String PUDUCT_AUDIT = "product_audit";
	public final static String MCP_CALLBACK_SERVICE = "McpCallbackService";
	public final static String PUBLISH_XML_FILE = "PublishXmlFile";
	public final static String SORL_SERVER_URL = "SolrServerUrl";
	// 扫描收录文件存储路径根目录
	public final static String RECORD_ROOTPATH = "RecordRootPath";
	public final static String PUBLISH_PREVIEW_ROOT = "PublishPreviewRoot";
	public final static String TRANSCODE_SERVICE_URL = "TranscodeServiceURL"; 
//	public final static String TRANSCODE_TARGET_PATH = "TranscodeTargetPath"; 
	public final static String CMS_POST_URL = "CmsPostUrl"; 
	public final static String BTVCMS_POST_URL = "BTVCmsPostUrl"; 
	public final static String CTVIT_BC_POST_URL = "CtvitBcUrl"; 
	public final static String TO_QEDIT = "toQdiet"; 
	
	/*******************分类值************************/
	public final static String CHANNEL_PART = "sort2";
	public final static String PROGRAM_TYPE = "sort1";
	
	public final static String SYSTEMCONF_IDENT_SOLR = "SolrServerUrl";
	
	public final static String GETDURIATION = "获取时长";
	public final static String PREVIEWIMAGE = "预览图";
	public final static String GENERALIMAGE = "缩略图";
	
	/*******************成品所属************************/
	public final static String CHANNEL_PRODUCT = "channel";
	public final static String PROGRAM_PRODUCT = "program";
	public final static String TOPIC_PRODUCT = "topic";
	
	/*******************直轮播单************************/
	public final static int FORM_STATUS_NOT_PUBLISH = 0;
	public final static int FORM_STATUS_DOING = 1;
	public final static int FORM_STATUS_SUCCESS = 2;
	public final static int FORM_STATUS_FAILURE = 3;
	
	/*******************加密密钥************************/
	public final static String SPKEY = "ctvit";
	
	/*******************EPG节目单名称************************/
	public final static String EPGNAME = "EPG";
	
	/******************* memcache缓存key ************************/
	public final static String MEMCACHE_LIFETASK = "lifetask";
	
}
