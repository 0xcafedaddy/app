package com.uflowertv.service.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunii.ccn.ectchannel.server.webservice.impl.ComboOrderInfo;
import com.google.common.collect.Maps;
import com.uflowertv.service.BossServiceI;
import com.uflowertv.service.PurchaseServiceI;
import com.uflowertv.service.XxjOrderServiceI;
import com.uflowertv.util.ConstantHolder;

/**
 * 
 * 版权所有：2017年3月15日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：套餐订购业务
 * 类名称：com.uflowertv.service.impl.PurchaseServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月15日 下午1:27:00   
 * 修改人：
 * 修改时间：2017年3月15日 下午1:27:00   
 * 修改备注：   
 * @version   V1.0
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseServiceI{

	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private BossServiceI bossService;
	@Autowired
	private XxjOrderServiceI xxjOrderService;
	
	/**
	 * 套餐订购
	 * @see com.uflowertv.service.PurchaseServiceI#getPurchase(String, String, String, String)
	 */
	@Override
	public Map<String, Object> getPurchase(String card, String orderId, String comboId, String comboSeq) {
		log.info("套餐订购");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(StringUtils.isNotBlank(card),"卡号为空");
		checkArgument(StringUtils.isNotBlank(orderId),"订单ID为空");
		checkArgument(StringUtils.isNotBlank(comboId),"套餐ID为空");
		checkArgument(StringUtils.isNotBlank(comboSeq),"套餐校验码为空");
		String channelCode = ConstantHolder.CHANNEL_CODE;
		ComboOrderInfo intfComboOrder = bossService.intfComboOrder(card, comboId, channelCode, comboSeq);
		checkNotNull(intfComboOrder,"系统系繁忙，请稍候再试！");
		String code = intfComboOrder.getCode();
		String message = intfComboOrder.getMsg();
		boolean status200 = StringUtils.equals(code, "200");
		if(status200){
			map.put("code", code);
			map.put("message", message);
			map.put("data", xxjOrderService.updateUserPurchaseProduction(card,orderId));
			return map;
		}
		log.info(message);
		map.put("code", code);
		map.put("message", message);
		return map;
	}
}
