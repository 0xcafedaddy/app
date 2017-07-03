package com.uflowertv.statistics.controller;

import com.uflowertv.statistics.service.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("start")
public class StartController {

	@Autowired
	private StartService startService;
	
	@RequestMapping(value = "/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> list(int page,int rows,String start,String end){
		return startService.getMonthActiveUser(start, end, page, rows);
	}
	
	@RequestMapping(value = "/charts",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String,Object> charts(String start,String end){
		return startService.getCharts(start, end);
	}
}
