package com.uflowertv.statistics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uflowertv.statistics.dao.StartMapper;
import com.uflowertv.statistics.model.DayActiveCount;
import com.uflowertv.statistics.model.Series;
import com.uflowertv.statistics.model.StartExample;
import com.uflowertv.statistics.model.StartExample.Criteria;
import com.uflowertv.statistics.model.StartJson;
@Service
public class StartService {

	@Autowired
	private StartMapper startMapper;
	
	private StartJson startJsonObj(DateTime start,DateTime end,int count){
		StartJson startJson = new StartJson();
		startJson.setTime(end.getMonthOfYear()+"月"+end.getDayOfMonth()+"日-"+start.getMonthOfYear()+"月"+start.getDayOfMonth()+"日");
		startJson.setPlatformID("联通");
		startJson.setCount(count);
		return startJson;
	}
	
	public Map<String,Object> getDayActiveCount(String start, String end, int currentPage, int pageSize){
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {//不为空
			return map;
		}
		List<DayActiveCount> dayActiveCount = startMapper.getDayActiveList(currentPage,pageSize);
		int count = startMapper.getDayActiveCount();
		map.put("total", count);
		map.put("rows", dayActiveCount);
		return map;
	}
	
	/**
	 * 用户日活跃量（表格）
	 * @param start
	 * @param end
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> list(String start, String end, int currentPage, int pageSize){
		int firstInfo = (currentPage-1)*pageSize;//起始位置
		int total = 0;//总数
		int toIndex = 0;//结束位置
		int count = 0;//不为0的记录
		List<StartJson> list = new ArrayList<StartJson>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {
			 DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
			 DateTime startDateTime = formatter.parseDateTime(start);
			 DateTime endDateTime = formatter.parseDateTime(end);
		     LocalDate starLocalDate=new LocalDate(startDateTime);    
		     LocalDate endLocalDate=new LocalDate(endDateTime);   
		     total = Days.daysBetween(starLocalDate, endLocalDate).getDays();
		     for (int i = 0; i < total;i++) {
				startDateTime=startDateTime.plusDays(1);
				endDateTime=startDateTime.minusDays(1);
				StartExample example = new StartExample();
				Criteria criteria = example.createCriteria().andIdIsNotNull();
				criteria.andDtBetween(endDateTime.toDate(),startDateTime.toDate());
				int countByExample = startMapper.countByExample(example);
				if(countByExample >0){
					count++;
					StartJson startJsonObj = startJsonObj(startDateTime, endDateTime, countByExample);
					list.add(startJsonObj);
				}
			}
		    toIndex = (pageSize*currentPage)>count?count:(pageSize*currentPage);
		    map.put("total", count);
		    map.put("rows", list.subList(firstInfo,toIndex));
		}else{
			DateTime startTime = new DateTime();
			DateTime endTime = new DateTime();
			total = 30;
			for (int i = 0; i < total;i++) {
				startTime=startTime.minusDays(1);
				endTime=startTime.minusDays(1);
				StartExample example = new StartExample();
				Criteria criteria = example.createCriteria().andIdIsNotNull();
				criteria.andDtBetween(endTime.toDate(),startTime.toDate());
				int countByExample = startMapper.countByExample(example);
				if(countByExample>0){
					count++;
					StartJson startJsonObj = startJsonObj(startTime, endTime, countByExample);
					list.add(startJsonObj);
				}
			}
		    toIndex = (pageSize*currentPage)>count?count:(pageSize*currentPage);
			map.put("total", count);
			map.put("rows", list.subList(firstInfo, toIndex));
		}
		return map;
	}
	
	/**
	 * 用户日活跃量（图饼）
	 * @param start
	 * @param end
	 * @return
	 */
	public Map<String,Object> getCharts(String start, String end){
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> categories = new ArrayList<String>();
		List<Series> seriesList = new ArrayList<Series>();
		if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {
			 DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
			 DateTime startDateTime = formatter.parseDateTime(start);
			 DateTime endDateTime = formatter.parseDateTime(end);
		     LocalDate starLocalDate=new LocalDate(startDateTime);    
		     LocalDate endLocalDate=new LocalDate(endDateTime);   
		     int days = Days.daysBetween(starLocalDate, endLocalDate).getDays();
		     if(days>30){
		    	categories.add("最多可查询一个月的用户数据");
		    	Series series = new Series();
		    	series.setValue(0);
		        series.setName("最多可查询一个月的用户数据");
		        seriesList.add(series);
		        map.put("categories", categories);
				map.put("data", seriesList);
				return map;
		     }
		     for (int i = 0; i < days;i++) {
				startDateTime=startDateTime.plusDays(1);
				endDateTime=startDateTime.minusDays(1);
				StartExample example = new StartExample();
				Criteria criteria = example.createCriteria().andIdIsNotNull();
				criteria.andDtBetween(endDateTime.toDate(),startDateTime.toDate());
				int countByExample = startMapper.countByExample(example);
				if(countByExample>0){
					categories.add(endDateTime.getMonthOfYear()+"月"+endDateTime.getDayOfMonth()+"日-"+startDateTime.getMonthOfYear()+"月"+startDateTime.getDayOfMonth()+"日");
					Series series = new Series();
					series.setValue(countByExample);
					series.setName(endDateTime.getMonthOfYear()+"月"+endDateTime.getDayOfMonth()+"日-"+startDateTime.getMonthOfYear()+"月"+startDateTime.getDayOfMonth()+"日");
					seriesList.add(series);
				}
			}
		}else{
			DateTime startTime = new DateTime();
			DateTime endTime = new DateTime();
			for (int i = 0; i < 30;i++) {
				startTime=startTime.minusDays(1);
				endTime=startTime.minusDays(1);
				StartExample example = new StartExample();
				Criteria criteria = example.createCriteria().andIdIsNotNull();
				criteria.andDtBetween(endTime.toDate(),startTime.toDate());
				int countByExample = startMapper.countByExample(example);
				if(countByExample>0){
					categories.add(endTime.getMonthOfYear()+"月"+endTime.getDayOfMonth()+"日-"+startTime.getMonthOfYear()+"月"+startTime.getDayOfMonth()+"日");
					Series series = new Series();
					series.setValue(countByExample);
					series.setName(endTime.getMonthOfYear()+"月"+endTime.getDayOfMonth()+"日-"+startTime.getMonthOfYear()+"月"+startTime.getDayOfMonth()+"日");
					seriesList.add(series);
				}
			}
		}
		map.put("categories", categories);
		map.put("data", seriesList);
		return map;
	}
	public static void main(String[] args) {
		/* String start = "2016-11-09";
		 String end = "2016-12-09";
		 DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		 DateTime startDateTime = formatter.parseDateTime(start);
		 DateTime endDateTime = formatter.parseDateTime(end);
		 LocalDate starLocalDate=new LocalDate(startDateTime);    
		 LocalDate endLocalDate=new LocalDate(endDateTime);    
	    int days = Days.daysBetween(starLocalDate, endLocalDate).getDays();
		for (int i = 0; i < days;i++) {
			startDateTime=startDateTime.plusDays(1);
			endDateTime=startDateTime.minusDays(1);
			System.out.print("startTime:"+startDateTime.toString("yyyy-MM-dd")+"\t");
			System.out.println("endTime:"+endDateTime.toString("yyyy-MM-dd"));
		}*/
		
		DateTime startTime = new DateTime();
		DateTime endTime = new DateTime();
		for (int i = 0; i < 30;i++) {
			startTime=startTime.minusDays(1);
			endTime=startTime.minusDays(1);
			System.out.print("startTime:"+startTime.toString("yyyy-MM-dd")+"\t");
			System.out.println("endTime:"+endTime.toString("yyyy-MM-dd"));
		}
	}
}
