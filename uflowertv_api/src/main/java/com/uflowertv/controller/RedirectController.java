package com.uflowertv.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.uflowertv.resource.exception.errorhandling.AppException;
import com.uflowertv.service.PHPPackageServiceI;
import com.uflowertv.service.PreHeatServiceI;
import com.uflowertv.service.XxjProductionServiceI;
/**
 * 
 * 版权所有：2017年3月7日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：reids preheat programmer
 * 类名称：com.uflowertv.controller.RedirectController     
 * 创建人：liguoliang 
 * 创建时间：2017年3月7日 下午4:44:22   
 * 修改人：
 * 修改时间：2017年3月7日 下午4:44:22   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("redirect")
public class RedirectController {

	@Autowired
	private PreHeatServiceI preHeatService;
	@Autowired
	private PHPPackageServiceI phpPackageService;
	@Autowired
	private XxjProductionServiceI xxjProductionService;
	
	@RequestMapping(value="/500")
	public void w00(Writer writer) throws IOException{
		int i = 1/0;
		writer.write(i);
	}
	
	@RequestMapping(value="/json",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String,Object> json(){
		Map<String, Object> map = Maps.newHashMap();
		map.put("code", 200);
		map.put("msg", "success");
		return map;
	}
	/**
	 * requestMapping注解详解
	 * @Title: testRequestMapping
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * 1、属性：分三类介绍
	 *   1) value:请求地址 可以是URI template
	 *   	method:请求方法 get post ...
	 *   2) consumes:指定处理请求的提交类型内容(Content-Type)
	 *   	produces:指定返回的类型内容，仅当请求头中的Accept包含该类型才返回。
	 *   3) params: 指定request中必须包含某些参数值是，才让该方法处理。
	 *   	headers: 指定request中必须包含某些指定的header值，才能让该方法处理请求。
	 *   @RequestMapping(
					//name="",
					//value = "/param1/{id}/param2/{name}",
					//path="",
					//params = "myParam!=myValue",
					//headers="",
					//consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
					//produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
					//method = RequestMethod.GET)
	 * @throws AppException 
	 */
	
	@RequestMapping("/test/{id}")
	public void test(@PathVariable int id) throws AppException{
		phpPackageService.getTeacherSubjectInfo(id);
	}
	@RequestMapping("/test/{user_id}/{product_id}")
	public ModelAndView test1(@PathVariable int user_id,@PathVariable int product_id){
		Preconditions.checkArgument(user_id>0,"用户ID不能为空");
		Preconditions.checkArgument(product_id>0,"产品ID不能为空");
		return new ModelAndView("index");
	}
	
	/**
	 * redis preheat programmer
	 * @Title: init
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@RequestMapping(value="/init",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView init(){
		long start = System.currentTimeMillis();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				preHeatService.getXuedRelation();
				preHeatService.getPointRealtion();
				preHeatService.getVideoRelation();
				preHeatService.getVideoUrlRelation();
				preHeatService.getHomeRelation();
				preHeatService.getProductRelation();
				preHeatService.getFreeVideoRelation();
				preHeatService.getTeacherRelation();
				preHeatService.getTeacherSubjectInfoRelation();
			}
		});
		executorService.shutdown();
		long end = System.currentTimeMillis();
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("time", end-start);
		return mv;
	}
}
