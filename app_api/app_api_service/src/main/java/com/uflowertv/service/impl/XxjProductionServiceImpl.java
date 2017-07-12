package com.uflowertv.service.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.uflowertv.dao.*;
import com.uflowertv.model.RedisEntity;
import com.uflowertv.model.dto.XxjHomeDTO;
import com.uflowertv.model.dto.XxjRatedDTO;
import com.uflowertv.model.po.*;
import com.uflowertv.model.vo.CommonsEntityJson;
import com.uflowertv.service.XxjProductionServiceI;
import com.util.BeanUtilsApache;
import com.util.date.DateTimeUtil;
import com.util.json.JsonUtils;
import com.util.redis.URLRedisCache;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.util.commons.ConstantHolder.*;
import static com.util.redis.URLRedisCache.*;

/**
 * 
 * 版权所有：2017年3月8日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：核心接口，所有业务的提供类
 * 类名称：com.uflowertv.service.impl.XxjProductionServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月8日 下午6:01:49   
 * 修改人：
 * 修改时间：2017年3月8日 下午6:01:49   
 * 修改备注：   
 * @version   V1.0
 */
@Service("xxjProductionService")
public class XxjProductionServiceImpl implements XxjProductionServiceI{
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private XxjProductDaoI xxjProductDao;
	@Autowired
	private XxjRatedDaoI xxjRatedDao;
	@Autowired
	private XxjGradeDaoI xxjGradeDao;
	@Autowired
	private XxjUiDaoI xxjUiDao;
	@Autowired
	private XxjSpecialDaoI xxjSpecialDao;
	@Autowired
	private XxjTemplateDaoI xxjTemplateDao;
	@Autowired
	private XxjOrderDaoI xxjOrderDao;

	/**
	 * 首页列表接口
	 * @see XxjProductionServiceI#getHomeJson(int)
	 */
	@Override
	public List<XxjHomeDTO> getHomeJson(int platformId) {
		log.info("获取首页列表");
		List<XxjHomeDTO> list = Lists.newArrayList();
		checkArgument(platformId!=0,"平台ID为空");
		List<String> homeList = getSort(String.format(HOME_LIST,platformId));
		checkArgument(!CollectionUtils.isEmpty(homeList),"首页列表为空");
		homeList.stream().filter(t-> {//不可用
			Map<String, String> hv = getHV(t);
			boolean equals = StringUtils.equals(hv.get("status"), "1");
			if(equals){
				return true;
			}
			return false;
		}).filter(t-> {//已过期
			Map<String, String> hv = getHV(t);
			int days = DateTimeUtil.getDays(hv.get("expires"));
			if(days<0){
				return false;
			}
			return true;
		}).filter(t-> {//未到上线时间
			Map<String, String> hv = getHV(t);
			int days = DateTimeUtil.getDays(hv.get("effective"));
			if(days>0){
				return false;
			}
			return true;
		}).forEach(t->{
			XxjHomeDTO homeJson = new XxjHomeDTO();
			BeanUtilsApache.copyProperties(homeJson , getHV(t));//速度慢于setter
			list.add(homeJson);
		});
		checkArgument(!CollectionUtils.isEmpty(list),"无可用数据");
		return list;
	}
	
	
	/**
	 * 同步科全科产品列表
	 * @see XxjProductionServiceI#getSynProductionList(int, int)
	 */
	@Override
	public Map<String, Object> getSynProductionList(int platformId,int xued_id) {
		log.info("同步科全科产品列表");
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(xued_id!=0,"学段ID为空");
		Map<String, Object> map = Maps.newHashMap();
		List<CommonsEntityJson> list = Lists.newArrayList();
		List<String> sort = getSort(String.format(XUED_GRADE_LIST,xued_id));
		checkArgument(!CollectionUtils.isEmpty(sort),"同步科全科产品列表为空");
		sort.forEach(grade_obj->{
			CommonsEntityJson gradeEntity = RedisEntity.getEntity(grade_obj);
			int grade_id = Integer.valueOf(gradeEntity.getGrade_id());
			checkArgument(grade_id!=0,"年级ID为空");
			gradeEntity.setProductList(getProductList(platformId,grade_id));
			list.add(gradeEntity);
		});
		checkArgument(!CollectionUtils.isEmpty(list),"无可用数据");
		map.put("code", 200);
		map.put("data", list);
		return map;
	}
	
	private List<CommonsEntityJson> getProductList(int platformId, int grade_id) {
		List<CommonsEntityJson> entityJsons = Lists.newArrayList();
		List<String> sort = getSort(String.format(SYN_PRODUCT_LIST,platformId,grade_id));
		if(CollectionUtils.isEmpty(sort)){
			return Collections.emptyList();
		}
		//jdk
		/*for (String product : sort) {
			CommonsEntityJson entityJson = RedisEntity.getEntity(product);
			if(StringUtils.equals(entityJson.getProduct_status(), "2")){//不可用
				continue;
			}else if(DateTimeUtil.getDays(entityJson.getExpires())<0){//已过期
				continue;
			}else if(DateTimeUtil.getDays(entityJson.getEffective())>0){//未到上线时间
				continue;
			}else {
				XxjGrade xxjGrade = xxjGradeDao.getById(XxjGrade.class, Integer.valueOf(entityJson.getGrade_id()));
				entityJson.setGrade_name(xxjGrade.getGrade_name());
				Iterable<String> content_list = Splitter.on(',').trimResults().omitEmptyStrings().split(entityJson.getContent_list());
				entityJson.setSubjects(getSubjectList(entityJson.getProduct_id(), content_list));
				entityJsons.add(entityJson);
			}
		}*/
		
		//lambda
		sort.stream().filter(t-> {//不可用
				CommonsEntityJson entityJson = RedisEntity.getEntity(t);
				boolean equals = StringUtils.equals(entityJson.getProduct_status(), "1");
				if(equals){
					return true;
				}
				return false;
		}).filter(t-> {//已过期
				CommonsEntityJson entityJson = RedisEntity.getEntity(t);
				int days = DateTimeUtil.getDays(entityJson.getExpires());
				if(days<0){
					return false;
				}
				return true;
		}).filter(t-> {//未到上线时间
				CommonsEntityJson entityJson = RedisEntity.getEntity(t);
				int days = DateTimeUtil.getDays(entityJson.getEffective());
				if(days>0){
					return false;
				}
				return true;
		}).forEach(product->{
			CommonsEntityJson entityJson = RedisEntity.getEntity(product);
			XxjGrade xxjGrade = xxjGradeDao.getById(XxjGrade.class, Integer.valueOf(entityJson.getGrade_id()));
			entityJson.setGrade_name(xxjGrade.getGrade_name());
			Iterable<String> content_list = Splitter.on(',').trimResults().omitEmptyStrings().split(entityJson.getContent_list());
			int product_id = Integer.valueOf(entityJson.getProduct_id());
			checkArgument(product_id!=0,"产品ID为空");
			checkNotNull(content_list,"内容包列表为空");
			entityJson.setSubjects(getSubjectList(product_id, content_list));
			entityJsons.add(entityJson);
		});
		return entityJsons;
	}
	
	private List<CommonsEntityJson> getSubjectList(int product_id, Iterable<String> content_list) {
		List<CommonsEntityJson> list = Lists.newArrayList();
		Iterator<String> it = content_list.iterator();
		while(it.hasNext()){
			String content_obj = it.next();
			//内容包对象
			CommonsEntityJson contentEntity = RedisEntity.getEntity(String.format(CONTENT_OBJ,content_obj));
			//产品对象
			CommonsEntityJson productEntity = RedisEntity.getEntity(String.format(PRODUCT_OBJ, product_id));
			String subject_id = contentEntity.getSubject_id();
			CommonsEntityJson subjectEntity = RedisEntity.getEntity(String.format(SUBJECT_OBJ, subject_id));
			contentEntity.setProduct_id(String.valueOf(product_id));
			contentEntity.setSubject_type(productEntity.getSubject_type());
			contentEntity.setSubject_image(subjectEntity.getSubject_image());
			list.add(contentEntity);
		}
		return list;
	}
	
	/**
	 * 同步课产品详情
	 * @see XxjProductionServiceI#getSynProductionDetail(int, int, int)
	 */
	@Override
	public Map<String,Object> getSynProductionDetail(int user_id,int product_id,int content_id){
		log.info("同步课产品详情");
		Map<String,Object> map = Maps.newHashMap();
		checkArgument(user_id!=0,"用户ID为空");
		checkArgument(product_id!=0,"产品ID为空");
		checkArgument(content_id!=0,"内容包ID为空");
		String json = getString(String.format(CONTENT_JSON,content_id));
		checkArgument(StringUtils.isNotBlank(json),"同步课产品详情为空");
		CommonsEntityJson entityJson = JsonUtils.json2Bean(json, CommonsEntityJson.class);
		entityJson.setFlag(getSynPurchase(user_id, product_id));//产品鉴权
		map.put("code", 200);
		map.put("data", entityJson);
		return map; 
	}
	
	/**
	 * 专题产品列表
	 * @see XxjProductionServiceI#getSpecialProductionList(int)
	 */
	@Override
	public Map<String,Object> getSpecialProductionList(int platformId){
		log.info("专题产品列表");
		List<CommonsEntityJson> list = Lists.newArrayList();
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(platformId!=0,"平台ID为空");
		List<String> sort = getSort(String.format(SPECIAL_PRODUCT_LIST,platformId));
		checkArgument(!CollectionUtils.isEmpty(sort),"专题产品列表为空");
		//jdk
		/*for (String product : sort) {
			CommonsEntityJson entityJson = RedisEntity.getEntity(product);
			if(StringUtils.equals(entityJson.getProduct_status(), "2")){//不可用
				continue;
			}else if(DateTimeUtil.getDays(entityJson.getExpires())<0){//已过期
				continue;
			}else if(DateTimeUtil.getDays(entityJson.getEffective())>0){//未到上线时间
				continue;
			}else {
				entityJsons.add(entityJson);
			}
		}*/
		//lambda
		sort.stream().filter(t-> {//不可用
			CommonsEntityJson entityJson = RedisEntity.getEntity(t);
			boolean equals = StringUtils.equals(entityJson.getProduct_status(), "1");
			if(equals){
				return true;
			}
			return false;
		}).filter(t-> {//已过期
			CommonsEntityJson entityJson = RedisEntity.getEntity(t);
			int days = DateTimeUtil.getDays(entityJson.getExpires());
			if(days<0){
				return false;
			}
			return true;
		}).filter(t-> {//未到上线时间
			CommonsEntityJson entityJson = RedisEntity.getEntity(t);
			int days = DateTimeUtil.getDays(entityJson.getEffective());
			if(days>0){
				return false;
			}
			return true;
		}).forEach(t->{
			CommonsEntityJson entityJson = RedisEntity.getEntity(t);
			Iterable<String> split = Splitter.on(",").omitEmptyStrings().trimResults().split(entityJson.getContent_list());
			Iterator<String> iterator = split.iterator();
			int special_id = Integer.valueOf(iterator.next());
			XxjSpecial xxjSpecial = xxjSpecialDao.getById(XxjSpecial.class, special_id);
			int template = xxjSpecial.getTemplate();
			XxjTemplate xxjTemplate = xxjTemplateDao.getById(XxjTemplate.class, template);
			int uiid = xxjTemplate.getUiid();
			XxjUi xxjUi = xxjUiDao.getById(XxjUi.class, uiid);
			String uiUrl = xxjUi.getUiUrl();
			int product_id = Integer.valueOf(entityJson.getProduct_id());
			entityJson.setUrl(uiUrl);
			checkArgument(product_id!=0,"产品ID为空");
			entityJson.setPrices(getProductRatedList(product_id));
			list.add(entityJson);
		});
		checkArgument(!CollectionUtils.isEmpty(list),"无可用数据");
		map.put("code", 200);
		map.put("data", list);
		return map;
	}

	private List<XxjRatedDTO> getProductRatedList(int product_id){
		List<XxjRatedDTO> xxjRatedJsonAll = Lists.newArrayList();
		XxjProduct xxjProduct = xxjProductDao.getById(XxjProduct.class, product_id);
		if(xxjProduct!=null){
			Iterable<String> buy_list = Splitter.on(",").trimResults().omitEmptyStrings().split(xxjProduct.getBuy_type());
			buy_list.forEach(buy_type->{
				Map<String,Object> params = Maps.newHashMap();
				StringBuffer sb = new StringBuffer();
				params.put("product_id", product_id);
				params.put("buy_type", Integer.valueOf(buy_type));
				params.put("rated_type", RATED_UNNORMAL);
				
				sb.append("SELECT p.buy_tips,p.product_name,p.product_type,r.product_type as comboType,r.combo_id,r.show_price,g.grade_name,x.xued_name FROM xxj_rated r")
				  .append("\t LEFT JOIN xxj_product p ON r.product_id = p.product_id")
				  .append("\t LEFT JOIN xxj_grade g ON p.grade_id = g.grade_id")
				  .append("\t LEFT JOIN xxj_xued x ON p.xued_id = x.xued_id")
				  .append("\t WHERE NOW() BETWEEN r.effective AND r.expires")
				  .append("\t AND r.product_id =:product_id AND r.product_type = :buy_type AND r.rated_type = :rated_type");
				List<XxjRatedDTO> ratedPrice = getRatedPrice(sb.toString(), params);
				if(CollectionUtils.isEmpty(ratedPrice)){
					params.clear();
					params.put("product_id", product_id);
					params.put("buy_type", buy_type);
					params.put("rated_type", RATED_NORMAL);
					List<XxjRatedDTO> normalPrice = getRatedPrice(sb.toString(), params);
					if(CollectionUtils.isEmpty(normalPrice)){
						return;
					}
					//正常价
					xxjRatedJsonAll.addAll(normalPrice);
				}
				//促销价
				xxjRatedJsonAll.addAll(ratedPrice);
			});
		}
		return xxjRatedJsonAll;
	}
	
	/**
	 * 专题详情
	 * @see XxjProductionServiceI#getSpecialProductionDetail(int, int)
	 */
	@Override
	public Map<String,Object> getSpecialProductionDetail(int user_id,int product_id) {
		log.info("专题详情");
		Map<String,Object> map = Maps.newHashMap();
		checkArgument(user_id!=0,"用户ID不能为空");
		checkArgument(product_id!=0,"产品ID不能为空");
		CommonsEntityJson productEntity = checkNotNull(RedisEntity.getEntity(String.format(PRODUCT_OBJ, product_id)),"产品"+product_id+"不存在");
		Iterable<String> split = Splitter.on(",").omitEmptyStrings().trimResults().split(productEntity.getContent_list());
		Iterator<String> iterator = split.iterator();
		String special_id = iterator.next();
		String json = getString(String.format(SPECIAL_JSON,special_id));
		checkArgument(StringUtils.isNotBlank(json),"专题详情内容为空");
		CommonsEntityJson entityJson = JsonUtils.json2Bean(json, CommonsEntityJson.class);
		entityJson.setFlag(getSpecialPurchase(user_id, product_id));//产品鉴权
		map.put("code", 200);
		map.put("data", entityJson);
		return map; 
	}
	
	/**
	 * 分类
	 */
	@Override
	public Map<String, Object> getSortList(int platformId) {
		log.info("分类");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(platformId!=0,"平台ID为空");
		List<CommonsEntityJson> list = Lists.newArrayList();
		List<String> xued_list = getSort(XUED_LIST);
		checkArgument(!CollectionUtils.isEmpty(xued_list),"学段列表为空");
		xued_list.forEach(xued_obj->{
			CommonsEntityJson xuedEntity = RedisEntity.getEntity(xued_obj);
			List<String> grade_list = getSort(String.format(XUED_GRADE_LIST,xuedEntity.getXued_id()));
			grade_list.forEach(grade_obj->{
				CommonsEntityJson gradeEntity = RedisEntity.getEntity(grade_obj);
				int grade_id = Integer.valueOf(gradeEntity.getGrade_id());
				checkArgument(grade_id!=0,"年级ID为空");
				List<CommonsEntityJson> productList = getProductList(platformId,grade_id);
				if(CollectionUtils.isEmpty(productList)){
					list.remove(gradeEntity);
				}else{
					gradeEntity.setProductList(productList);
					list.add(gradeEntity);
				}
			});
		});
		checkArgument(!CollectionUtils.isEmpty(list),"无可用数据");
		map.put("code", 200);
		map.put("data", list);
		return map;
	}
	
	
	/**
	 * 获取视频播放地址  同时将该视频存放至观看记录里。
	 * @see XxjProductionServiceI#getVideoUrl(int, int, int)
	 */
	@Override
	public Map<String, Object> getVideoUrl(int platformId, int userId, int video_id){
		log.info("获取视频播放地址  同时将该视频存放至观看记录里");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(userId!=0,"用户ID为空");
		checkArgument(video_id!=0,"视频ID为空");
		//视频播放地址
		String video_url = getString(String.format(VIDEO_URL,platformId,video_id));
		boolean blank = StringUtils.isBlank(video_url);
		checkArgument(!blank,"视频播放地址不存在");
		CommonsEntityJson video = RedisEntity.getEntity(String.format(VIDEO_OBJ, video_id));
		checkNotNull(video,"视频不存在");
		video.setVideo_url(video_url);
		//执行观看业务逻辑
		executeRecord(platformId, userId, video_id);
		map.put("code", 200);
		map.put("data",video);
		return map;
	}
	
	private void executeRecord(int platformId, int userId, int video_id){
		String video_obj_key = String.format(VIDEO_OBJ, video_id);
		String video_obj_list_key = String.format(RECORD_VIDEO_LIST,platformId,userId);
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				//获取观看记录
				List<String> record_list = getSort(video_obj_list_key);
				//首次观看
				if(CollectionUtils.isEmpty(record_list)){
					putLpush(video_obj_list_key,video_obj_key);
					return;
				}
				//是否包含该视频
				boolean contains = record_list.contains(video_obj_key);
				if(contains){
					//先移除，后插入
					lrem(video_obj_list_key,video_obj_key);
					putLpush(video_obj_list_key,video_obj_key);
				}else{
					//观看记录个数为9
					if(record_list.size()>=9){
						//从尾部移除KEY
						removeRpop(video_obj_list_key);
					}
					//视频保存至观看记录里。
					putLpush(video_obj_list_key,video_obj_key);
				}
			}
		});
		executorService.shutdown();
	}

	/**
	 * 所有学段的年级与科目列表
	 * @see XxjProductionServiceI#getGradeSubjectListAll()
	 */
	@Override
	public Map<String,Object> getGradeSubjectListAll() {
		log.info("所有学段的年级与科目列表");
		Map<String,Object> map = Maps.newHashMap();
		List<CommonsEntityJson> list = Lists.newArrayList();
		List<String> xued_list = getSort(XUED_LIST);
		checkArgument(!CollectionUtils.isEmpty(xued_list),"学段列表为空");
		xued_list.forEach(xued_obj->{
			CommonsEntityJson xuedEntity = RedisEntity.getEntity(xued_obj);
            executorGradeList(list,Integer.valueOf(xuedEntity.getXued_id()));
		});
		checkArgument(!CollectionUtils.isEmpty(list),"无可用数据");
		map.put("code", 200);
		map.put("data", list);
		return map;
	}

	private void executorGradeList(List<CommonsEntityJson> list,int xued_id){
		List<String> grade_list = getSort(String.format(XUED_GRADE_LIST,xued_id));
		checkArgument(!CollectionUtils.isEmpty(grade_list),"学段列表为空");
		grade_list.forEach(grade_obj->{
			CommonsEntityJson gradeEntity = RedisEntity.getEntity(grade_obj);
			int grade_id = Integer.valueOf(gradeEntity.getGrade_id());
			checkArgument(grade_id!=0,"年级ID为空");
			List<CommonsEntityJson> subjectList = getSubjectList(grade_id);
			if(CollectionUtils.isEmpty(subjectList)){
				list.remove(gradeEntity);
			}else{
				gradeEntity.setSubjects(subjectList);
				list.add(gradeEntity);
			}
		});
	}

	/**
	 * 学段下的年级与科目列表
	 * @see XxjProductionServiceI#getGradeSubjectList(int)
	 */
	@Override
	public Map<String, Object> getGradeSubjectList(int xued_id){
		log.info("学段下的年级与科目列表");
		Map<String, Object> map = Maps.newHashMap();
		List<CommonsEntityJson> list = Lists.newArrayList();
		checkArgument(xued_id!=0,"学段ID为空");
        executorGradeList(list,xued_id);
		checkArgument(!CollectionUtils.isEmpty(list),"无可用数据");
		map.put("code", 200);
		map.put("data", list);
		return map;
	}
	
	private List<CommonsEntityJson> getSubjectList(int grade_id){
		List<CommonsEntityJson> subjectList = Lists.newArrayList();
		List<String> subject_list = getSort(String.format(GRADE_SUBJECT_LIST,grade_id));
		subject_list.forEach(subject_obj->{
			subjectList.add(RedisEntity.getEntity(subject_obj));
		});
		return subjectList;
	}
	
	/**
	 * 产品定价信息
	 * @see XxjProductionServiceI#getProductRated(int, int, int)
	 */
	@Override
	public Map<String, Object> getProductRated(int platformId,int userId,int product_id) {
		log.info("获取产品订价信息");
		Map<String, Object> map = Maps.newHashMap();
		List<XxjRatedDTO> xxjRatedDTOs = Lists.newArrayList();
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(userId!=0,"用户ID为空");
		checkArgument(product_id!=0,"产品ID为空");
		XxjProduct xxjProduct = xxjProductDao.getById(XxjProduct.class, product_id);
		checkNotNull(xxjProduct,"产品ID不存在");
		List<XxjRatedDTO> productRatedList = getProductRatedList(product_id);
		checkArgument(!CollectionUtils.isEmpty(productRatedList),"无可用数据");
		//判断套餐是否订购
		productRatedList.forEach(xxjRatedDTO->{
			map.clear();
			map.put("platformId", platformId);
			map.put("user_id", userId);
			map.put("oper_comboId", xxjRatedDTO.getCombo_id());
			map.put("order_status", ORDER_SUCCESS);
			String hql = "from XxjOrder WHERE platformId=:platformId AND oper_comboId=:oper_comboId AND user_id =:user_id AND order_status =:order_status AND NOW() BETWEEN effective AND expires";
			List<XxjOrder> list = xxjOrderDao.find(hql,map);
			if(CollectionUtils.isEmpty(list)){
				xxjRatedDTO.setFlag("false");
			}else{
				xxjRatedDTO.setFlag("true");
			}
			xxjRatedDTOs.add(xxjRatedDTO);
		});
		map.clear();
		map.put("code", 200);
		map.put("data", xxjRatedDTOs);
		return map;
	}
	
	@SuppressWarnings("rawtypes")
	private List<XxjRatedDTO> getRatedPrice(String sql, Map<String, Object> params){
		log.info("产品订价");
		List<XxjRatedDTO> xxjRatedJsons = Lists.newArrayList();
		List<Map> list = xxjRatedDao.findBySql(sql,params);
		if(CollectionUtils.isEmpty(list)){
			return Collections.emptyList();
		}
		list.forEach(map->{
			XxjRatedDTO ratedJson = new XxjRatedDTO();
			BeanUtilsApache.copyProperties(ratedJson, map);//速度慢于setter
			xxjRatedJsons.add(ratedJson);
		});
		return xxjRatedJsons;
	}
	
	/**
	 * 查看用户是否购买专题产品 
	 */
	private String getSpecialPurchase(int userId,int product_id){
		log.info("查看用户是否购买专题产品");
		List<String> whiteCards = URLRedisCache.getSort(WHITE_CARD);
		Map<String, String> hv = URLRedisCache.getHV(String.format(USER, userId));
		String card = hv.get("card");
		boolean contains = whiteCards.contains(card);
		if(contains){
			return "true";
		}
		Map<String,Object> params = Maps.newHashMap();
		params.put("user_id", userId);
		params.put("product_id", product_id);
		params.put("status", ORDER_SUCCESS);
		String hql = "select count(order_id) FROM XxjOrder WHERE order_status =:status AND product_id =:product_id AND user_id =:user_id AND NOW() BETWEEN effective AND expires";
		Long count = xxjOrderDao.count(hql, params);
		if(count>0){
			return "true";
		}
		return "false";
	}
	
	/**
	 * 查看用户是否购买同步课产品 
	 * @see XxjProductionServiceI#getSynPurchase(int, int)
	 */
	@Override
	public String getSynPurchase(int userId,int product_id){
		log.info("查看用户是否购买同步课产品");
		List<String> whiteCards = URLRedisCache.getSort(WHITE_CARD); 
		Map<String, String> hv = URLRedisCache.getHV(String.format(USER, userId));
		String card = hv.get("card");
		boolean contains = whiteCards.contains(card);
		if(contains){
			return "true";
		}
		Map<String,Object> params = Maps.newHashMap();
		checkArgument(userId!=0,"用户ID为空");
		checkArgument(product_id!=0,"产品ID为空");
		XxjProduct xxjProduct = xxjProductDao.getById(XxjProduct.class, product_id);
		checkNotNull(xxjProduct,"产品ID不存在");
		int xued_id = xxjProduct.getXued_id();
		checkArgument(xued_id!=0,"学段ID为空");
		params.put("xued_id", xued_id);
		params.put("product_type", PRODUCT_ALL);
		String hql = "SELECT new XxjProduct(product_id, xued_id) FROM XxjProduct WHERE xued_id =:xued_id AND product_type =:product_type";
		List<XxjProduct> xxjProducts = xxjProductDao.find(hql,params);
		checkArgument(!CollectionUtils.isEmpty(xxjProducts),"产品列表为空");
		List<Integer> ids = Lists.newArrayList();
		xxjProducts.forEach(product->{
			ids.add(product.getProduct_id());
		});
		params.clear();
		params.put("user_id", userId);
		params.put("status", ORDER_SUCCESS);
		params.put("ids", ids);
		hql = "select count(order_id) FROM XxjOrder WHERE order_status =:status AND product_id IN (:ids) AND user_id =:user_id AND NOW() BETWEEN effective AND expires";
		//String sql = "SELECT p.product_id FROM xxj_product p LEFT JOIN xxj_order o ON p.product_id=o.product_id WHERE p.product_id = :product_id AND NOW() BETWEEN o.effective AND o.expires AND user_id = :user_id";
		Long count = xxjOrderDao.count(hql, params);
		if(count>0){
			return "true";
		}
		return "false";
	}
	
	/**
	 * 0元试听
	 * @see XxjProductionServiceI#getFreeVideoList(int)
	 */
	@Override
	public Map<String, Object> getFreeVideoList(int grade_id) {
		log.info("0元试听");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(grade_id!=0,"年级ID为空");
		String json = getString(String.format(FREE_VIDEO_LIST, grade_id));
		checkArgument(StringUtils.isNotBlank(json),"0元试听内容为空");
		map.put("code", 200);
		map.put("data",JsonUtils.json2Bean(json, CommonsEntityJson.class));
		return map;		
	}
	
	@Override
	public XxjProduct getById(int id){
		return xxjProductDao.getById(XxjProduct.class, id);
	}
}
