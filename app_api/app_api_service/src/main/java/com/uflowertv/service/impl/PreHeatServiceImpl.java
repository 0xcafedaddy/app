package com.uflowertv.service.impl;


import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.uflowertv.dao.*;
import com.uflowertv.model.RedisEntity;
import com.uflowertv.model.po.*;
import com.uflowertv.model.vo.CommonsEntityJson;
import com.uflowertv.service.PHPPackageServiceI;
import com.uflowertv.service.PreHeatServiceI;
import com.util.BeanUtilsApache;
import com.util.commons.ConstantHolder;
import com.util.date.DateTimeUtil;
import com.util.json.JsonUtils;
import com.util.redis.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.SortingParams;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.util.commons.ConstantHolder.*;
/**
 * 
 * 版权所有：2017年3月8日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：API预热程序
 * 类名称：com.uflowertv.service.impl.PreHeatServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月8日 下午5:52:38   
 * 修改人：
 * 修改时间：2017年3月8日 下午5:52:38   
 * 修改备注：   
 * @version   V1.0
 */
@Service("preHeatService")
public class PreHeatServiceImpl implements PreHeatServiceI{
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private XxjProductDaoI xxjProductDao;
	@Autowired
	private XxjHomeDaoI xxjHomeDao;
	@Autowired
	private XxjGradeDaoI xxjGradeDao;
	@Autowired
	private XxjTeacherDaoI xxjTeacherDao;
	@Autowired
	private XxjSubjectDaoI xxjSubjectDao;
	@Autowired
	private XxjContentDaoI xxjContentDao;
	@Autowired
	private XxjXuedDaoI xxjXuedDao;
	@Autowired
	private XxjVideoDaoI xxjVideoDao;
	@Autowired
	private XxjVideoUrlDaoI xxjVideoUrlDao;
	@Autowired
	private XxjPointDaoI xxjPointDao;
	@Autowired
	private XxjSpecialDaoI xxjSpecialDao;
	@Autowired
	private PHPPackageServiceI phpPackageService;

	@SuppressWarnings("rawtypes")
	@Override
	public void getHomeRelation(){
		//jedis
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			//pipline
			Pipeline pl = jedis.pipelined();
			log.info("开始预热推荐位列表");
			String  homeListKey = String.format(HOME_LIST,PLATFORM_ID);
			/**remove key*/
			pl.expire(homeListKey,0);
			String sql = "SELECT h.*,u.ui_url,u.ui_name FROM xxj_home h LEFT JOIN xxj_ui u ON h.UIID=u.ui_id where h.platformId = 3 AND NOW() BETWEEN h.effective AND h.expires AND h.status = 1 order by h.home_location";
			List<Map> list = xxjHomeDao.findBySql(sql);
			for (int i = 0; i < list.size(); i++) {
				Map map = list.get(i);
				String homeObjKey = String.format(HOME_OBJ, String.valueOf(map.get("home_id")));
				Map<String,String> homeMap = Maps.newHashMap();
				homeMap.put("home_image", Strings.nullToEmpty((String) map.get("home_image")));
				homeMap.put("home_location", String.valueOf(map.get("home_location")));
				homeMap.put("ui_url", Strings.nullToEmpty((String) map.get("ui_url")));
				homeMap.put("ui_name", Strings.nullToEmpty((String) map.get("ui_name")));
				homeMap.put("status", Strings.nullToEmpty(String.valueOf((byte) map.get("status"))));
				homeMap.put("effective", Strings.nullToEmpty(DateTimeUtil.transDateToString((Date)map.get("effective"))));
				homeMap.put("expires", Strings.nullToEmpty(DateTimeUtil.transDateToString((Date)map.get("expires"))));
				homeMap.put("params", Strings.nullToEmpty((String) map.get("params")));
				pl.expire(homeObjKey, 0);
				pl.hmset(homeObjKey, homeMap);
				pl.rpush(homeListKey, homeObjKey);
			}
			List<Map> notice = xxjHomeDao.findBySql("select notice from xxj_notice");
			for (int i = 0; i < notice.size(); i++) {
				Map map = notice.get(i);
				String noticeKey = String.format(NOTICE, PLATFORM_ID);
				pl.expire(noticeKey, 0);
				pl.set(noticeKey, map.get("notice").toString());
			}
			pl.sync();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	
	/**
	 * 预热产品相关DATA
	 * @Title: testProductRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	@Override
	public void getProductRelation(){
		//jedis
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			//pipline
			Pipeline p = jedis.pipelined();
			log.info("开始预热产品");
			//年级下的产品列表
			List<XxjGrade> xxjGrades = xxjGradeDao.find("from XxjGrade");
			xxjGrades.forEach(grade->{
				String gradeProductListKey = String.format(SYN_PRODUCT_LIST, PLATFORM_ID,grade.getGrade_id());
				p.expire(gradeProductListKey, 0);
				List<XxjProduct> xxjProducts = xxjProductDao.find("from XxjProduct WHERE product_type=1 and grade_id ="+grade.getGrade_id()+" order by sort");
				xxjProducts.forEach(product->{
					//同步课产品对象
					int id = product.getProduct_id();
					String productObjKey = String.format(PRODUCT_OBJ, id);
					p.expire(productObjKey, 0);
					Map<String, String> describe = BeanUtilsApache.describe(product);
					describe.put("effective", DateTimeUtil.transDateToString(product.getEffective()));
					describe.put("expires", DateTimeUtil.transDateToString(product.getExpires()));
					describe.put("subject_type", Strings.nullToEmpty(String.valueOf(product.getSubject_type())));
					p.hmset(productObjKey, describe);
					p.rpush(gradeProductListKey, productObjKey);
				});
			});

			//专题产品列表
			String gradeSpecialProductListKey = String.format(SPECIAL_PRODUCT_LIST, PLATFORM_ID);
			p.expire(gradeSpecialProductListKey,0);
			List<XxjProduct> specials = xxjProductDao.find("from XxjProduct WHERE product_type=3 order by sort");
			specials.forEach(product->{
				//专题产品对象
				int id = product.getProduct_id();
				String productObjKey = String.format(PRODUCT_OBJ, id);
				p.expire(productObjKey,0);
				Map<String, String> describe = BeanUtilsApache.describe(product);
				describe.put("effective", DateTimeUtil.transDateToString(product.getEffective()));
				describe.put("expires", DateTimeUtil.transDateToString(product.getExpires()));
				describe.put("subject_type", Strings.nullToEmpty(String.valueOf(product.getSubject_type())));
				p.hmset(productObjKey, describe);
				p.rpush(gradeSpecialProductListKey, productObjKey);
				//专题对象
                XxjSpecial xxjSpecial = xxjSpecialDao.getById(XxjSpecial.class, Integer.valueOf(product.getContent_list()));
                String specialKey = String.format(SPECIAL_OBJ, PLATFORM_ID,xxjSpecial.getSpecial_id());
				p.expire(specialKey,0);
				Map<String, String> describe2 = BeanUtilsApache.describe(xxjSpecial);
				describe2.put("is_free",String.valueOf(product.getIs_free()));
				p.hmset(specialKey, describe2);
			});
			p.sync();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	
	@Override
	public void getProductionInfo(){
		List<XxjProduct> xxjProducts = xxjProductDao.find("from XxjProduct WHERE product_type=1");
		xxjProducts.forEach(xxjProduct->{
			Integer product_id = xxjProduct.getProduct_id();
			//产品详情
			phpPackageService.getSynCourseInfo(product_id);
		});
		List<XxjProduct> specials = xxjProductDao.find("from XxjProduct WHERE product_type=3");
		specials.forEach(special->{
			//专题详情
			phpPackageService.getSpecialInfo(special.getProduct_id());
		});
		List<XxjTeacher> teachers = xxjTeacherDao.find("from XxjTeacher");
		teachers.forEach(teacher->{
			//获取教师科目详情
			phpPackageService.getTeacherSubjectInfo(teacher.getTc_id());
		});
	}
	
	/**
	 * 内容包相关预热DATA
	 * @Title: testContentRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	@Override
	public void getContentRelation(){
		log.info("开始预热内容包");
		//jedis
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			//pipline
			Pipeline p = jedis.pipelined();
			List<XxjContent> xxjContents = xxjContentDao.find("from XxjContent order by sort");
			xxjContents.forEach(xxjContent->{
				String content_key = String.format(CONTENT_OBJ, xxjContent.getContent_id());
				Map<String, String> describe = BeanUtilsApache.describe(xxjContent);
				p.expire(content_key,0);
				p.hmset(content_key, describe);
			});
			p.sync();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 预热学段相关DATA
	 * @Title: testXuedRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	@Override
	public void getXuedRelation(){
		//jedis
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			//pipline
			Pipeline p = jedis.pipelined();
			log.info("开始预热学段");
			p.expire(XUED_LIST,0);
			List<XxjXued> xuedList = xxjXuedDao.find("from XxjXued order by sort");
			xuedList.forEach(xued->{
				//学段对象
				String xuedObjKey = String.format(XUED_OBJ, xued.getXued_id());
				Map<String, String> describe = BeanUtilsApache.describe(xued);
				p.expire(xuedObjKey,0);
				p.hmset(xuedObjKey, describe);
				p.rpush(XUED_LIST, xuedObjKey);
				
				//学段下的年级
				String xued_grade = String.format(XUED_GRADE_LIST, xued.getXued_id());
				p.expire(xued_grade,0);
				List<XxjGrade> gradeList = xxjGradeDao.find("from XxjGrade WHERE xued_id = "+xued.getXued_id()+" order by sort");
				gradeList.forEach(grade->{
					//年级对象
					String gradeObjKey = String.format(GRADE_OBJ, grade.getGrade_id());
					Map<String, String> describe2 = BeanUtilsApache.describe(grade);
					p.expire(gradeObjKey,0);
					p.hmset(gradeObjKey, describe2);
					p.rpush(xued_grade, gradeObjKey);//学段下的年级
					
					//年级下的科目
					String grade_subject = String.format(GRADE_SUBJECT_LIST, grade.getGrade_id());
					p.expire(grade_subject,0);
					List<XxjSubject> subjectList = xxjSubjectDao.find("from XxjSubject  WHERE grade_id = "+grade.getGrade_id()+" ORDER BY sort");
					subjectList.forEach(subject->{
						//科目对象
						String subjectObjKey = String.format(SUBJECT_OBJ, subject.getSubject_id());
						Map<String, String> describe3 = BeanUtilsApache.describe(subject);
						p.expire(subjectObjKey,0);
						p.hmset(subjectObjKey, describe3);
						p.rpush(grade_subject, subjectObjKey);//年级下的科目
					});
				});
			});
			p.sync();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}

	/**
	 * 预热知识点相关DATA
	 * @Title: testPointRealtion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * SELECT point_id,point_name,xued_id,grade_id,subject_id,term,sort,params 
	 */
	@Override
	public void getPointRealtion(){
		//jedis
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			//pipline
			Pipeline p = jedis.pipelined();
			log.info("开始预热知识点");
			List<XxjPoint> pointList = xxjPointDao.find("from XxjPoint order by sort");
			pointList.forEach(xxjPoint->{
				String key = String.format(POINT_OBJ, xxjPoint.getPoint_id());
				Map<String, String> describe = BeanUtilsApache.describe(xxjPoint);
				describe.put("params", Strings.nullToEmpty(xxjPoint.getParams()));
				p.expire(key,0);
				p.hmset(key, describe);
			});
			p.sync();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			RedisUtil.closeJedis(jedis);
		}
		
	}

	
	/**
	 * 预热视频相关DATA
	 * @Title: testVideoRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	@Override
	public void getVideoRelation(){
		//jedis
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			//pipline
			Pipeline p = jedis.pipelined();
			log.info("开始预热视频");
			String hql = "FROM XxjVideo";
			List<XxjVideo> videoList = xxjVideoDao.find(hql);
			videoList.forEach(video->{
				String videoObjKey = String.format(VIDEO_OBJ, video.getVideo_id());
				String vid = String.valueOf(video.getTerm());
				if(StringUtils.equals(vid, "null")){
					video.setTerm(0);
				}
				Map<String, String> describe = BeanUtilsApache.describe(video);
				p.expire(videoObjKey,0);
				p.hmset(videoObjKey, describe);
			});
			p.sync();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 
	 * @see com.uflowertv.service.PreHeatServiceI#getVideoUrlRelation()
	 */
	@Override
	public void getVideoUrlRelation(){
		//jedis
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			//pipline
			Pipeline p = jedis.pipelined();
			log.info("开始预热视频地址");
			//video url
			String hql = "FROM XxjVideoUrl";
			List<XxjVideoUrl> list = xxjVideoUrlDao.find(hql);
			list.forEach(xxjvideoUrl->{
				String videoUrlKey = String.format(VIDEO_URL, PLATFORM_ID,xxjvideoUrl.getVideo_id());
				p.expire(videoUrlKey,0);
				p.set(videoUrlKey, Strings.nullToEmpty(xxjvideoUrl.getVideo_url()));
			});
			p.sync();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	

	/**
	 * 预热教师相关DATA
	 * @Title: testTeacherRelation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	@Override
	public void getTeacherRelation(){
		//jedis
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			//pipline
			Pipeline p = jedis.pipelined();
			log.info("开始预热教师");
			//根据年级获取教师列表
			List<XxjGrade> gradeList = xxjGradeDao.find("from XxjGrade ORDER BY sort");
			gradeList.forEach(grade->{
				String teacherGradeKey = String.format(TEACHER_GRADE_LIST, grade.getGrade_id());
				p.expire(teacherGradeKey,0);
				List<XxjVideo> teacherGradeList = xxjVideoDao.find("from XxjVideo where grade_id="+grade.getGrade_id()+" group by teacher_id");
				teacherGradeList.forEach(video->{
					p.rpush(teacherGradeKey,String.format(TEACHER_OBJ, video.getTeacher_id()));
				});
				//根据年级及科目获取教师列表
				List<XxjSubject> subjectList = xxjSubjectDao.find("from XxjSubject where grade_id="+grade.getGrade_id()+" ORDER BY sort");
				subjectList.forEach(subject->{
					String teacherSubjectKey = String.format(TEACHER_SUBJECT_LIST, subject.getSubject_id());
					p.expire(teacherSubjectKey,0);
					List<XxjVideo> teacherSubjectList = xxjVideoDao.find("from XxjVideo where subject_id="+subject.getSubject_id()+" group by teacher_id");
					teacherSubjectList.forEach(video->{
						p.rpush(teacherSubjectKey, String.format(TEACHER_OBJ, video.getTeacher_id()));
					});
				});
			});
			
			//教师对象
			List<XxjTeacher> teachers = xxjTeacherDao.find("from XxjTeacher ORDER BY sort");
			teachers.forEach(teacher->{
				String teacherObjKey = String.format(TEACHER_OBJ, teacher.getTc_id());
				Map<String, String> describe = BeanUtilsApache.describe(teacher);
				describe.put("params", Strings.nullToEmpty(teacher.getParams()));
				p.expire(teacherObjKey,0);
				p.hmset(teacherObjKey, describe);
			});
			p.sync();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
    /**
     * 预热0元试听相关DATA
     * @Title: testTestSubjectInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    @Override
    public void getFreeVideoRelation(){
        //jedis
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();
            //pipline
            Pipeline p = jedis.pipelined();
            log.info("开始预热0元试听");
            SortingParams params = new SortingParams();
            params.by("sort");
            params.asc();
            params.alpha();
            Response<List<String>> response = p.sort(XUED_LIST,params);
            p.sync();
            List<String> xuedList = response.get();
            xuedList.forEach(xued_obj->{
                CommonsEntityJson xuedEntity = RedisEntity.getEntity(xued_obj);
                String xued_id = xuedEntity.getXued_id();
                Response<List<String>> response2 = p.sort(String.format(XUED_GRADE_LIST, xued_id),params);
                p.sync();
                List<String> gradeList = response2.get();
                gradeList.forEach(grade_obj->{
                    CommonsEntityJson gradeEntity = RedisEntity.getEntity(grade_obj);
                    String grade_id = gradeEntity.getGrade_id();
                    gradeEntity.setSubjects(phpPackageService.getSubjectList(Integer.valueOf(grade_id)));
                    p.set(String.format(ConstantHolder.FREE_VIDEO_LIST, grade_id), JsonUtils.bean2Json(gradeEntity));
                });
            });
            p.sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtil.closeJedis(jedis);
        }
    }
}