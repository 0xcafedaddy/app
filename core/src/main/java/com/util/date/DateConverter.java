package com.util.date;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

	public static List getBetweenTime(String startTime, String endTime) {
		List<String> str = new ArrayList<String>();
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int i = 0;
			Date startDate = df.parse(startTime);
			startCalendar.setTime(startDate);
			Date endDate = df.parse(endTime);
			endCalendar.setTime(endDate);
			while (startCalendar.getTimeInMillis() < endCalendar
					.getTimeInMillis()) {
				str.add(df.format(startCalendar.getTime()));
				// System.out.println(df.format(startCalendar.getTime()));
				startCalendar.add(Calendar.DAY_OF_MONTH, 1);
				i++;

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;

	}


	/**
	 * 判断是否有效
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public static boolean isValidate(String beginTime, String endTime) {
		Date begin = null;
		Date end = null;
		Date now = new Date();
		try{
			if (!"".equals(beginTime)&&""!=beginTime) {
				begin = getDateFromStandardDate(beginTime);
			}
			if (!"".equals(endTime)&&""!=endTime) {
				end = getDateFromStandardDate(endTime);
			}

		}catch(ParseException e){
			e.printStackTrace();
		}

		int i = compareToDay(begin, now);
		int j = compareToDay(now, end);
		//判断是否在有效期 0：=  -1：<  1:>
		boolean flag = false;
		if (begin == null && end != null) {
			if (j < 1) {
				flag = true;
			}
		} else if (begin != null && end == null) {
			if (i < 1) {
				flag = true;
			}
		} else if (begin == null && end == null) {
			flag = true;
		} else {//都不为空
			if (i < 1 && j < 1) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 比较两个日期的先后顺旬 按天比较日期
	 *
	 * @param date1
	 * @param date2
	 * @return 0:相等，-1:date1<date2,1:date1>date2
	 */
	public static int compareToDay(Date date1, Date date2) {
		try {
			if (date1 != null && date2 == null) {
				return -1;
			} else if (date1 == null && date2 != null) {
				return 1;
			} else if (date1 == null && date2 == null) {
				return 0;
			}
			// 通过字符串，将时间简化到日。
			String dateBegin = getSpecifiedStandardDate(date1);
			String dateEnd = getSpecifiedStandardDate(date2);
			Date d1 = getDateFromStandardDate(dateBegin);
			Date d2 = getDateFromStandardDate(dateEnd);
			// 比较时间
			long time1 = d1.getTime();
			long time2 = d2.getTime();
			if (time1 == time2) {
				return 0;
			} else if (time1 < time2) {
				return -1;
			} else {
				return 1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getSpecifiedStandardDate(Date date) {
		// Date date = new Date(second * 1000);
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * 根据标准格式的日期字符串得到对应的Date对象,标准格式如下:"2005-03-23".
	 *
	 * @return 时间字符串对应的Date对象.
	 */
	public static Date getDateFromStandardDate(String standardDate) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(standardDate);
	}
	/**
	 * 判断时间（HH:mm:ss）是否在时间段内
	 *
	 * @param date
	 *            当前时间 yyyy-MM-dd HH:mm:ss
	 * @param strDateBegin
	 *            开始时间 00:00:00
	 * @param strDateEnd
	 *            结束时间 00:05:00
	 * @return
	 */
	public static boolean isInDate(Date date, String strDateBegin,
								   String strDateEnd) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = sdf.format(date);
		// 截取当前时间时分秒
		int strDateH = Integer.parseInt(strDate.substring(11, 13));
		int strDateM = Integer.parseInt(strDate.substring(14, 16));
		int strDateS = Integer.parseInt(strDate.substring(17, 19));
		// 截取开始时间时分秒
		int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));
		int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));
		int strDateBeginS = Integer.parseInt(strDateBegin.substring(6, 8));
		// 截取结束时间时分秒
		int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));
		int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));
		int strDateEndS = Integer.parseInt(strDateEnd.substring(6, 8));
		if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {
			// 当前时间小时数在开始时间和结束时间小时数之间
			if (strDateH > strDateBeginH && strDateH < strDateEndH) {
				return true;
				// 当前时间小时数等于开始时间小时数，分钟数在开始和结束之间
			} else if (strDateH == strDateBeginH && strDateM >= strDateBeginM
					&& strDateM <= strDateEndM) {
				return true;
				// 当前时间小时数等于开始时间小时数，分钟数等于开始时间分钟数，秒数在开始和结束之间
			} else if (strDateH == strDateBeginH && strDateM == strDateBeginM
					&& strDateS >= strDateBeginS && strDateS <= strDateEndS) {
				return true;
			}
			// 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数
			else if (strDateH >= strDateBeginH && strDateH == strDateEndH
					&& strDateM <= strDateEndM) {
				return true;
				// 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数等于结束时间分钟数，秒数小等于结束时间秒数
			} else if (strDateH >= strDateBeginH && strDateH == strDateEndH
					&& strDateM == strDateEndM && strDateS <= strDateEndS) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	/**
	 * 判断时间(yyyy-MM-dd HH:mm:ss)是否在时间段内
	 *
	 * @param date
	 *            当前时间 yyyy-MM-dd HH:mm:ss（也可以是某个时间）
	 * @param start
	 *            开始时间 yyyy-MM-dd HH:mm:ss
	 * @param end
	 *            结束时间 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	// 判断时间(yyyy-MM-dd HH:mm:ss)是否在时间段内
	public static boolean compareDate(Date start, Date end, Date date) {
		if (date.getTime() >= start.getTime() && date.getTime() <= end.getTime()) {
			return true;
		}
		return false;
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
