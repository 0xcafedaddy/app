package com.uflowertv.service;

import java.util.Map;

/**
 * 
 * 版权所有：2017年3月13日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：PHP打包程序
 * 类名称：com.uflowertv.service.PHPPackageServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月13日 下午4:48:07   
 * 修改人：
 * 修改时间：2017年3月13日 下午4:48:07   
 * 修改备注：   
 * @version   V1.0
 */
public interface PHPPackageServiceI {

	/**
	 * 专题详情
	 * @Title: getSpecialInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param product_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getSpecialInfo(int product_id) ;
	/**
	 * 同步课详情
	 * @Title: getSynCourseInfo
	 * @Description: TODO(根据产品ID获取同步课详情)
	 * @param product_id 产品ID
	 * @return 
	 * @ 
	 */
	Map<String, Object> getSynCourseInfo(int product_id) ;
	/**
	 * 教师下科目详情
	 * @Title: getTeacherSubjectInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param teacher_id
	 * @param flag
	 * @return
	 * @ 
	 */
	Map<String, Object> getTeacherSubjectInfo(int teacher_id) ;
	/**
	 * 零元试听
	 * @Title: getFreeVideoListInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param grade_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getFreeVideoListInfo(int grade_id) ;
}
