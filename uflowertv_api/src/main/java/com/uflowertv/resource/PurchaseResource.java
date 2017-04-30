package com.uflowertv.resource;

import com.uflowertv.service.PurchaseServiceI;
import com.util.json.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Map;

/**
 * 
 * 版权所有：2017年1月10日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：订购接口
 * 类名称：com.uflowertv.resource.PurchaseResource     
 * 创建人：liguoliang 
 * 创建时间：2017年1月10日 下午5:02:59   
 * 修改人：
 * 修改时间：2017年1月10日 下午5:02:59   
 * 修改备注：   
 * @version   V1.0
 */
@Component
@Path(value = "purchase")
public class PurchaseResource {
	@Autowired
	private PurchaseServiceI purchaseService;
	
	/**
	 * 套餐订购
	 * @Title: purchase
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param card
	 * @param comboSeq
	 * @param comboId
	 * @return
	 * @ 
	 */
	@Path("{card}/{orderId}/{comboId}/{comboSeq}")
	@GET
	public String purchase(@PathParam(value = "card") String card,
						   @PathParam(value = "orderId") String orderId,
						   @PathParam(value = "comboId") String comboId,
						   @PathParam(value = "comboSeq") String comboSeq) {
		Map<String, Object> map = purchaseService.getPurchase(card,orderId, comboId, comboSeq);
		return json(map);
	}
	
	private String json(Object obj){
		return JsonUtils.bean2Json(obj);
	}
}
