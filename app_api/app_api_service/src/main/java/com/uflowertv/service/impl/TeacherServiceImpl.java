package com.uflowertv.service.impl;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.uflowertv.model.RedisEntity;
import com.uflowertv.model.vo.CommonsEntityJson;
import com.uflowertv.service.TeacherServiceI;
import com.uflowertv.service.XxjProductionServiceI;
import com.util.json.JsonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.util.commons.ConstantHolder.*;
import static com.util.redis.URLRedisCache.getSort;
import static com.util.redis.URLRedisCache.getString;

/**
 * 
 * 版权所有：2017年3月15日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：教师业务
 * 类名称：com.uflowertv.service.impl.TeacherServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月15日 上午11:00:51   
 * 修改人：
 * 修改时间：2017年3月15日 上午11:00:51   
 * 修改备注：   
 * @version   V1.0
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherServiceI{

	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private XxjProductionServiceI xxjProductionService;
	
	/**
	 * 年级下的教师列表
	 * @
	 * @see com.uflowertv.service.TeacherServiceI#getGradeTeacherList(int)
	 */
	@Override
	public Map<String, Object> getGradeTeacherList(int grade_id) {
		log.info("年级下的教师列表");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(grade_id!=0,"年级ID为空");
		List<CommonsEntityJson> list = Lists.newArrayList();
		List<String> teacher_grade = getSort(String.format(TEACHER_GRADE_LIST,grade_id));
		checkArgument(!CollectionUtils.isEmpty(teacher_grade),"年级下的教师列表为空");
		teacher_grade.forEach(teacher_obj->{
			list.add(RedisEntity.getEntity(teacher_obj));
		});
		map.put("code", 200);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 科目下的教师列表
	 * @
	 * @see com.uflowertv.service.TeacherServiceI#getSubjectTeacherList(int)
	 */
	@Override
	public Map<String, Object> getSubjectTeacherList(int subject_id) {
		log.info("科目下的教师列表");
		Map<String, Object> map = Maps.newHashMap();
		List<CommonsEntityJson> list = Lists.newArrayList();
		checkArgument(subject_id!=0,"科目ID为空");
		List<String> teacher_subject = getSort(String.format(TEACHER_SUBJECT_LIST,subject_id));
		checkArgument(!CollectionUtils.isEmpty(teacher_subject),"科目下的教师列表为空");
		teacher_subject.forEach(teacher_obj->{
			list.add(RedisEntity.getEntity(teacher_obj));
		});
		map.put("code", 200);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 教师详情
	 * @see com.uflowertv.service.TeacherServiceI#getTeacherInfo(int)
	 */
	@Override
	public Map<String, Object> getTeacherInfo(int teacher_id) {
		log.info("获取教师详情");
		Map<String, Object> map = Maps.newHashMap();
		List<CommonsEntityJson> list = Lists.newArrayList();
		checkArgument(teacher_id!=0,"教师ID为空");
		CommonsEntityJson teacherEntity = RedisEntity.getEntity(String.format(TEACHER_OBJ, teacher_id));
		checkNotNull(teacherEntity,"教师"+teacher_id+"不存在");
		String grade_list = teacherEntity.getGrade_list();
		checkArgument(StringUtils.isNotBlank(grade_list),"教师下年级列表为空");
		String params = teacherEntity.getParams();
		if(StringUtils.isBlank(params)){
			gradeNames(teacherEntity, grade_list);
			map.put("code", 200);
			map.put("data", teacherEntity);
			return map;
		}
		gradeNames(teacherEntity, grade_list);
		teacherEntity.setGrades(list);
		List<CommonsEntityJson> json2List = JsonUtils.json2List(params,CommonsEntityJson.class);
		json2List.forEach(commonsEntityJson->{
			//内容包信息
			CommonsEntityJson contentEntity = RedisEntity.getEntity(String.format(CONTENT_OBJ, commonsEntityJson.getContent_id()));
			contentEntity.setProduct_id(commonsEntityJson.getProduct_id());
			//产品信息
			CommonsEntityJson productEntity = RedisEntity.getEntity(String.format(PRODUCT_OBJ, commonsEntityJson.getProduct_id()));
			contentEntity.setSubject_type(productEntity.getSubject_type());
			//年级信息
			CommonsEntityJson gradeEntity = RedisEntity.getEntity(String.format(GRADE_OBJ, contentEntity.getGrade_id()));
			contentEntity.setGrade_name(gradeEntity.getGrade_name());
			//科目
			CommonsEntityJson subjectEntity = RedisEntity.getEntity(String.format(SUBJECT_OBJ, contentEntity.getSubject_id()));
			contentEntity.setSubject_image(subjectEntity.getSubject_image());
			list.add(contentEntity);
		});
		map.put("code", 200);
		map.put("data", teacherEntity);
		return map;
	}
	
	private void gradeNames(CommonsEntityJson teacherEntity,String grade_list){
		Iterable<String> grade_ids = Splitter.on(",").trimResults().omitEmptyStrings().split(teacherEntity.getGrade_list());
		StringBuilder sb = new StringBuilder();
		ArrayList<String> grade_names = Lists.newArrayList();
		grade_ids.forEach(grade_id->{
			//年级信息
			CommonsEntityJson gradeEntity = RedisEntity.getEntity(String.format(GRADE_OBJ, grade_id));
			grade_names.add(gradeEntity.getGrade_name());
		});
		Joiner.on("\t").skipNulls().appendTo(sb, grade_names);
		teacherEntity.setGrade_list(sb.toString());
	}
	
	/**
	 * 教师下科目详情
	 * @see com.uflowertv.service.TeacherServiceI#getTeacherSubjectDetail(int, int, int)
	 */
	@Override
	public Map<String,Object> getTeacherSubjectDetail(int user_id,int product_id,int teacher_id) {
		log.info("教师下科目详情");
		Map<String,Object> map = Maps.newHashMap();
		checkArgument(user_id!=0,"用户ID为空");
		checkArgument(product_id!=0,"产品ID为空");
		checkArgument(teacher_id!=0,"教师ID为空");
		CommonsEntityJson productEntity = RedisEntity.getEntity(String.format(PRODUCT_OBJ, product_id));
		checkNotNull(productEntity,"产品"+product_id+"不存在");
		String subject_json_key = String.format(SUBJECT_JSON, teacher_id,productEntity.getGrade_id());
		String json = getString(subject_json_key);
		checkArgument(StringUtils.isNotBlank(json),"教师"+teacher_id+"不存在或教师下无此产品"+product_id);
		CommonsEntityJson entityJson = JsonUtils.json2Bean(json, CommonsEntityJson.class);
		entityJson.setFlag(xxjProductionService.getSynPurchase(user_id, product_id));//产品鉴权
		map.put("code", 200);
		map.put("data", entityJson);
		return map;
	}
}
