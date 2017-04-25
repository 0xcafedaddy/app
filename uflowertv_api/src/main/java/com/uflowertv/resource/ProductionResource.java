package com.uflowertv.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uflowertv.service.XxjProductionServiceI;
import com.uflowertv.util.JsonUtils;
/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：产品接口
 * 类名称：com.uflowertv.resource.ProductionResource     
 * 创建人：liguoliang 
 * 创建时间：2016年9月28日 下午1:59:32   
 * 修改人：
 * 修改时间：2016年9月28日 下午1:59:32   
 * 修改备注：   
 * @version   V1.0
 */
@Component
@Path("production")
public class ProductionResource {
	
	@Autowired
	private XxjProductionServiceI xxjProductionService;
	
	
	/**
	 * 首页列表
	 * @Title: home
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @return
	 * @ 
	 */
	@Path("home/{platformId}")
	@GET
	public String home(@PathParam(value = "platformId") int platformId) {
		Map<String, Object> map = xxjProductionService.getHomeJson(platformId);
		return json(map);
	}
	
	/**
	 * 同步科全科产品列表
	 * @Title: syn_list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param xued_id
	 * @return
	 * @ 
	 */
	@Path("{platformId}/{xued_id}")
	@GET
	public String syn_list(@PathParam(value = "platformId") int platformId,
						   @PathParam(value = "xued_id") int xued_id) {
		Map<String, Object> map = xxjProductionService.getSynProductionList(platformId, xued_id);
		return json(map);
	}
	
	/**
	 * 专题产品列表
	 * @Title: special_list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @return
	 * @ 
	 */
	@Path("special/list/{platformId}")
	@GET
	public String special_list(@PathParam(value = "platformId") int platformId) {
		Map<String, Object> map = xxjProductionService.getSpecialProductionList(platformId);
		return json(map);
	}
	
	/**
	 * 分类
	 * @Title: sort
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @return
	 * @ 
	 */
	@Path("sort/{platformId}")
	@GET
	public String sort(@PathParam(value = "platformId") int platformId) {
		Map<String, Object> map = xxjProductionService.getSortList(platformId);
		return json(map);
	}
	
	/**
	 * 同步课产品详情
	 * @Title: syn_detail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param user_id
	 * @param product_id
	 * @param content_id
	 * @return
	 * @ 
	 */
	@Path("syn/detail/{user_id}/{product_id}/{content_id}")
	@GET
	public String syn_detail(@PathParam(value = "user_id") int user_id,
							 @PathParam(value = "product_id") int product_id,
							 @PathParam(value = "content_id") int content_id) {
		Map<String,Object> map = xxjProductionService.getSynProductionDetail(user_id, product_id, content_id);
		return json(map);
	}
	
	/**
	 * 专题详情
	 * @Title: special_detail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param user_id
	 * @param product_id
	 * @return
	 */
	@Path("special/detail/{user_id}/{product_id}")
	@GET
	public String special_detail(@PathParam(value = "user_id") int user_id,
								 @PathParam(value = "product_id") int product_id) {
		Map<String,Object> map = xxjProductionService.getSpecialProductionDetail(user_id, product_id);
		return json(map);
	}
	
	/**
	 * 产品价格
	 * @Title: rated
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param product_id
	 * @return
	 * @ 
	 */
	@Path("rated/{platformId}/{userId}/{product_id}")
	@GET
	public String rated(@PathParam(value = "platformId") int platformId,
						@PathParam(value = "userId") int userId,
						@PathParam(value = "product_id") int product_id) {
		Map<String, Object> map = xxjProductionService.getProductRated(platformId, userId, product_id);
		return json(map);
	}
	
	
	/**
	 * 获取视频播放地址  同时将该视频存放至观看记录里。
	 * @Title: get_video_url
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param userId
	 * @param video_id
	 * @param product_id
	 * @param product_type
	 * @return
	 * @
	 */
	@Path("get/video/url/{platformId}/{userId}/{video_id}")
	@GET
	public String get_video_url(@PathParam(value = "platformId") int platformId,
								 @PathParam(value = "userId") int userId,
								 @PathParam(value = "video_id") int video_id) {
		Map<String, Object> map = xxjProductionService.getVideoUrl(platformId, userId, video_id);
		return json(map);
	}
	
	/**
	 * 0元试听
	 * @param grade_id
	 * @return
	 * @ 
	 */
	@Path("free/video/list/{grade_id}")
	@GET
	public String free_video_list(@PathParam(value = "grade_id") int grade_id) {
		Map<String, Object> map = xxjProductionService.getFreeVideoList(grade_id);
		return json(map);		
	}
	
	/**
	 * 所有学段下的年级与科目列表
	 * @Title: grade_list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @ 
	 */
	@Path("grade/list")
	@GET
	public String grade_list() {
		Map<String, Object> map = xxjProductionService.getGradeSubjectListAll();
		return json(map);
	}
	
	/**
	 * 学段下的年级与科目列表
	 * @Title: grade_list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param xued_id
	 * @return
	 * @ 
	 */
	@Path("grade/list/{xued_id}")
	@GET
	public String grade_list(@PathParam(value = "xued_id") int xued_id) {
		Map<String, Object> map = xxjProductionService.getGradeSubjectList(xued_id);
		return json(map);
	}
	
	private String json(Object obj){
		return JsonUtils.bean2Json(obj);
	}
}
