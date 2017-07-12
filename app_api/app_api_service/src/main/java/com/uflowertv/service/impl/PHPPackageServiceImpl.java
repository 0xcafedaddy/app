package com.uflowertv.service.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.uflowertv.dao.*;
import com.uflowertv.model.RedisEntity;
import com.uflowertv.model.po.XxjContent;
import com.uflowertv.model.po.XxjGrade;
import com.uflowertv.model.po.XxjProduct;
import com.uflowertv.model.vo.CommonsEntityJson;
import com.uflowertv.service.PHPPackageServiceI;
import com.util.json.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.util.redis.URLRedisCache.*;
import static com.util.commons.ConstantHolder.*;

/**
 * 
 * 版权所有：2017年3月13日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：PHP打包程序
 * 类名称：com.uflowertv.service.impl.PHPPackageServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月13日 下午4:48:49   
 * 修改人：
 * 修改时间：2017年3月13日 下午4:48:49   
 * 修改备注：   
 * @version   V1.0
 */
@Service("phpPackageService")
public class PHPPackageServiceImpl implements PHPPackageServiceI{
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private XxjProductDaoI xxjProductDao;
	@Autowired
	private XxjContentDaoI xxjContentDao;
	@Autowired
	private XxjVideoDaoI xxjVideoDao;
	@Autowired
	private XxjSpecialListDaoI xxjSpecialListDao;
	@Autowired
	private XxjGradeDaoI xxjGradeDao;


	/**
	 * 
	 * @see com.uflowertv.service.PHPPackageServiceI#getSpecialInfo(int)
	 */
	@Override
	public Map<String, Object> getSpecialInfo(int product_id){
		log.info("获取专题详情");
		Map<String, Object> params = Maps.newHashMap();
		CommonsEntityJson entityJson = CommonsEntityJson.getInstance();
		checkArgument(product_id!=0,"产品ID为空");
		params.put("product_id", product_id);
		params.put("product_type", PRODUCT_SPECIAL);
		String hql = "from XxjProduct where product_id=:product_id and product_type=:product_type";
		XxjProduct xxjProduct = xxjProductDao.getByHql(hql, params);
		checkNotNull(xxjProduct,"产品"+product_id+"不存在");
		Iterable<String> content_list = Splitter.on(",").trimResults().omitEmptyStrings().split(xxjProduct.getContent_list());
		Iterator<String> it = content_list.iterator();
		int special_id = Integer.valueOf(it.next());
		checkArgument(special_id!=0,"专题ID为空");
		CommonsEntityJson specialEntity = RedisEntity.getEntity(String.format(SPECIAL_OBJ,PLATFORM_ID, special_id));
		entityJson.setProduct_id(String.valueOf(product_id));
		entityJson.setProduct_type(String.valueOf(xxjProduct.getProduct_type()));
		entityJson.setSpecial_id(String.valueOf(special_id));
		entityJson.setSpecial_name(specialEntity.getSpecial_name());
		entityJson.setIs_free(specialEntity.getIs_free());
		entityJson.setParams(specialEntity.getParams());
		entityJson.setGrades(getSpecialGradeList(special_id));
		putString(String.format(SPECIAL_JSON,special_id), JsonUtils.bean2Json(entityJson));
		params.clear();
		params.put("code", 200);
		params.put("message", "OK");
		return params;
	}
	
	@SuppressWarnings("rawtypes")
	private List<CommonsEntityJson> getSpecialGradeList(int special_id){
		Map<String, Object> params = Maps.newHashMap();
		List<CommonsEntityJson> entityJsons = Lists.newArrayList();
		params.put("special_id", special_id);
		String sql = "SELECT g.grade_id,g.grade_name FROM xxj_special_list s LEFT JOIN xxj_grade g ON s.grade_id = g.grade_id WHERE s.special_id =:special_id GROUP BY s.grade_id ORDER BY g.sort";
		List<Map> list = xxjSpecialListDao.findBySql(sql,params);
		if(CollectionUtils.isEmpty(list)){
			return Collections.emptyList();
		}
		for (int i = 0; i < list.size(); i++) {
			Map map = list.get(i);
			CommonsEntityJson entityJson = CommonsEntityJson.getInstance();
			int grade_id = (int) map.get("grade_id");
			checkArgument(grade_id!=0,"年级ID为空");
			entityJson.setGrade_id(String.valueOf(grade_id));
			entityJson.setGrade_name((String) map.get("grade_name"));
			entityJson.setSubjects(getSpecialSubjectList(grade_id,special_id));
			entityJsons.add(entityJson);
		}
		return entityJsons;
	}
	
	@SuppressWarnings("rawtypes")
	private List<CommonsEntityJson> getSpecialSubjectList(int grade_id, int special_id) {
		List<CommonsEntityJson> entityJsons = Lists.newArrayList();
		Map<String, Object> params = Maps.newHashMap();
		params.put("special_id", special_id);
		params.put("grade_id", grade_id);
		String sql = "SELECT sb.subject_id,sb.subject_name,sb.subject_image FROM xxj_special_list s LEFT JOIN xxj_subject sb ON s.subject_id = sb.subject_id WHERE s.special_id =:special_id AND s.grade_id =:grade_id GROUP BY s.subject_id ORDER BY sb.sort";
		List<Map> list = xxjSpecialListDao.findBySql(sql,params);
		if(CollectionUtils.isEmpty(list)){
			return Collections.emptyList();
		}
		for (int i = 0; i < list.size(); i++) {
			Map map = list.get(i);
			CommonsEntityJson entityJson = CommonsEntityJson.getInstance();
			int subject_id = (int) map.get("subject_id");
			checkArgument(subject_id!=0,"科目ID为空");
			entityJson.setSubject_id(String.valueOf(subject_id));
			entityJson.setSubject_name((String) map.get("subject_name"));
			entityJson.setSubject_image((String) map.get("subject_image"));
			entityJson.setTerms(getSpecialTermList(subject_id,special_id));
			entityJsons.add(entityJson);
		}
		return entityJsons;
	}
	
	@SuppressWarnings("rawtypes")
	private List<CommonsEntityJson> getSpecialTermList(int subject_id,int special_id){
		List<CommonsEntityJson> terms = Lists.newArrayList();
		Map<String, Object> params = Maps.newHashMap();
		params.put("special_id", special_id);
		params.put("subject_id",subject_id);
		String sql = "SELECT term FROM xxj_special_list WHERE special_id =:special_id AND subject_id=:subject_id GROUP BY term";
		List<Map> list = xxjSpecialListDao.findBySql(sql,params);
		if(CollectionUtils.isEmpty(list)){
			return Collections.emptyList();
		}
		for (int i = 0; i < list.size(); i++) {
			Map map = list.get(i);
			int term = (int) map.get("term");
			checkArgument(term==0 || term==1 || term==2,"学期ID错误");
			switch (term) {
				case 0:
					CommonsEntityJson json1 = CommonsEntityJson.getInstance();
					json1.setTerm("全部");
					json1.setPoints(getSpecialPointList(special_id,subject_id,term));
					terms.add(json1);
					break;
				case 1:
					CommonsEntityJson json2 = CommonsEntityJson.getInstance();
					json2.setId(1);
					json2.setTerm("上学期");
					json2.setPoints(getSpecialPointList(special_id,subject_id,term));
					terms.add(json2);
					break;
				case 2:
					CommonsEntityJson json3 = CommonsEntityJson.getInstance();
					json3.setId(2);
					json3.setTerm("下学期");
					json3.setPoints(getSpecialPointList(special_id,subject_id,term));
					terms.add(json3);
					break;
				default:
					break;
			}
		}
		return terms;
	}
	
	@SuppressWarnings("rawtypes")
	private List<CommonsEntityJson> getSpecialPointList(int special_id,int subject_id,int term){
		List<CommonsEntityJson> entityJsons = Lists.newArrayList();
		Map<String, Object> params = Maps.newHashMap();
		params.put("special_id", special_id);
		params.put("subject_id", subject_id);
		params.put("term", term);
		String sql = "SELECT point_id,point_name FROM xxj_special_list WHERE term=:term AND special_id =:special_id AND subject_id=:subject_id GROUP BY point_id";
		List<Map> list = xxjSpecialListDao.findBySql(sql,params);
		if(CollectionUtils.isEmpty(list)){
			return Collections.emptyList();
		}
		for (int i = 0; i < list.size(); i++) {
			Map map = list.get(i);
			int point_id = (int)map.get("point_id");
			checkArgument(point_id!=0,"知识点ID为空");
			CommonsEntityJson entityJson = CommonsEntityJson.getInstance();
			entityJson.setPoint_id(String.valueOf(point_id));
			entityJson.setPoint_name((String) map.get("point_name"));
			entityJson.setVideos(getSpecialVideoList(special_id,point_id));
			entityJsons.add(entityJson);
		}
		return entityJsons;
	}
	
	private List<CommonsEntityJson> getSpecialVideoList(int special_id,int point_id){
		Map<String, Object> params = Maps.newHashMap();
		params.put("special_id", special_id);
		params.put("point_id", point_id);
		String sql = "SELECT s.video_id,s.video_name,s.is_free,v.courseware_count FROM xxj_special_list s"
					+ "\tLEFT JOIN xxj_video v ON s.video_id = v.video_id"
					+ "\tWHERE s.special_id =:special_id AND s.point_id =:point_id ORDER BY s.sort";
		return getPublicVideoList(xxjSpecialListDao.findBySql(sql,params));
	}
	
	/*#########################################################################################################*/


	/**
	 * 同步课详情
	 * @see com.uflowertv.service.PHPPackageServiceI#getSynCourseInfo(int)
	 */
	@Override
	public Map<String, Object> getSynCourseInfo(int product_id) {
		log.info("获取同步课详情");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(product_id!=0,"产品ID为空");
		map.put("product_id", product_id);
		map.put("product_type", PRODUCT_ALL);
		String hql = "from XxjProduct where product_id=:product_id and product_type=:product_type";
		XxjProduct xxjProduct = xxjProductDao.getByHql(hql, map);
		checkNotNull(xxjProduct,"产品"+product_id+"不存在");
		XxjGrade xxjGrade = xxjGradeDao.getById(XxjGrade.class, xxjProduct.getGrade_id());
		Iterable<String> content_list = Splitter.on(",").trimResults().omitEmptyStrings().split(xxjProduct.getContent_list());
		Iterator<String> it = content_list.iterator();
		while(it.hasNext()){
			int content_id = Integer.valueOf(it.next());
			XxjContent xxjContent = xxjContentDao.getById(XxjContent.class, content_id);
			CommonsEntityJson entityJson = CommonsEntityJson.getInstance();
			entityJson.setProduct_id(String.valueOf(product_id));
			entityJson.setProduct_type(String.valueOf(xxjProduct.getProduct_type()));
			entityJson.setContent_id(String.valueOf(xxjContent.getContent_id()));
			entityJson.setContent_name(xxjContent.getContent_name());
			entityJson.setContent_introduce(xxjContent.getContent_introduce());
			entityJson.setGrade_name(xxjGrade.getGrade_name());
			Iterable<String> video_list = Splitter.on(",").trimResults().omitEmptyStrings().split(xxjContent.getVideo_list());
			checkNotNull(video_list,"视频列表为空");
			List<Integer> vids = Lists.newArrayList();
			video_list.forEach(vid->{vids.add(Integer.valueOf(vid));});
			entityJson.setTerms(getTerms(vids));
			putString(String.format(CONTENT_JSON,content_id), JsonUtils.bean2Json(entityJson));
		}
		map.clear();
		map.put("code", 200);
		map.put("message", "OK");
		return map;
	}
	
	@SuppressWarnings("rawtypes")
	private List<CommonsEntityJson> getTerms(List<Integer> vids){
		List<CommonsEntityJson> terms = Lists.newArrayList();
		Map<String, Object> params = Maps.newHashMap();
		params.put("video_list", vids);
		params.put("video_status", VIDEO_ENABLE);
		String sql = "select term from xxj_video WHERE video_status =:video_status AND video_id IN(:video_list) GROUP BY term ORDER BY sort";
		List<Map> list = xxjVideoDao.findBySql(sql,params);
		for (int i = 0; i < list.size(); i++) {
			Map map = list.get(i);
			int term = (int)map.get("term");
			checkArgument(term==0 || term==1 || term==2,"学期ID错误");
			switch (term) {
				case 0:
					CommonsEntityJson json1 = CommonsEntityJson.getInstance();
					json1.setTerm("全部");
					json1.setPoints(getPointList(vids,term));
					terms.add(json1);
					break;
				case 1:
					CommonsEntityJson json2 = CommonsEntityJson.getInstance();
					json2.setId(1);
					json2.setTerm("上学期");
					json2.setPoints(getPointList(vids, term));
					terms.add(json2);
					break;
				case 2:
					CommonsEntityJson json3 = CommonsEntityJson.getInstance();
					json3.setId(2);
					json3.setTerm("下学期");
					json3.setPoints(getPointList(vids, term));
					terms.add(json3);
					break;
				default:
					break;
			}
		}
		return terms;
	}
	
	@SuppressWarnings("rawtypes")
	private List<CommonsEntityJson> getPointList(List<Integer> vids,int term){
		List<CommonsEntityJson> entityJsons = Lists.newArrayList();
		Map<String, Object> params = Maps.newHashMap();
		params.put("video_list", vids);
		params.put("video_status", VIDEO_ENABLE);
		params.put("term", term);
		String sql = "SELECT p.point_id,p.point_name,p.params FROM xxj_point p LEFT JOIN xxj_video v ON p.point_id = v.point_id WHERE v.video_status =:video_status AND v.term =:term AND v.video_id IN(:video_list) GROUP BY v.point_id ORDER BY p.sort";
		List<Map> pointList = xxjVideoDao.findBySql(sql,params);
		if(CollectionUtils.isEmpty(pointList)){
			return Collections.emptyList();
		}
		for (int i = 0; i < pointList.size(); i++) {
			Map map = pointList.get(i);
			CommonsEntityJson entityJson = CommonsEntityJson.getInstance();
			int point_id = (int) map.get("point_id");
			checkArgument(point_id!=0,"知识点ID为空");
			entityJson.setPoint_id(String.valueOf(point_id));
			entityJson.setPoint_name((String) map.get("point_name"));
			entityJson.setParams((String) map.get("params"));
			entityJson.setVideos(getVideoList(vids,term,point_id));
			entityJsons.add(entityJson);
		}
		return entityJsons;
	}
	
	private List<CommonsEntityJson> getVideoList(List<Integer> vids,int term,int point_id){
		Map<String,Object> params = Maps.newHashMap();
		params.put("term", term);
		params.put("point_id", point_id);
		params.put("video_status", VIDEO_ENABLE);
		params.put("video_list", vids);
		String sql = "SELECT video_id,video_name,is_free,courseware_count FROM xxj_video WHERE video_status =:video_status AND term=:term AND point_id =:point_id AND video_id IN(:video_list) ORDER BY sort";
		return getPublicVideoList(xxjVideoDao.findBySql(sql, params));
	}
	
	/**
	 * 教师科目详情
	 * @see com.uflowertv.service.PHPPackageServiceI#getTeacherSubjectInfo(int)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Map<String,Object> getTeacherSubjectInfo(int teacher_id){
		log.info("获取教师科目详情");
		Map<String,Object> params = Maps.newHashMap();
		checkArgument(teacher_id!=0,"教师ID为空");
		CommonsEntityJson teacherEntity = RedisEntity.getEntity(String.format(TEACHER_OBJ, teacher_id));
		checkNotNull(teacherEntity,"教师"+teacher_id+"不存在");
		String videos = teacherEntity.getParams();
		checkArgument(StringUtils.isNotBlank(videos),"该教师"+teacher_id+"未配置科目信息");
		List<CommonsEntityJson> json2List = JsonUtils.json2List(videos,CommonsEntityJson.class);
		json2List.forEach(commonsEntityJson->{
			Iterable<String> video_list = Splitter.on(",").trimResults().omitEmptyStrings().split(commonsEntityJson.getVideo_list());
			checkNotNull(video_list,"视频列表为空");
			List<Integer> vids = Lists.newArrayList();
			video_list.forEach(vid->{vids.add(Integer.valueOf(vid));});
			params.clear();
			params.put("video_list", vids);
			params.put("video_status", VIDEO_ENABLE);
			String sql = "SELECT g.grade_id,g.grade_name FROM xxj_video v LEFT JOIN xxj_grade g ON v.grade_id = g.grade_id WHERE video_status =:video_status AND video_id IN (:video_list) GROUP BY v.grade_id ORDER BY g.sort";
			List<Map> list = xxjVideoDao.findBySql(sql,params);
			for (int i = 0; i < list.size(); i++) {
				Map map = list.get(i);
				CommonsEntityJson gradeEntity = CommonsEntityJson.getInstance();
				gradeEntity.setGrade_id(String.valueOf((int)map.get("grade_id")));
				gradeEntity.setGrade_name((String) map.get("grade_name"));
				gradeEntity.setSubjects(getSubjectList(vids));
				putString(String.format(SUBJECT_JSON,teacher_id,gradeEntity.getGrade_id()), JsonUtils.bean2Json(gradeEntity));
			}
		});
		params.clear();
		params.put("code", 200);
		params.put("message", "OK");
		return params;
	}
	
	@SuppressWarnings("rawtypes")
	private List<CommonsEntityJson> getSubjectList(List<Integer> vids) {
		List<CommonsEntityJson> entityJsons = Lists.newArrayList();
		Map<String,Object> params = Maps.newHashMap();
		params.put("video_list", vids);
		params.put("video_status", VIDEO_ENABLE);
		String sql = "SELECT s.subject_id,s.subject_name,s.subject_image FROM xxj_video v "
					+ "\tLEFT JOIN xxj_subject s ON v.subject_id = s.subject_id "
					+ "\tWHERE v.video_status =:video_status AND v.video_id IN (:video_list) GROUP BY v.subject_id ORDER BY s.sort";
		List<Map> list = xxjVideoDao.findBySql(sql, params);
		if(CollectionUtils.isEmpty(list)){
			return Collections.emptyList();
		}
		for (int i = 0; i < list.size(); i++) {
			Map map = list.get(i);
			CommonsEntityJson subjectEntity = CommonsEntityJson.getInstance();
			subjectEntity.setSubject_id(String.valueOf((int)map.get("subject_id")));
			subjectEntity.setSubject_name((String) map.get("subject_name"));
			subjectEntity.setSubject_image((String) map.get("subject_image"));
			subjectEntity.setTerms(getTerms(vids));
			entityJsons.add(subjectEntity);
		}
		return entityJsons;
	}

	/**
	 * 零元试听
	 * @see com.uflowertv.service.PHPPackageServiceI#getFreeVideoListInfo(int)
	 */
	@Override
	public Map<String, Object> getFreeVideoListInfo(int grade_id){
		log.info("零元试听");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(grade_id!=0,"年级ID为空");
		CommonsEntityJson gradeEntity = RedisEntity.getEntity(String.format(GRADE_OBJ, grade_id));
		checkNotNull(gradeEntity,"年级"+grade_id+"不存在");
		gradeEntity.setSubjects(getSubjectList(grade_id));
		putString(String.format(FREE_VIDEO_LIST, grade_id), JsonUtils.bean2Json(gradeEntity));
		map.put("code", 200);
		map.put("message", "OK");
		return map;
	}

	@Override
	public List<CommonsEntityJson> getSubjectList(int grade_id) {
		List<CommonsEntityJson> subjects = Lists.newArrayList();
		List<String> subjectList = getSort(String.format(GRADE_SUBJECT_LIST, grade_id));
		if(CollectionUtils.isEmpty(subjectList)){
			return Collections.emptyList();
		}
		subjectList.forEach(subject_obj->{
			CommonsEntityJson subjectEntity = RedisEntity.getEntity(subject_obj);
			String subject_id = subjectEntity.getSubject_id();
			subjectEntity.setVideos(getFreeVideoList(Integer.valueOf(subject_id)));
			subjects.add(subjectEntity);
		});
		return subjects;
	}
	
	private List<CommonsEntityJson> getFreeVideoList(int subject_id) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("is_free", VIDEO_FREE);
		params.put("video_status", VIDEO_ENABLE);
		params.put("subject_id", subject_id);
		String sql = "SELECT video_id,video_name,is_free,courseware_count FROM xxj_video WHERE video_status =:video_status AND is_free = :is_free AND subject_id = :subject_id ORDER BY sort";
		return getPublicVideoList(xxjVideoDao.findBySql(sql, params));
	}
	
	@SuppressWarnings("rawtypes")
	private List<CommonsEntityJson> getPublicVideoList(List<Map> list){
		List<CommonsEntityJson> entityJsons = Lists.newArrayList();
		if(CollectionUtils.isEmpty(list)){
			return Collections.emptyList();
		}
		for (int i = 0; i < list.size(); i++) {
			Map map = list.get(i);
			CommonsEntityJson videoEntity = CommonsEntityJson.getInstance();
			videoEntity.setVideo_id(String.valueOf((int)map.get("video_id")));
			videoEntity.setVideo_name((String) map.get("video_name"));
			videoEntity.setIs_free(String.valueOf((int)map.get("is_free")));
			videoEntity.setCourseware_count(String.valueOf((int)map.get("courseware_count")));
			entityJsons.add(videoEntity);
		}
		return entityJsons;
	}
}
