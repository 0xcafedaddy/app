package com.uflowertv.service.impl;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.uflowertv.dao.XxjProductDaoI;
import com.uflowertv.dao.XxjUserDaoI;
import com.uflowertv.model.RedisEntity;
import com.uflowertv.model.dto.XxjProductDTO;
import com.uflowertv.model.po.XxjOrder;
import com.uflowertv.model.po.XxjProduct;
import com.uflowertv.model.po.XxjUser;
import com.uflowertv.model.vo.CommonsEntityJson;
import com.uflowertv.service.XxjOrderServiceI;
import com.uflowertv.service.XxjUserServiceI;
import com.util.BeanUtilsApache;
import com.util.date.DateTimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.util.commons.ConstantHolder.*;
import static com.util.redis.URLRedisCache.*;

/**
 * 
 * 版权所有：2017年3月9日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：用户业务
 * 类名称：com.uflowertv.service.impl.XxjUserServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月9日 下午3:53:24   
 * 修改人：
 * 修改时间：2017年3月9日 下午3:53:24   
 * 修改备注：   
 * @version   V1.0
 */
@Service("xxjUserService")
public class XxjUserServiceImpl implements XxjUserServiceI{
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private XxjUserDaoI xxjUserDao;
	@Autowired
	private XxjOrderServiceI xxjOrderService;
	@Autowired
	private XxjProductDaoI xxjProductDao;
	
	/**
	 * 通过CA卡号获取用户ID
	 * @ 
	 */
	@Override
	public Map<String, Object> saveUser(int platformId,String card) {
		log.info("通过CA卡号获取用户ID");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(StringUtils.isNotBlank(card),"卡号为空");
		int user_id = save(platformId,card);
		checkArgument(user_id!=0,"用户不存在");
		map.put("code", 200);
		map.put("user_id", user_id);
		return map;
	}
	
	/**
	 * 保存用户信息
	 * @Title: saveUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param queryNo
	 * @return
	 */
	private int save(int platformId, String queryNo) {
		log.info("获取用户ID");
		Map<String, Object> params = Maps.newHashMap();
		String user_id = getString(String.format(CARD,platformId,queryNo));
		if(StringUtils.isNotBlank(user_id)){
			log.info(StringUtils.center("用户在Redis中，获取Boss用户信息开始", 50,"="));
			synExecutor(user_id);
			log.info(StringUtils.center("用户在Redis中，获取Boss用户信息结束", 50,"="));
			return Integer.valueOf(user_id);
		}
		
		XxjUser o = new XxjUser();
		o.setPlatformId(platformId);
		o.setCard(queryNo);
		o.setCreated(new Date());
		params.put("card", queryNo);
		XxjUser xxjUser =xxjUserDao.getByHql("from XxjUser where card =:card", params);
		if(xxjUser!=null){
			putUser(xxjUser);
			putString(String.format(CARD,platformId,queryNo), String.valueOf(xxjUser.getUser_id()));
			log.info(StringUtils.center("用户在数据库中，获取Boss用户信息开始", 50,"="));
			synExecutor(user_id);
			log.info(StringUtils.center("用户在数据库中，获取Boss用户信息结束", 50,"="));
			return xxjUser.getUser_id();
		}else{
			int userId = (int) xxjUserDao.save(o);
			Optional<XxjUser> optional2 = Optional.of(xxjUserDao.getById(XxjUser.class, userId));
			if(optional2.isPresent()){
				putUser(optional2.get());
				putString(String.format(CARD,platformId,queryNo), String.valueOf(optional2.get().getUser_id()));
				log.info(StringUtils.center("用户不存在，获取Boss用户信息开始", 50,"="));
				synExecutor(user_id);  
				log.info(StringUtils.center("用户不存在，获取Boss用户信息结束", 50,"="));
				return optional2.get().getUser_id();
			}
		}
		return 0;
	}
	
	/**
	 * 异步执行
	 * @Title: synExecutor
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param user_id
	 */
	private void synExecutor(String user_id){
		 ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
         cachedThreadPool.execute(new Runnable() {  
             public void run() {  
				xxjOrderService.updateUserPurchaseProduction(Integer.valueOf(user_id));
             }  
         });  
         cachedThreadPool.shutdown();  
	}
	
	/**
	 * 保存用户信息至redis中
	 * @Title: putUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param xxjUser
	 */
	private void putUser(XxjUser xxjUser){
		Map<String, String> map = Maps.newHashMap();
		map.put("user_id", String.valueOf(xxjUser.getUser_id()));
		map.put("platformId", String.valueOf(xxjUser.getPlatformId()));
		map.put("card", Strings.nullToEmpty(xxjUser.getCard()));
		map.put("user_addr", Strings.nullToEmpty(xxjUser.getUser_addr()));
		map.put("user_name", Strings.nullToEmpty(xxjUser.getUser_name()));
		map.put("user_phone", Strings.nullToEmpty(xxjUser.getUser_phone()));
		map.put("post_code", Strings.nullToEmpty(xxjUser.getPost_code()));
		map.put("openId", Strings.nullToEmpty(xxjUser.getOpenId()));
		map.put("created", DateTimeUtil.transDateToString(xxjUser.getCreated()));
		putHV(String.format(USER,xxjUser.getUser_id()), map);
	}
	
	/**
	 * 获取观看记录
	 */
	@Override
	public Map<String, Object> getUserRecord(int platformId,int userId) {
		log.info("获取观看记录");
		Map<String, Object> map = Maps.newHashMap();
		List<CommonsEntityJson> list = Lists.newArrayList();
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(userId!=0,"用户ID为空");
		List<String> sort = getLrange(String.format(RECORD_VIDEO_LIST,platformId,userId), 0, -1);
		checkArgument(!CollectionUtils.isEmpty(sort),"该用户无观看记录");
		sort.forEach(video_obj->{
			list.add(RedisEntity.getEntity(video_obj));
		});
		map.put("code", 200);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 用户已购买产品列表
	 * @Title: getPurchaseList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param platformId
	 * @param userId
	 * @return
	 */
	@Override
	public Map<String, Object> getPurchaseList(int platformId,int userId) {
		log.info("获取用户购买产品列表");
		Map<String, Object> map = Maps.newHashMap();
		List<XxjProductDTO> xxjProductJsons = Lists.newArrayList();
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(userId!=0,"用户ID为空");
		List<XxjOrder> userOrderList = xxjOrderService.getUserOrderList(platformId, userId);
		checkArgument(!CollectionUtils.isEmpty(userOrderList),"用户无可用产品");
		userOrderList.forEach(xxjOrder->{
			XxjProductDTO xxjProductJson = new XxjProductDTO();
			XxjProduct xxjProduct = xxjProductDao.getById(XxjProduct.class, xxjOrder.getProduct_id());
			xxjProductJson.setOrder_effective(DateTimeUtil.transDateToString(xxjOrder.getEffective()));
			xxjProductJson.setOrder_expires(DateTimeUtil.transDateToString(xxjOrder.getExpires()));
			xxjProductJson.setProduct_effective(DateTimeUtil.transDateToString(xxjProduct.getEffective()));
			xxjProductJson.setProduct_expires(DateTimeUtil.transDateToString(xxjProduct.getExpires()));
			BeanUtilsApache.copyProperties(xxjProductJson, xxjOrder);
			BeanUtilsApache.copyProperties(xxjProductJson, xxjProduct);
			xxjProductJsons.add(xxjProductJson);
		});
		checkArgument(!CollectionUtils.isEmpty(xxjProductJsons),"用户无可用产品");
		map.put("code", 200);
		map.put("data", xxjProductJsons);
		return map;
	}
	
	@Override
	public XxjUser getById(int id){
		return xxjUserDao.getById(XxjUser.class,id);
	}
	@Override
	public XxjUser getByHql(String hql, Map<String, Object> params){
		return xxjUserDao.getByHql(hql, params);
	}
}
