package com.util.date;

import java.text.ParseException;

public class FormateTime {

	public static String convertTime(int secTime) {
		int hour = secTime/3600;
		int lastTime = secTime - hour*3600;
		int minutes = lastTime/60;
		lastTime -= minutes*60;
		int second = lastTime;
		String hourStr = "";
		String minStr = "";
		String secStr = "";
		if(hour < 10){
			hourStr = "0"+hour;
		}else{
			hourStr = String.valueOf(hour);
		}
		
		if(minutes < 10){
			minStr = "0"+minutes;
		}else{
			minStr = String.valueOf(minutes);
		}
		
		if(second < 10){
			secStr = "0"+second;
		}else{
			secStr = String.valueOf(second);
		}
		
		return hourStr+":"+minStr+":"+secStr;
	}
	
	/**
	 * 字符串（00:00:00.000）转换为时长（毫秒）
	 * @param durationstr
	 * @return
	 */
	public static long parseLong(String durationstr) {
		if (durationstr == null || durationstr.equals(""))
			return 0;
		long duration = 0;
		String hms = durationstr.substring(0, durationstr.lastIndexOf("."));
		String millisecondstr = durationstr.substring(durationstr.lastIndexOf(".")+1);
		int millisecond = 0;
		if(millisecondstr.startsWith("00")) {
			millisecond = Integer.valueOf(millisecondstr.substring(2)).intValue();
		}else if(millisecondstr.startsWith("0")) {
			millisecond = Integer.valueOf(millisecondstr.substring(1)).intValue();
		}else {
			millisecond = Integer.valueOf(millisecondstr).intValue();
		}
		String[] durarr = hms.split(":");
		if (durarr.length != 3)
			return 0;
		try {
			duration += Long.parseLong(durarr[0].trim()) * 3600 * 1000;
			duration += Long.parseLong(durarr[1].trim()) * 60 * 1000;
			duration += Long.parseLong(durarr[2].trim()) * 1000;
			duration += millisecond;
			return duration;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//格式化时间
	public static String formateTimes(long timevalue) {
		long hour = timevalue/3600;
		long minutes = (timevalue%3600)/60;
		long seconds = timevalue%60;
		String returnStr = "";
		if(hour != 0){
			returnStr+=(hour+"小时");
		}
		if(minutes != 0){
			returnStr+=(minutes+"分钟");
		}
		if(seconds != 0){
			returnStr+=(seconds+"秒");
		}
		return returnStr;
	}
	
	public static void main(String[] args) throws ParseException {

		System.out.println(convertTime(3));
	}
}
