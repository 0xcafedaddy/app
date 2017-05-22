package com.util.date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * 
 * 版权所有：2017年3月15日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：时间日期转换工具类
 * 类名称：com.uflowertv.util.DateTimeUtil     
 * 创建人：liguoliang 
 * 创建时间：2017年3月15日 上午10:46:40   
 * 修改人：
 * 修改时间：2017年3月15日 上午10:46:40   
 * 修改备注：   
 * @version   V1.0
 */
public class DateTimeUtil {

	/**
	 * 将日期转换为字符串
	 * @Title: transDateToString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param date
	 * @return
	 */
	public static String transDateToString(Date date){
		return new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 将字符串转为日期
	 * @Title: transStringToDate
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param date
	 * @return
	 */
	public static Date transStringToDate(String date){
		return transStringToDateTime(date).toDate();
	}
	
	/**
	 * 将字符串转为DateTime
	 * @Title: transStringToDateTime
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param date
	 * @return
	 */
	public static DateTime transStringToDateTime(String date){
		return DateTime.parse(date,DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 获取当前时间与指定时间差(天)
	 * @Title: getDays
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param date
	 * @return
	 */
	public static int getDays(String date){
		DateTime dateTime = transStringToDateTime(date);
		LocalDate currentDate = new LocalDate(new DateTime()); 
	    LocalDate timeDate = new LocalDate(dateTime);    
	    return Days.daysBetween(currentDate, timeDate).getDays();
	}

	/**
	 * 获取当前时间与指定时间差(天)
	 * @Title: getDays
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param date
	 * @return
	 */
	public static int getDays(Date date){
		DateTime dateTime = new DateTime(date);
		LocalDate currentDate = new LocalDate(new DateTime()); 
		LocalDate timeDate = new LocalDate(dateTime);    
		return Days.daysBetween(currentDate, timeDate).getDays();
	}
	
	
	public static void main(String[] args) {
		DateTime dateTime = transStringToDateTime("2017-03-25 17:51:00");
		LocalDate currentDate = new LocalDate(new DateTime()); 
	    LocalDate timeDate = new LocalDate(dateTime);    
	    int days = Days.daysBetween(currentDate, timeDate).getDays();
	    System.out.println(days);
	}
}
