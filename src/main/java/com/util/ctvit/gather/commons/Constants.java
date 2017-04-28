package com.util.ctvit.gather.commons;

public class Constants {
	/******************* 存储类型 *************************/
	public final static String STORAGE_CODE_TEMP = "转码临时存储";
	public final static String STORAGE_IMAGE = "图片存储";

	public final static String STORAGE_USER_UPLOAD = "useruploadneedcode";//用户转码上传
	public final static String STORAGE_USER_UPLOAD_TRANCE = "userupload";//用户上传
	public final static String STORAGE_USER_UPLOAD_AUDIOS = "useruploadMp3";//音频存储
	public final static String STORAGE_USER_UPLOAD_NETFILES = "useruploadNetfiles";//网络抓取

	/******************* 存储访问方式 ************************/
	public final static String ACCESS_PLAY = "internalPlay";//系统内部播放
	public final static String ACCESS_FILEMOVE = "fileMove";//文件迁移
	public final static String ACCESS_UNC_PATH = "uncPath";//UNC路径
	public final static String ACCESS_UNC_RULE = "uncRule";//UNC规则
	public final static String ACCESS_PUBLISH = "postPreview";//发布预览

	/*******************分类值************************/
	public final static String CHANNEL_PART = "sort2";
	public final static String PROGRAM_TYPE = "sort1";

	/*******************加密密钥************************/
	public final static String SPKEY = "ctvit";

	/*******************配置文件路径************************/
	public final static String APPLICATION_PATH = "./config/applicationContext.xml";
	public final static String APPLICATION_WS_PATH = "./config/applicationContext-wsclient.xml";

	/*******************任务状态***********************
	 * -1 待处理，1处理中，0成功 2 失败
	 * */
	public final static int TASK_STATUS_WAITING = -1;
	public final static int TASK_STATUS_SUCCESS = 0;
	public final static int TASK_STATUS_DOING = 1;
	public final static int TASK_STATUS_ERROR = 2;
	public final static int TASK_STATUS_CANCEL = 3;
	public final static int TASK_CANCEL = 4;

	/*******************流程类型************************/
	public final static int FLOWNODE_TRANSCODE = 1;
	public final static int FLOWNODE_GETDURING = 2;
	public final static int FLOWNODE_IMPORT = 3;
	public final static int FLOWNODE_MOVE = 4;
	public final static int FLOWNODE_AUDIT = 6;
	public final static int FLOWNODE_UPLOAD = 7;
	public final static int FLOWNODE_REGISTER = 8;
	public final static int FLOWNODE_SHARE = 9;//资源分享
	public final static int FLOWNODE_CLOUDEXCHANGE = 10;//迁移
	public final static int FLOWNODE_UPLOAD_FTP = 11;//ftp 上传
	public final static int FLOWNODE_REMOVE = 12;//资源移交
	public final static int FLOWNODE_COMPOSE = 13;//合成

	/******************* memcache缓存key ************************/
	public final static String MEMCACHE_MATERIAL = "material";
	public final static String MEMCACHE_STRATEGY = "Strategy";
	public final static String MEMCACHE_SYSTEM_REG = "SystemRegistered";
	public final static String MEMCACHE_MONITOR_DIR = "MonitorDir";
	public final static String MEMCACHE_VIDEOCACHEMAINTASK = "VideoCacheMainTask";
	public final static String MEMCACHE_VIDEOFILESUBTASK = "VideoCacheSubTask";

	public final static String ACCESSMODE = "accessMode";

	/******************* 配置类型 ************************/
	public final static String BUSINESSSYSTEM = "BusinessSystem";//业务系统（素材类型）
	public final static String FILEFORMAT = "FileFormat";//文件格式
	public final static String MONITORING = "Monitoring";//监控配置(目录健康监控)
	public final static String PROCESSCLASS = "ProcessClass";//扫描处理类
	public final static String PROCESSNODE = "ProcessNode";//流程节点
	public final static String TARGETSYSTEM = "TargetSystem";//目标系统
	public final static String TASKSTATUS = "TaskStatus";//任务处理状
	public final static String MCPPARAMTER = "McpParamter";//管控平台参数
}
