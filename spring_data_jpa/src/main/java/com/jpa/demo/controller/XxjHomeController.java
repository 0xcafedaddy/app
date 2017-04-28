package com.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.demo.entity.XxjHome;
import com.jpa.demo.service.XxjHomeService;

@Controller
@RequestMapping("home")
public class XxjHomeController {

	@Autowired
	private XxjHomeService xxjHomeService;
	
	@RequestMapping(value="/findAll",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<XxjHome> findAll(){
		return xxjHomeService.findAll();
	}
	@RequestMapping(value="/getById/{homeId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public XxjHome findByHomeId(@PathVariable int homeId){
		return xxjHomeService.findByHomeId(homeId);
	}
}
