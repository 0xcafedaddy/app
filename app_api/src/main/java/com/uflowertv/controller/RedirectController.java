package com.uflowertv.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.uflowertv.service.PHPPackageServiceI;
import com.uflowertv.service.PreHeatServiceI;
import com.uflowertv.service.XxjOrderServiceI;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
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
	private XxjOrderServiceI xxjOrderService;

	@RequestMapping(value="/500")
	public void w00(Writer writer) throws IOException{
		int i = 1/0;
		writer.write(i);
	}

    @RequestMapping(value="/login",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String,Object> login(String username,String password){
        Map<String, Object> map = Maps.newHashMap();
        String uname = "youcaihua";
        String pwd = "518";
        if (StringUtils.equals(username,uname)&& StringUtils.equals(pwd,password)){
            map.put("code", 200);
            return map;
        }else {
            map.put("code", 500);
            return map;
        }
    }

	@RequestMapping(value = "/json",
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Pet json(@RequestBody Pet pet){
		Preconditions.checkNotNull(pet,"对象不存在！");
		return pet;
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
	 */
	
	@RequestMapping("/test/{user_id}/{product_id}")
	public ModelAndView test1(@PathVariable int user_id,@PathVariable int product_id){
		Preconditions.checkArgument(user_id>0,"用户ID不能为空");
		Preconditions.checkArgument(product_id>0,"产品ID不能为空");
		return new ModelAndView("index");
	}

	@RequestMapping("/test/{product_id}")
	public ModelAndView test2(@PathVariable int product_id){
		ModelAndView mv = new ModelAndView("index");
		phpPackageService.getSpecialInfo(product_id);
		return mv;
	}
	@RequestMapping("/test3/{order_id}")
	public void test3(@PathVariable String order_id){
		xxjOrderService.executePurchaseCombo(order_id);
	}
	
	/**
	 * redis preheat programmer
	 * @Title: init
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@RequestMapping(value="/init235",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
    public Map<String,Object> init(){
		Map<String,Object> map = Maps.newHashMap();
		try {
            long start = System.currentTimeMillis();
            synchronized(this){
				preHeatService.getXuedRelation();
				preHeatService.getPointRealtion();
				preHeatService.getVideoRelation();
				preHeatService.getVideoUrlRelation();
				preHeatService.getHomeRelation();
				preHeatService.getContentRelation();
				preHeatService.getProductRelation();
				preHeatService.getProductionInfo();
				preHeatService.getTeacherRelation();
				preHeatService.getFreeVideoRelation();
            }
            long end = System.currentTimeMillis();
			map.put("code",200);
			map.put("msg","预热成功");
			map.put("time",end-start);
			return map;
		}catch (Exception e){
			map.put("code",500);
			map.put("msg",e.getMessage());
			return map;
		}
	}
}

@Data
class Pet{
    private Integer id;
    private String name;
}