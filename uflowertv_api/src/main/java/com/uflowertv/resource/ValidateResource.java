package com.uflowertv.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uflowertv.service.ValidateServiceI;
import com.uflowertv.util.JsonUtils;

/**
 * 
 * 版权所有：2017年1月10日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：校验接口
 * 类名称：com.uflowertv.resource.ValidateResource     
 * 创建人：liguoliang 
 * 创建时间：2017年1月10日 下午5:02:59   
 * 修改人：
 * 修改时间：2017年1月10日 下午5:02:59   
 * 修改备注：   
 * @version   V1.0
 */
@Component
@Path(value = "validate")
public class ValidateResource {
	
	@Autowired
	private ValidateServiceI validateService;
	/**
	 * 获取家长锁
	 * @Title: getParentLoker
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param card
	 * @return
	 */
	@Path("locker/{card}")
	@GET
	public String getParentLoker(@PathParam(value = "card") String card){
		Map<String, Object> map = validateService.getParentLoker(card);
		return json(map);
	}
	
	/**
	 * 套餐校验
	 * @Title: combo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param card
	 * @param orderId300
	 * @param comboId
	 * @return
	 */
	@Path("combo/{platformId}/{card}/{orderId}/{comboId}")
	@GET
	public String combo(@PathParam(value = "platformId") int platformId,
						@PathParam(value = "card") String card,
						@PathParam(value = "orderId") String orderId300,
						@PathParam(value = "comboId") String comboId){
		//生成订单信息
		Map<String, Object> map = validateService.intfComboValid(platformId, card, orderId300, comboId);
		return json(map);
	}
	
	private String json(Object obj){
		return JsonUtils.bean2Json(obj);
	}
}
