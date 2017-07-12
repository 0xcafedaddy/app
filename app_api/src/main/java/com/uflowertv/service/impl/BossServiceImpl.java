package com.uflowertv.service.impl;

import com.crunii.ccn.ectchannel.server.webservice.impl.ComboOrderInfo;
import com.crunii.ccn.ectchannel.server.webservice.impl.ComboValidInfo;
import com.crunii.ccn.ectchannel.server.webservice.impl.EctChannelService;
import com.crunii.ccn.ectchannel.server.webservice.impl.ParentLocker;
import com.uflowertv.service.BossServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 版权所有：2017年3月8日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：业务Boss接口
 * 类名称：com.uflowertv.service.impl.BossServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月8日 下午6:01:34   
 * 修改人：
 * 修改时间：2017年3月8日 下午6:01:34   
 * 修改备注：   
 * @version   V1.0
 */
@Service("bossService")
public class BossServiceImpl implements BossServiceI{
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EctChannelService ectChannelService;
	
	/**
	 * 套餐校验
	 * @see com.uflowertv.service.BossServiceI#intfComboValid(String, String, String)
	 */
	@Override
	public ComboValidInfo intfComboValid(String servNo, String comboId,
			String channelCode) {
		log.info("套餐校验");
		ComboValidInfo intfComboValid = ectChannelService.intfComboValid(servNo, comboId, channelCode);
		return intfComboValid;
	}
	
	
	/**
	 * 家长锁(只提供查询)
	 * @see com.uflowertv.service.BossServiceI#intfParentLocker(String, String, String, String, String)
	 */
	@Override
	public ParentLocker intfParentLocker(String channelCode, String custId,
			String dealType, String passwd, String newPasswd) {
		log.info("家长锁");
		ParentLocker intfParentLocker = ectChannelService.intfParentLocker(channelCode, custId, dealType, passwd, newPasswd);
		return intfParentLocker;
	}
	
	/**
	 * 套餐订购
	 * @see com.uflowertv.service.BossServiceI#intfComboOrder(String, String, String, String)
	 */
	@Override
	public ComboOrderInfo intfComboOrder(String servNo, String comboId, String channelCode, String intfSeq){
		log.info("套餐订购");
		ComboOrderInfo intfComboOrder = ectChannelService.intfComboOrder(servNo, comboId, channelCode, intfSeq, "");
		return intfComboOrder;
	}

}
