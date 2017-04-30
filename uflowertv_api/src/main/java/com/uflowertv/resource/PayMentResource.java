package com.uflowertv.resource;

import com.uflowertv.service.XxjOrderServiceI;
import com.util.json.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Map;
/**
 * 
 * 版权所有：2017年2月6日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：订购回调（用于新接口订购）
 * 类名称：com.uflowertv.resource.PayMentResource     
 * 创建人：liguoliang 
 * 创建时间：2017年2月6日 下午1:40:47   
 * 修改人：
 * 修改时间：2017年2月6日 下午1:40:47   
 * 修改备注：   
 * @version   V1.0
 */
@Component
@Path(value="payment")
public class PayMentResource {

	@Autowired
	private XxjOrderServiceI xxjOrderService;
	
	/**
	 * 订购回调接口
	 * @param userId
	 * @param comboId
	 * @param order_status
	 * @param order_desc
	 * @return
	 * @ 
	 */
	@Path("{userId}/{comboId}/{order_status}/{order_desc}")
	@GET
	public String payment_success(@PathParam(value = "userId") int userId,
								  @PathParam(value = "comboId") String comboId,
								  @PathParam(value = "order_status") String order_status,	
								  @PathParam(value = "order_desc") String order_desc) {
		Map<String, Object> map = xxjOrderService.updateOrderInfo(userId,comboId,order_status,order_desc);
		return json(map);
	}
	
	private String json(Object obj){
		return JsonUtils.bean2Json(obj);
	}
}
