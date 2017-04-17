package com.uflowertv.statistics.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uflowertv.statistics.service.StartService;

@Controller
@RequestMapping("/start")
public class StartController {

	@Autowired
	private StartService startService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public Map<String, Object> list(int page,int rows,String start,String end){
		return startService.getMonthActiveUser(start, end, page, rows);
	}
	
	@RequestMapping("/charts.do")
	@ResponseBody
	public Map<String,Object> charts(String start,String end){
		return startService.getCharts(start, end);
	}
}
