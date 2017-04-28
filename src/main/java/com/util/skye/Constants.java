package com.util.skye;



/**
 * 
 * title : Description : 常量类 Date : 2010-7-28 Company : 新网互联
 * 
 * @author : GaoYang
 * @version : 1.0
 */
public class Constants {

	/**
	    * 公共路径
	    */
	public static final String BASE_PATH=AppPath.getInstance().getWebappPath();
	  // public static final String BASE_PATH="/web/soft/server/tomcat_8080/webapps";	//测试环境
	
	//public static final String BASE_ACCESS_PATH="http://123.56.244.170:9088/WX_Console";	//测试环境
	
	public static final String BASE_ACCESS_PATH=FuncConfig.getProperty("BASE_ACCESS_PATH");
	//public static final String BASE_ACCESS_PATH="http://127.0.0.1:8080/WX_Console";				//本地url返回路径
	//public static final String BASE_PATH="D:/java/tomcat/apache-tomcat-7.0.53/webapps";
	//public static final String IMG_WEB="http://123.56.244.170:8088/img_web/upload";	//测试环境
	public static final String IMG_WEB=FuncConfig.getProperty("IMG_WEB");    //测试环境
//	public static final String IMG_WEB="http://192.168.1.119:8088/img_web/upload";  //本地图片服务器
	
	public static final String BOSS="/businesses";
	public static final String TENEMENT="/tenement";		//物业	
	public static final String NOTICE="/notice";			//公告
	public static final String USER="/user";
	public static final String FEEDBACK="/feedback";
	
	public static final String SHOP = "shop/image";
	
	public static final String TEMP_NAME="/temp";
	public static final String DATA_NAME = IMG_WEB+"/data";
	
	public static final String HOUSING="/house";
	public static final String UPLOAD = "/upload";
	
	
	
	
	// 分页查询中一页显示数量
	public static final int PAGE_SIZE = 10;
	//   public static final String IMG_WEB="/img_server";
	 
	   
	   
	   
	   public static final String ADVERTISING="/advertising";
	   public static final String AGREESING="/source/commonAgreement";
	   // 相对路径

	   //图片上传临时路径
	   public static final String TEMP_PATH=BASE_PATH+TEMP_NAME;
	   public static final String TEMP_ACCESS_PATH=BASE_ACCESS_PATH+TEMP_NAME;
	   
	   
	   //用户图片上传的路径
	   public static final String USER_PATH=BASE_PATH+DATA_NAME+USER;
	   public static final String USER_ACCESS_PATH=BASE_ACCESS_PATH+DATA_NAME+USER;
	   
	   //物业图片上传路径
	   public static final String BIDDING_PATH=BASE_PATH+DATA_NAME+TENEMENT;
	   public static final String BIDDING_ACCESS_PATH=BASE_ACCESS_PATH+DATA_NAME+TENEMENT;
	   
	   //公告图片上传路径
	   public static final String CFD_PATH=BASE_PATH+DATA_NAME+NOTICE;
	   public static final String CFD_ACCESS_PATH=BASE_ACCESS_PATH+DATA_NAME+NOTICE;
	   
	   //广告图片上传路径
	   public static final String ADVERTISING_PATH=BASE_PATH+DATA_NAME+ADVERTISING;
	   public static final String ADVERTISING_ACCESS_PATH=BASE_ACCESS_PATH+DATA_NAME+ADVERTISING;
	   
	   public final static int httpTimeOut = 5 * 60 * 1000;// 调用远程连接时的超时设置,如超过一分钟连不上,报超时异常

	   /**
	     * 照片压缩尺寸分别为大中小
	     */
	   public final static int PAGESIZE = 10;
	   public final static int             PHOTO_WIDTH_FEEDBACK         = 145;
	    public final static int             PHOTO_HEIGHT_FEEDBACK        = 130;
	   
	    public final static int PHOTO_WIDTH_BIG = 640;
	    public final static int PHOTO_WIDTH_MIDSIZE = 250;
	    public final static int PHOTO_WIDTH_SMALL = 100;
	    public static final String USERIMG = "data/userImg";
	    
	    
	    /***
	     * 图片类型 商品图片
	     */
	    public static final Integer IMAGE_TYPE_PRODUCT = 1;
	    
}
