package com.uflowertv.service;

import java.util.Map;

import com.uflowertv.model.po.XxjUser;

/**
 * 
 * 版权所有：2017年3月9日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：用户业务
 * 类名称：com.uflowertv.service.XxjUserServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月9日 下午4:09:45   
 * 修改人：
 * 修改时间：2017年3月9日 下午4:09:45   
 * 修改备注：   
 * @version   V1.0
 */
public interface XxjUserServiceI {
	/**
	 * 用户已订购产品列表
	 * @Title: getPurchaseList
	 * @Description: TODO(用户订购产品列表)
	 * @param platformId 平台ID
	 * @param userId 用户ID
	 * @return
	 * @ 
	 */
	Map<String, Object> getPurchaseList(int platformId, int userId) ;
	/**
	 * 通过CA卡号获取用户ID
	 * @Title: saveOrGetUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param card
	 * @return
	 * @ 
	 */
	Map<String, Object> saveUser(int platformId, String card) ;
	/**
	 * 获取用户观看记录
	 * @Title: getUserRecord
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param userId
	 * @return
	 * @ 
	 */
	Map<String, Object> getUserRecord(int platformId, int userId);
	
	XxjUser getById(int id);
	
	XxjUser getByHql(String hql, Map<String, Object> params);
}
