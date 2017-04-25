package com.uflowertv.service;

import java.util.Map;
/**
 * 
 * 版权所有：2017年3月15日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：教师接口
 * 类名称：com.uflowertv.service.TeacherServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月15日 下午1:31:25   
 * 修改人：
 * 修改时间：2017年3月15日 下午1:31:25   
 * 修改备注：   
 * @version   V1.0
 */
public interface TeacherServiceI {

	/**
	 * 教师详情
	 * @Title: getTeacherInfo
	 * @Description: TODO(根据教师ID获取教师详情)
	 * @param teacher_id 教师ID
	 * @return
	 * @ 
	 */
	Map<String, Object> getTeacherInfo(int teacher_id) ;
	/**
	 * 年级下的教师列表
	 * @Title: getGradeTeacherList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 * @
	 */
	Map<String, Object> getGradeTeacherList(int id) ;
	/**
	 * 科目下的教师列表
	 * @Title: getSubjectTeacherList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 * @ 
	 */
	Map<String, Object> getSubjectTeacherList(int id) ;
	/**
	 * 教师下科目详情
	 * @Title: getTeacherSubjectDetail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param user_id
	 * @param product_id
	 * @param teacher_id
	 * @return
	 * @ 
	 */
	Map<String, Object> getTeacherSubjectDetail(int user_id, int product_id, int teacher_id) ;

}
