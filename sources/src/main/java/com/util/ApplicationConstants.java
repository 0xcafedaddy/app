package com.util;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 版权所有：2017年2月23日-油菜花
 * 项目名称：uflowertv_wx   
 *
 * 类描述：系统信息记录工具类
 * 类名称：com.uflowertv.util.ApplicationConstants     
 * 创建人：liguoliang 
 * 创建时间：2017年2月23日 下午5:47:03   
 * 修改人：
 * 修改时间：2017年2月23日 下午5:47:03   
 * 修改备注：   
 * @version   V1.0
 */
public class ApplicationConstants {

	// 所有的 Session
	public static Map<String, HttpSession> SESSION_MAP = new HashMap<String, HttpSession>();

	// 当前登录的用户总数
	public static int CURRENT_LOGIN_COUNT = 0;

	// 历史访客总数
	public static int TOTAL_HISTORY_COUNT = 0;

	// 服务器启动时间
	public static Date START_DATE = new Date();

	// 最高在线时间
	public static Date MAX_ONLINE_COUNT_DATE = new Date();

	// 最高在线人数
	public static int MAX_ONLINE_COUNT = 0;
}
