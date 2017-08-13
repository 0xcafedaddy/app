package com.uflowertv.util;

import com.util.date.FormateTime;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Date Utility Class This is used to convert Strings to Dates and Timestamps
 * 
 * <p>
 * <a href="DateUtil.java.html"><i>View Source</i></a>
 * </p>
 *	日期工具类
 * @author <a hres should be mm not MM (MM is month).
 * @version $Revision: 1.0.0.1 $ $Date: 2006/08/30 13:59:59 $
 */
public class DateUtil {

	private static String defaultDatePattern = null;
	
	private static String timePattern = "HH:mm";

	/**
	 * Return default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static synchronized String getDatePattern() {
		Locale locale = LocaleContextHolder.getLocale();
		try {
			/* extract default date pattern from application context */
			defaultDatePattern = ResourceBundle.getBundle(
					"ApplicationResources", locale).getString("date.format");
		} catch (MissingResourceException mse) {
			defaultDatePattern = "yyyy-MM-dd";
		}

		return defaultDatePattern;
	}

	/**
	 * Return default datetimePattern (MM/dd/yyyy HH:mm:ss.S)
	 * 
	 * @return a string representing the datetime pattern on the UI
	 */
	public static String getDateTimePattern() {
		return DateUtil.getDatePattern() + " HH:mm:ss";
	}

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";
		if (aDate != null) {
			df = new SimpleDateFormat(getDatePattern());
			returnValue = df.format(aDate);
		}
		return returnValue;
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see SimpleDateFormat
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}
		return (date);
	}

	public static Date convertXMLGregorianCalendar(XMLGregorianCalendar xmlcal) {
		GregorianCalendar grecal = xmlcal.toGregorianCalendar();
		return grecal.getTime();
	}

	public static XMLGregorianCalendar getXMLGregorianCalendar(
			String lexicalRepresentation) throws DatatypeConfigurationException {
		DatatypeFactory dtf = DatatypeFactory.newInstance();
		return dtf.newXMLGregorianCalendar(lexicalRepresentation);
	}
	
	public static XMLGregorianCalendar getXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {	
		GregorianCalendar c = new GregorianCalendar(); 
		c.setTime(date); 
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	}

	public static XMLGregorianCalendar getXMLGregorianCalendar() {

		try {
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar
					.getInstance();
			return dtf.newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e) {
			return null;
		}
	}

	public static long getTimeAlong(Date before, Date after) {
		return after.getTime() - before.getTime();
	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see SimpleDateFormat
	 */
	public static final String getDateTime(String format, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";
		if (aDate != null) {
			df = new SimpleDateFormat(format);
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(getDateTimePattern(), aDate);
	}
	
	public static final String convertDateToString(Date aDate,String pattern) {
		return getDateTime(pattern, aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;
		try {
			aDate = convertStringToDate(getDatePattern(), strDate);
		} catch (ParseException pe) {
			//pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}
		return aDate;
	}

	public static java.sql.Timestamp currentSQLTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	public static java.sql.Date currentSQLDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	public static java.sql.Date getSQLDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static java.sql.Timestamp getSQLTimestamp(Date date) {
		return new java.sql.Timestamp(date.getTime());
	}

	public static Date toDate(String strValue) {
		SimpleDateFormat fmt = null;

		if (strValue.indexOf('.') > 0) {
			fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);// 2005-01-01
			// 10:10:10.100
		} else if (strValue.indexOf(':') > 0) {
			fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 2005-01-01
			// 10:10:10.100
		} else if (strValue.indexOf('-') > 0) {
			fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);// 2005-01-01
			// 10:10:10.100
		}

		try {
			return fmt.parse(strValue);
		} catch (ParseException ex) {
			return new Date(0);// ����1970-01-01 00:00:00
		}
	}

	public static java.sql.Timestamp toSQLTimestamp(String strValue) {
		return (new java.sql.Timestamp(toDate(strValue).getTime()));
	}

	public static String getSQLDateTimeStr(Date date) {
		java.sql.Date sql_date = new java.sql.Date(date.getTime());
		java.sql.Time sql_time = new java.sql.Time(date.getTime());
		return sql_date + " " + sql_time;
	}
	
	//��ȡXMLGregorianCalendar��ʽ������
	public static XMLGregorianCalendar getXMLDate(String str) {
		if ((null == str) || ("".equals(str.trim())) ) {
			return DateUtil.getXMLGregorianCalendar();
		}
		
		try {
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			XMLGregorianCalendar xcal = dtf.newXMLGregorianCalendar(str);
			return xcal;
		} catch (Exception e) {
			return DateUtil.getXMLGregorianCalendar();
		}		
	}
	
	public static Date getNowTime(String format) {
			return toDate(getDateTime(format,new Date()));
	}
	
	// 获取某时间second秒之后的时间
	public static Date getDateTimeAfter(Date date,int second) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.SECOND, second);
		return cal.getTime();
	}

	public static void main(String[] args) throws ParseException {
		long sec = (toDate("2013-12-14 04:34:07").getTime() - toDate("2013-12-14 04:33:18").getTime())/1000;
		System.out.println(FormateTime.formateTimes(sec));
	}
}
