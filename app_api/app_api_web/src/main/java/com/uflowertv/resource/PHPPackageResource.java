package com.uflowertv.resource;

import com.google.common.collect.Maps;
import com.uflowertv.service.PHPPackageServiceI;
import com.uflowertv.service.PreHeatServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * 
 * 版权所有：2017年1月13日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：为PHP提供打包JSON接口
 * 类名称：com.uflowertv.resource.PHPPackageResource     
 * 创建人：liguoliang 
 * 创建时间：2017年1月13日 下午2:57:44   
 * 修改人：
 * 修改时间：2017年1月13日 下午2:57:44   
 * 修改备注：   
 * @version   V1.0
 */
@Component
@Path("PHP")
public class PHPPackageResource {

	@Autowired
	private PHPPackageServiceI phpPackageService;
	@Autowired
	private PreHeatServiceI preHeatService;
	
	
	/**
	 * 打包同步课JSON
	 * @Title: saveContentBag
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param product_id
	 * @return 
	 * @ 
	 */
	@Path("content/{product_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> content(@PathParam(value = "product_id") int product_id) {
		return phpPackageService.getSynCourseInfo(product_id);
	}

	/**
	 * 打包专题JSON
	 * @Title: sepcial
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param product_id
	 * @return
	 * @ 
	 */
	@Path("special/{product_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> sepcial(@PathParam(value = "product_id") int product_id) {
		return phpPackageService.getSpecialInfo(product_id);
	}
	
	/**
	 * 教师下科目JSON
	 * @Title: teacher_subject_info
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param teacher_id
	 * @return
	 * @ 
	 */
	@Path("teacher/subject/info/{teacher_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> teacher_subject_info(@PathParam(value = "teacher_id") int teacher_id) {
		return phpPackageService.getTeacherSubjectInfo(teacher_id);
	}

	/**
	 * 零元试听JSON
	 * @Title: free_video
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param grade_id
	 * @return
	 * @ 
	 */
	@Path("free/video/{grade_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> free_video(@PathParam(value = "grade_id") int grade_id) {
		return	phpPackageService.getFreeVideoListInfo(grade_id);
	}
	
	/**
	 * 产品预热(视频、知识点修改后预热)
	 * @Title: preheat_production
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@Path("preheat/production")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> preheat_production(){
		Map<String, Object> map = Maps.newHashMap();
		try {
			preHeatService.getProductRelation();
			map.put("code", 200);
			map.put("message", "OK");
			return map;
		} catch (Exception e) {
			map.put("code", 500);
			map.put("message", e.getMessage());
			return map;
		}
	}

	/**
	 * 推荐位预热
	 * @Title: preheat_home
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@Path("preheat/home")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> preheat_home(){
		Map<String, Object> map = Maps.newHashMap();
		try {
			preHeatService.getHomeRelation();
			map.put("code", 200);
			map.put("message", "OK");
			return map;
		} catch (Exception e) {
			map.put("code", 500);
			map.put("message", e.getMessage());
			return map;
		}
	}
}
