package com.util.ctvit.gather;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author calvin
 * @see Converter
 */
public class DateConverter implements Converter {
	private static final Log log = LogFactory.getLog(DateConverter.class);

	private final  DateFormat format;
	private static DateFormat myFormat;
	public static String FORMATType_TIME = "yyyy-MM-dd HH:mm:ss";
	public static String FORMATType_TIME_MM = "yyyy-MM-dd HH:mm";
	public static String FORMATType_DAY = "yyyy-MM-dd";
	private final static TimeZone timeZone = TimeZone.getTimeZone("GMT+08:00");
	private static Date date = new Date(); 
	/**
	 * 二十四小时制： “yyyy-MM-dd HH:mm:ss”
	         十二小时制： “"yyyy-MM-dd hh:mm:ss"”
	 * 
	 * */
	
	public DateConverter(String formatPattern) {
		if (StringUtils.isNotBlank(formatPattern)) {
			format = new SimpleDateFormat(formatPattern);
		} else {
			format = new SimpleDateFormat("yyyy-MM-dd");
		}
	}
	
	public DateConverter() {
		format = new SimpleDateFormat("yyyy-MM-dd");
	}
	public static String convertDateToStr(String formatType, Date date){
		try {
			myFormat = new SimpleDateFormat(formatType);	
			return myFormat.format(date);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	/**
	 * 转换日期
	 * 2012-12-02 12:20:00
	 * */
	public static Date converDate(String formatType, Object value){
		try {
			String dateStr = (String) value;
			myFormat = new SimpleDateFormat(formatType);	
			if (StringUtils.isNotBlank(dateStr)) {
				return myFormat.parse(dateStr);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	public static Date convert(String formatType, Object value) {
		try {
			String dateStr = (String) value;
			myFormat = new SimpleDateFormat(formatType);	
			if (StringUtils.isNotBlank(dateStr)) {
				return myFormat.parse(dateStr);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	/**
	 * 输入String 类型时间，转换成Timestamp时间
	 * 如果未输入 则返回当前Timestamp类型时间 
	 * */
	public static Timestamp convertTimestamp(String formatType, Object value) {
		try {
			String dateStr = (String) value;
			myFormat = new SimpleDateFormat(formatType);	
			if (StringUtils.isNotBlank(dateStr)) {
				return new Timestamp(myFormat.parse(dateStr).getTime());
			}
			else{
				return new Timestamp(date.getTime()); 
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	public Object convert(@SuppressWarnings("rawtypes") Class arg0, Object value) {
		try {
			String dateStr = (String) value;

			if (StringUtils.isNotBlank(dateStr)) {
				return format.parse(dateStr);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date){
		GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {

             e.printStackTrace();
        }
        return gc;
	}
	/**
	 * 获取当前时间
	 * */
	public static String getNowTime(){
		myFormat = new SimpleDateFormat(FORMATType_TIME);
		String date = myFormat.format(new Date());
		return date.substring(date.length()-8, date.length());
		
	}
	/**
	 * 获取当前日期时间
	 * */
	public static String getNowDateTime(){
		myFormat = new SimpleDateFormat(FORMATType_TIME);
		String date = myFormat.format(new Date());
		return date;
		
	}
	/**
	 * 将一个字符串的日期描述转换为java.util.Date对象
	 *
	 * @param strDate
	 *            字符串的日期描述
	 * @param format
	 *            字符串的日期格式，比如:“yyyy-MM-dd HH:mm”
	 * @return 字符串转换的日期对象java.util.Date
	 */
	public static Date getDate(String format,String strDate) {
		if (strDate == null || strDate.trim().equals("")) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setTimeZone(timeZone);
		Date date;
		try {
			date = formatter.parse(strDate);
		} catch (ParseException e) {
			date = null;
		}
		return date;
	}
	public static void main(String[] args) throws ParseException{
//		myFormat.parse(source)
//		Date start = (Date) DateConverter.convert(FORMATType_TIME_MM, "2014-03-27 00:00");
//		Date end = (Date) DateConverter.convert(FORMATType_TIME_MM, "2014-03-27 12:00");
//		String date = "2014-03-27 12:00";
//		date = date.replace("-", "").replace(" ", "").replace(":", "");
//		SimpleDateFormat FMT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		Calendar c = Calendar.getInstance();
		/**
		System.out.println(end.getTime() - start.getTime());
		System.out.println(FMT.parse("2014-03-27 12:00"));
		System.out.println(end);
		System.out.println(start);
		System.out.println(1/2);
		System.out.println(1%2);
		System.out.println(30/6);
		System.out.println(31/6);
		System.out.println(30%6);
		System.out.println(35%6);
		*/
//		Date d = new Date();
//		long dl = d.parse("2014-03-27 15:37:00");
//		c.setTimeInMillis(dl);
//		System.out.println(c.getTime());
//		c.set(d.getYear(), d.getMonth(), d.getDate(), 15, 37, 00);
//		System.out.println(d.getYear());
//		System.out.println(c.getTime());
	}
	
}
