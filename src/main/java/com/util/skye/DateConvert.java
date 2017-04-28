package com.util.skye;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateConvert {

	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}

	/**
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String dateTimeToStr(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}
	/**
	 * @param date
	 * @return 时间单号
	 */
	public static String dateTimeToStrs(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sf.format(date);
	}
	/**
	 * 
	 * @param date
	 * @return HH:mm
	 */
	public static String timeToString(Date date) {
		String time = "";
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
			time = sf.format(date);
		}
		return time;
	}

	// �ַ�ת��Ϊʱ��
	/**
	 * 
	 * @param str
	 * @return yyyy-MM-dd
	 */
	public static Date StringToDate(String str) {
		if (str.equals("")) {
			return null;
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return s.parse(str);
		} catch (ParseException e) {
			// 
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 00Z
	 * @param str
	 * @return yyyy-MM-dd HH:mm
	 */
	public static Date StrToDateTime(String str) {
		if (str.equals("")) {
			return null;
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return s.parse(str);
		} catch (ParseException e) {
			// 
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param str
	 * @return HH:mm
	 */
	public static Date StringToTime(String str) {
		if (str.equals("")) {
			return null;
		}
		SimpleDateFormat s = new SimpleDateFormat("HH:mm");
		try {
			return s.parse(str);
		} catch (ParseException e) {
			// 
			e.printStackTrace();
		}
		return null;
	}

	// ��ȡ��������֮�������,������ʼ����
	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @return ��ȡ��������֮�������,������ʼ����
	 */
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
			// 
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



}
