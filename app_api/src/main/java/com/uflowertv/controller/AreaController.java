package com.uflowertv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uflowertv.model.po.TbProvCityAreaStreet;
import com.uflowertv.service.AreaServiceI;
/**
 * 
 * 版权所有：2017年3月7日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：省、市、区、镇四级联动
 * 类名称：com.uflowertv.controller.AreaController     
 * 创建人：liguoliang 
 * 创建时间：2017年3月7日 下午4:42:47   
 * 修改人：
 * 修改时间：2017年3月7日 下午4:42:47   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("area")
public class AreaController {

	@Autowired
	private AreaServiceI areaService;
	
	/**
	 * 获取省信息
	 * @Title: getProvinces
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@RequestMapping(value="/province",method=RequestMethod.POST)
	@ResponseBody
	public List<TbProvCityAreaStreet> getProvinces(){
		return areaService.getProvinces();
	}
	
	/**
	 * 获取省子孙信息
	 * @Title: getNodes
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/subNode",method=RequestMethod.GET)
	@ResponseBody
	public List<TbProvCityAreaStreet> getNodes(@RequestParam("pid") int pid){
		return areaService.getNodes(pid);
	}
}
