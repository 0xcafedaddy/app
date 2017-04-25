package com.uflowertv.service;

import java.util.Map;

import com.uflowertv.model.po.XxjProduct;

/**
 * 
 * 版权所有：2017年3月9日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：核心业务
 * 类名称：com.uflowertv.service.XxjProductionServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月9日 下午4:16:46   
 * 修改人：
 * 修改时间：2017年3月9日 下午4:16:46   
 * 修改备注：   
 * @version   V1.0
 */
public interface XxjProductionServiceI{
	/**
	 * 首页接口
	 * @Title: getHomeJson
	 * @Description: TODO(根据平台ID获取首页列表)
	 * @param platformId 平台ID
	 * @return
	 * @ 
	 */
	Map<String, Object> getHomeJson(int platformId) ;
	/**
	 * 定价列表
	 * @Title: getProductRated
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param userId
	 * @param product_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getProductRated(int platformId, int userId, int product_id) ;
	/**
	 * 同步课产品列表
	 * @Title: getSynProductionList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param xued_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getSynProductionList(int platformId, int xued_id) ;
	/**
	 * 同步课产品详情
	 * @Title: getSynProductionDetail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param user_id
	 * @param product_id
	 * @param content_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getSynProductionDetail(int user_id, int product_id, int content_id) ;
	/**
	 * 专题产品列表
	 * @Title: getSpecialProductionList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param grade_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getSpecialProductionList(int platformId) ;
	/**
	 * 专题产品详情
	 * @Title: getSpecialProductionDetail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param user_id
	 * @param product_id
	 * @return
	 */
	Map<String, Object> getSpecialProductionDetail(int user_id, int product_id);
	/**
	 * 分类
	 * @Title: getSortList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @return
	 * @ 
	 */
	Map<String, Object> getSortList(int platformId) ;
	/**
	 * 获取视频播放地址  同时将该视频存放至观看记录里。
	 * @Title: getVideoUrl
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param userId
	 * @param video_id
	 * @return
	 * @
	 */
	Map<String, Object> getVideoUrl(int platformId, int userId, int video_id) ;
	/**
	 * 学段下的年级与科目列表
	 * @Title: getGradeSubjectList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param xued_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getGradeSubjectList(int xued_id) ;
	/**
	 * 所有学段下的年级与科目列表
	 * @Title: getGradeSubjectListAll
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @ 
	 */
	Map<String, Object> getGradeSubjectListAll() ;
	/**
	 * 0元试听
	 * @Title: getFreeVideoList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param grade_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getFreeVideoList(int grade_id) ;
	/**
	 * 同步课产品鉴权
	 * @Title: getSynPurchase
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param userId
	 * @param product_id
	 * @return
	 */
	String getSynPurchase(int userId, int product_id);
	XxjProduct getById(int id);
	
}
