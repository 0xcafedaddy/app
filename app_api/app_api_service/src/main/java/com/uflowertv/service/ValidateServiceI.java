package com.uflowertv.service;

import java.util.Map;

/**
 * 
 * 版权所有：2017年3月15日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：校验接口
 * 类名称：com.uflowertv.service.ValidateServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月15日 下午1:44:15   
 * 修改人：
 * 修改时间：2017年3月15日 下午1:44:15   
 * 修改备注：   
 * @version   V1.0
 */
public interface ValidateServiceI {

	/**
	 * 获取家长锁
	 * @Title: getParentLoker
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param card
	 * @return
	 */
	Map<String, Object> getParentLoker(String card);

	/**
	 * 生成订单信息,并返回订单号
	 * @Title: intfComboValid
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param card
	 * @param comboId
	 * @return
	 */
	Map<String, Object> executeComboValid(int platformId, String card, String comboId, int comboType);
}
