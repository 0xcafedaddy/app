package com.uflowertv.service;

import com.crunii.ccn.ectchannel.server.webservice.impl.ComboOrderInfo;
import com.crunii.ccn.ectchannel.server.webservice.impl.ComboValidInfo;
import com.crunii.ccn.ectchannel.server.webservice.impl.ParentLocker;

/**
 * 
 * 版权所有：2017年1月10日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：第三方Boss接口
 * 类名称：com.uflowertv.service.BossServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年1月10日 下午4:27:20   
 * 修改人：
 * 修改时间：2017年1月10日 下午4:27:20   
 * 修改备注：   
 * @version   V1.0
 */
public interface BossServiceI {

	/**
	 * 套餐校验
	 * @Title: validate
	 * @Description: TODO(用于检验套餐是否合法，合法才能购买，否则验证失败)
	 * @param servNo 智能卡号
	 * @param comboId 套餐ID
	 * @param channelCode 渠道来源
	 * @return
	 */
	public ComboValidInfo intfComboValid(String servNo,String comboId,String channelCode);
	
	
	/**
	 * 家长锁(只提供查询)
	 * @Title: intfParentLocker
	 * @Description: TODO(家长锁查询)
	 * @param channelCode 渠道来源
	 * @param custId 客户编号
	 * @param dealType 家长锁类型 1、查询2、添加3、修改
	 * @param passwd 旧密码
	 * @param newPasswd 新密码
	 * @return
	 */
	public ParentLocker intfParentLocker(String channelCode,String custId,String dealType,String passwd,String newPasswd);
	
	
	/**
	 * 套餐订购
	 * @Title: intfComboOrder
	 * @Description: TODO(套餐订购)
	 * @param servNo 智能卡号
	 * @param comboId 套餐ID
	 * @param channelCode 渠道来源
 	 * @param intfSeq 套餐校验流水号
	 * @return
	 */
	ComboOrderInfo intfComboOrder(String servNo, String comboId, String channelCode, String intfSeq);
}
