package com.uflowertv.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.uflowertv.statistics.mapper.StartMapper;
import com.uflowertv.model.DayActiveCount;
import com.uflowertv.model.StartExample;
import com.uflowertv.model.dto.Series;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class StartService {

	@Autowired
	private StartMapper startMapper;
	
	/**
	 * 用户日活跃量（表格）
	 * @param start
	 * @param end
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> getMonthActiveUser(String start, String end, int currentPage, int pageSize){
		Map<String, Object> map = Maps.newHashMap();
		PageHelper.startPage(currentPage, pageSize);
		Page<DayActiveCount> p = new Page<DayActiveCount>(currentPage,pageSize);
		DateTime startTime = null;
		DateTime endTime = null;
		if (StringUtils.isBlank(start) || StringUtils.isBlank(end)) {
			endTime = new DateTime();
			startTime = endTime.minusMonths(1);
		}else{
			startTime = DateTime.parse(start,DateTimeFormat.forPattern("yyyy-MM-dd"));
			endTime = DateTime.parse(end,DateTimeFormat.forPattern("yyyy-MM-dd"));
		}
		List<DayActiveCount> timeUserActiveList = startMapper.getTimeUserActiveList(startTime.toDate(),endTime.toDate());
		int timeUserActiveCount = startMapper.getTimeUserActiveCount(startTime.toDate(),endTime.toDate());
		map.put("total", timeUserActiveCount);
		map.put("rows", timeUserActiveList);
		return map;
	}

    /**
     * 用户日活跃量（图饼）
     * @param start
     * @param end
     * @return
     */
    public Map<String,Object> getCharts(String start, String end){
        Map<String, Object> map = Maps.newHashMap();
        List<String> categories = Lists.newArrayList();
        List<Series> seriesList = Lists.newArrayList();
        if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {
            DateTime startDateTime = DateTime.parse(start,DateTimeFormat.forPattern("yyyy-MM-dd"));
            DateTime endDateTime = DateTime.parse(end,DateTimeFormat.forPattern("yyyy-MM-dd"));
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
                StartExample.Criteria criteria = example.createCriteria().andIdIsNotNull();
                criteria.andDtBetween(endDateTime.toDate(),startDateTime.toDate());
                int countByExample = startMapper.countByExample(example);
                if(countByExample>0){
                    categories.add(startDateTime.getMonthOfYear()+"月"+startDateTime.getDayOfMonth()+"日");
                    Series series = new Series();
                    series.setValue(countByExample);
                    series.setName(startDateTime.getMonthOfYear()+"月"+startDateTime.getDayOfMonth()+"日");
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
                StartExample.Criteria criteria = example.createCriteria().andIdIsNotNull();
                criteria.andDtBetween(endTime.toDate(),startTime.toDate());
                int countByExample = startMapper.countByExample(example);
                if(countByExample>0){
                    categories.add(startTime.getMonthOfYear()+"月"+startTime.getDayOfMonth()+"日");
                    Series series = new Series();
                    series.setValue(countByExample);
                    series.setName(startTime.getMonthOfYear()+"月"+startTime.getDayOfMonth()+"日");
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
