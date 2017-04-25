package com.uflowertv.service;

import java.util.List;
import java.util.Map;

import com.uflowertv.model.po.XxjOrder;

/**
 * 
 * 版权所有：2017年3月9日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：订单业务
 * 类名称：com.uflowertv.service.XxjOrderServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月9日 下午4:13:35   
 * 修改人：
 * 修改时间：2017年3月9日 下午4:13:35   
 * 修改备注：   
 * @version   V1.0
 */
public interface XxjOrderServiceI {
	/**
	 * 支付回调
	 * @Title: updateOrderInfo
	 * @Description: TODO(当支付成功后，会更新订单信息)
	 * @param orderId 订单ID
	 * @param paySeq 支付流水号
	 * @param payState 支付状态
	 * @param payDesc 支付描述
	 * @param payType 支付类型
	 */
	void updateOrderInfo(String orderId, String paySeq, String payState, String payDesc, String payType);
	/**
	 * 订购回调
	 * @Title: updateOrderInfo
	 * @Description: TODO(当订购成功后，会更新订单信息)
	 * @param userId  用户ID
	 * @param comboId 套餐ID
	 * @param order_status 订单状态
	 * @param order_desc 订单描述
	 * @return
	 * @ 
	 */
	Map<String, Object> updateOrderInfo(int userId, String comboId, String order_status, String order_desc) ;
	/**
	 * 同步Boss接口用户已订购产品
	 * @Title: updateUserPurchaseProduction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param userId
	 * @
	 */
	void updateUserPurchaseProduction(int userId) ;
	/**
	 * 获取用户有效订单列表
	 * @Title: getUserOrderList
	 * @Description: TODO(用户有效订单列表)
	 * @param platformId 平台ID
	 * @param userId 用户ID
	 * @return
	 * @ 
	 */
	List<XxjOrder> getUserOrderList(int platformId, int userId) ;
	/**
	 * 获取送书二维码
	 * @Title: getQrcodeUrl
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param orderId
	 * @return
	 * @ 
	 */
	String getQrcodeUrl(int platformId, int orderId) ;
	/**
	 * 通过SQL语句进行更新或插入操作
	 * @Title: executeBySql
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param sql
	 * @param params
	 * @return
	 */
	int executeBySql(String sql, Map<String, Object> params);
	int insertOrder(XxjOrder xxjOrder);
	XxjOrder getById(int id);
	List<XxjOrder> find(String hql, Map<String, Object> params);
	/**
	 * 订购成功后将订单信息更新至本地
	 * @Title: updateUserPurchaseProduction
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param card
	 * @param orderId
	 * @return
	 * @
	 */
	XxjOrder updateUserPurchaseProduction(String card, String orderId) ;
}
