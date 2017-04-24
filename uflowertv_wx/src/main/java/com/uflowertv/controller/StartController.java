package com.uflowertv.controller;

import com.uflowertv.controller.support.BaseController;
import com.uflowertv.service.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("start")
public class StartController extends BaseController{

	@Autowired
	private StartService startService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(int page,int rows,String start,String end){
		return startService.getMonthActiveUser(start, end, page, rows);
	}
	/*
	@RequestMapping("/charts")
	@ResponseBody
	public Map<String,Object> charts(String start,String end){
		return startService.getCharts(start, end);
	}*/
}
