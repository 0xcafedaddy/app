package com.uflowertv.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uflowertv.service.XxjUserServiceI;
import com.uflowertv.util.JsonUtils;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：用户接口
 * 类名称：com.uflowertv.resource.UserResource     
 * 创建人：liguoliang 
 * 创建时间：2016年10月11日 下午5:25:08   
 * 修改人：
 * 修改时间：2016年10月11日 下午5:25:08   
 * 修改备注：   
 * @version   V1.0
 */
@Component
@Path("user")
public class UserResource {

	@Autowired
	private XxjUserServiceI uesrService;
	
	/**
	 * 交换用户ID
	 * @Title: exchange
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param card
	 * @return
	 * @ 
	 */
	@Path("exchange/{platformId}/{card}")
	@GET
	public String exchange(@PathParam(value = "platformId") int platformId,
						   @PathParam(value = "card") String card) {
		Map<String, Object> map = uesrService.saveUser(platformId, card);
		return json(map);
	}
	
	/**
	 * 获取观看记录
	 * @param platformId
	 * @param userId
	 * @return
	 * @ 
	 */
	@Path("get/record/{platformId}/{userId}")
	@GET
	public String record_get(@PathParam(value = "platformId") int platformId,
							 @PathParam(value = "userId") int userId) {
		Map<String, Object> map = uesrService.getUserRecord(platformId, userId);
		return json(map);
	}
	
	/**
	 * 用户已购买产品
	 * @Title: production_list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param userId
	 * @return
	 * @ 
	 */
	@Path("production/list/{platformId}/{userId}")
	@GET
	public String production_list(@PathParam(value = "platformId") int platformId,
								  @PathParam(value = "userId") int userId) {
		 Map<String, Object> map = uesrService.getPurchaseList(platformId, userId);
		return json(map);
	}
	
	private String json(Object obj){
		return JsonUtils.bean2Json(obj);
	}
}
