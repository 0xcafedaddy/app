package com.uflowertv.service;

/**
 * 
 * 版权所有：2017年3月9日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：预热业务
 * 类名称：com.uflowertv.service.PreHeatServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月9日 下午4:14:41   
 * 修改人：
 * 修改时间：2017年3月9日 下午4:14:41   
 * 修改备注：   
 * @version   V1.0
 */
public interface PreHeatServiceI {

	/**
	 * 产品相关DATA
	 * @Title: getProductRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getProductRelation();
	/**
	 * 内容包相关DATA
	 * @Title: getContentRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getContentRelation();
	/**
	 * 学段相关DATA
	 * @Title: getXuedRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getXuedRelation();
	/**
	 * 知识点相关DATA
	 * @Title: getPointRealtion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getPointRealtion();
	/**
	 * 视频相关DATA
	 * @Title: getVideoRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getVideoRelation();
	/**
	 * 教师相关DATA
	 * @Title: getTeacherRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getTeacherRelation();
	/**
	 * 同步课相关DATA
	 * @Title: getFreeVideoRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getFreeVideoRelation();
	/**
	 *  获取首页相关DATA
	 * @Title: getHomeRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getHomeRelation();
	/**
	 * 视频播放地址
	 * @Title: getVideoUrlRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	void getVideoUrlRelation();
	void getProductionInfo();

}
