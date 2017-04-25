package com.uflowertv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.SortParameters.Order;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.query.SortQueryBuilder;
import org.springframework.stereotype.Repository;

import com.uflowertv.dao.RedisCommonsDaoI;
import com.uflowertv.model.vo.CommonsEntityJson;
/**
 * 
 * 版权所有：2016年11月1日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：
 * 类名称：com.uflowertv.dao.impl.WlClassDaoImpl     
 * 创建人：liguoliang 
 * 创建时间：2016年11月1日 下午5:27:00   
 * 修改人：
 * 修改时间：2016年11月1日 下午5:27:00   
 * 修改备注：   
 * @version   V1.0
 */
@Repository("redisCommonsDao")
public class RedisCommonsDaoImpl implements RedisCommonsDaoI{
	@Autowired  
	private RedisTemplate<String, Object> redisTemplate;  
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> opsForValue ;
	@Resource(name = "redisTemplate")
	private ListOperations<String, Object> opsForList;
	@Resource(name = "redisTemplate")
	private SetOperations<String, Object> opsForSet ;
	@Resource(name = "redisTemplate")
	private HashOperations<String, Object, Object> opsForHash ;
	@Resource(name = "redisTemplate")
	private ZSetOperations<String, Object> opsForZSet ;
	
	
	@Override
	public List<CommonsEntityJson> getCommonsList(String listKey) {
		SortQueryBuilder<String> sort = SortQueryBuilder.sort(listKey);
		sort.by("id");
		sort.order(Order.DESC);
		List<Object> sort2 = redisTemplate.sort(sort.build());
		List<CommonsEntityJson> entityJsons = new ArrayList<CommonsEntityJson>();
		for (Object object : sort2) {
			CommonsEntityJson entityJson = (CommonsEntityJson) object;
			entityJsons.add(entityJson);
		}
		return entityJsons;
	}

	@Override
	public CommonsEntityJson getCommonsDetail(String listKey) {
		CommonsEntityJson entityJson = (CommonsEntityJson) opsForValue.get(listKey);
		return entityJson;
	}
}
