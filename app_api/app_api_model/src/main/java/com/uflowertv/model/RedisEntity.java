package com.uflowertv.model;

import com.uflowertv.model.vo.CommonsEntityJson;
import com.util.BeanUtilsApache;
import com.util.redis.URLRedisCache;
import org.springframework.util.CollectionUtils;

import java.util.Map;
/**
 * 
 * 版权所有：2017年3月8日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：Redis实体类
 * 类名称：RedisEntity
 * 创建人：liguoliang 
 * 创建时间：2017年3月8日 下午5:59:19   
 * 修改人：
 * 修改时间：2017年3月8日 下午5:59:19   
 * 修改备注：   
 * @version   V1.0
 */
public class RedisEntity {

	public static CommonsEntityJson getEntity(String key){
		CommonsEntityJson entityJson = CommonsEntityJson.getInstance();
		Map<String, String> map = URLRedisCache.getHV(key);
		if(CollectionUtils.isEmpty(map)){
			return null;
		}
		BeanUtilsApache.populate(entityJson, map);
		return entityJson;
	}
}
