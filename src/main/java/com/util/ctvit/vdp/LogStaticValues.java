package com.util.ctvit.vdp;

import java.util.Arrays;
import java.util.List;

/**
 * 日志常量表
 * */
public class LogStaticValues {
	
	public static String LOG4J = "log4j";
	public static String ROOT_CATEGORY=LOG4J+".rootCategory";//根记录器
	public static String LAYOUT = "layout";//格式
	public static String APPENDER = LOG4J+".appender";//输出
	public static String LOGGER = LOG4J+".logger";//输出
	public static String Conversion = "ConversionPattern";//自定义格式
	
	//日志级别常量
	public static String LEVEL_DEBUG = "DEBUG";
	public static String LEVEL_INFO = "INFO";
	public static String LEVEL_WARN = "WARN";
	public static String LEVEL_ERROR = "ERROR";
	public static String LEVEL_FATAL = "FATAL";
	public static String LEVEL_OFF = "OFF";
	
	/*输出方式常量
	org.apache.log4j.HTMLLayout（以HTML表格形式布局），
	org.apache.log4j.PatternLayout（可以灵活地指定布局模式），
	org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串）
	*/
	public static String LAYOUT_HTML = "org.apache.log4j.HTMLLayout";
	public static String LAYOUT_PATTERN = "org.apache.log4j.PatternLayout";
	public static String LAYOUT_SIMPLE = "org.apache.log4j.SimpleLayout";
	public static String LAYOUT_CONVERSIONPATTER = "ConversionPattern";
	/*
	1.	org.apache.log4j.ConsoleAppender（控制台），
	2.	org.apache.log4j.FileAppender（文件），
	3.	org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），
	4.	org.apache.log4j.RollingFileAppender （文件大小到达指定尺寸的时候产生一个新的文件）
	*/
	public static String APPENDER_CONSOLE = "org.apache.log4j.ConsoleAppender";
	public static String APPENDER_FILE = "org.apache.log4j.FileAppender";
	public static String APPENDER_DailyRolling = "org.apache.log4j.DailyRollingFileAppender";
	public static String APPENDER_RollingFile = "org.apache.log4j.RollingFileAppender";
	
	public static List<String> appenderList = Arrays.asList("console", "file", "dailyRollingFile","rollingFile");
	/*
	 * 文件回滚用到此变量
	 * log4j.appender.R.MaxFileSize 设置文件大小
	 * log4j.appender.R.MaxBackupIndex设置为保存备份文件个数
	 * */
	public static String DailyRolling_MaxFileSize = "MaxFileSize";
	public static String DailyRolling_MaxBackupIndex = "MaxBackupIndex";
	
	public static String LAYOUT_MODEL = "%d %-5p (%c[method:%M]:%L) - %m%n";
}
