package com.uflowertv.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.util.json.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uflowertv.service.TeacherServiceI;
/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：教师接口
 * 类名称：com.uflowertv.resource.TeacherResource     
 * 创建人：liguoliang 
 * 创建时间：2016年10月20日 下午4:48:02   
 * 修改人：
 * 修改时间：2016年10月20日 下午4:48:02   
 * 修改备注：   
 * @version   V1.0
 */
@Component
@Path("teacher")
public class TeacherResource {

	@Autowired
	private TeacherServiceI teacherService;
	
	/**
	 * 年级下的教师列表
	 * @Title: grade_teacher_list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id 年级ID
	 * @return
	 * @
	 */
	@Path("grade/list/{id}")
	@GET
	public String grade_teacher_list(@PathParam(value = "id") int id) {
		Map<String,Object> map = teacherService.getGradeTeacherList(id);
		return json(map);
	}
	
	/**
	 * 科目下的教师列表
	 * @Title: subject_teacher_list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id 科目ID
	 * @return
	 * @
	 */
	@Path("subject/list/{id}")
	@GET
	public String subject_teacher_list(@PathParam(value = "id") int id) {
		Map<String,Object> map = teacherService.getSubjectTeacherList(id);
		return json(map);
	}
	
	/**
	 * 教师详情
	 * @Title: teacher_detail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param teacher_id
	 * @return
	 * @
	 */
	@Path("detail/{teacher_id}")
	@GET
	public String teacher_detail(@PathParam(value = "teacher_id") int teacher_id) {
		Map<String, Object> map = teacherService.getTeacherInfo(teacher_id);
		return json(map);
	}
	
	/**
	 * 教师下科目详情
	 * @Title: teacher_subject_detail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param teacher_id
	 * @return
	 * @
	 */
	@Path("subject/detail/{user_id}/{product_id}/{teacher_id}")
	@GET
	public String teacher_subject_detail(@PathParam(value = "user_id") int user_id,
										 @PathParam(value = "product_id") int product_id,
										 @PathParam(value = "teacher_id") int teacher_id) {
		Map<String,Object> map = teacherService.getTeacherSubjectDetail(user_id, product_id, teacher_id);
		return json(map);
	}
	
	private String json(Object obj){
		return JsonUtils.bean2Json(obj);
	}
}
