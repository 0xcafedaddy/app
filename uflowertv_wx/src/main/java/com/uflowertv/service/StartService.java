package com.uflowertv.service;

import com.google.common.collect.Maps;
import com.uflowertv.dao.StartMapper;
import com.uflowertv.datasources.DBTypeEnum;
import com.uflowertv.datasources.DataSourceHolder;
import com.uflowertv.model.dto.DayActiveCount;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
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
		DataSourceHolder.setDbType(DBTypeEnum.dataSource_tj);
		/*PageHelper.startPage(currentPage, pageSize);
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
		int timeUserActiveCount = startMapper.getTimeUserActiveCount(startTime.toDate(),endTime.toDate());*/
		DateTime startTime = null;
		DateTime endTime = null;
		if (StringUtils.isBlank(start) || StringUtils.isBlank(end)) {
			endTime = new DateTime();
			startTime = endTime.minusMonths(1);
		}else{
			startTime = DateTime.parse(start,DateTimeFormat.forPattern("yyyy-MM-dd"));
			endTime = DateTime.parse(end,DateTimeFormat.forPattern("yyyy-MM-dd"));
		}
        List<DayActiveCount> timeUserActiveList = startMapper.getTimeUserActiveList(currentPage,pageSize,startTime.toDate(),endTime.toDate());
        int timeUserActiveCount = startMapper.getTimeUserActiveCount(startTime.toDate(),endTime.toDate());
		map.put("total", timeUserActiveCount);
		map.put("rows", timeUserActiveList);
		return map;
	}
}
