package com.uflowertv.service;

import java.util.Map;

/**
 * 
 * 版权所有：2017年3月15日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：套餐订购
 * 类名称：com.uflowertv.service.PurchaseServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月15日 下午1:26:20   
 * 修改人：
 * 修改时间：2017年3月15日 下午1:26:20   
 * 修改备注：   
 * @version   V1.0
 */
public interface PurchaseServiceI {

	/**
	 * 套餐订购
	 * @Title: getPurchase
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param card
	 * @param orderId
	 * @param comboId
	 * @param comboSeq
	 * @return
	 * @
	 */
	Map<String, Object> getPurchase(String card, String orderId, String comboId, String comboSeq) ;

}
