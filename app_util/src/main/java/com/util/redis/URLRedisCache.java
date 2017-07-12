package com.util.redis;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
/**
 * 
 * 版权所有：2017年1月10日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：jedis 操作类
 * 类名称：com.uflowertv.util.URLRedisCache     
 * 创建人：liguoliang 
 * 创建时间：2016年7月27日 下午4:22:03   
 * 修改人：liguoliang
 * 修改时间：2017年1月11日 上午10:51:23
 * 修改备注：   
 * @version   V1.0
 */
public class URLRedisCache{
	
	/**************************************************复合对象**********************************************************/
	public static void putObject(Object key, Object value) {
		Jedis jedis=null;
		try {
			jedis=RedisUtil.getJedis();
			jedis.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
		
	}
	
	public static Object getObject(Object key) {
		Jedis jedis= null;
		try {
			jedis=RedisUtil.getJedis();
			Object value = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.toString())));
			return value;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	public static Object removeObject(Object key) {
		Jedis jedis=null;
		try {
			jedis=RedisUtil.getJedis();
			return jedis.expire(SerializeUtil.serialize(key.toString()), 0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			RedisUtil.closeJedis(jedis);
		}
	}

	public static void clear() {
		Jedis jedis=null;
		try {
			jedis=RedisUtil.getJedis();
			jedis.flushDB();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}

	public static int getSize() {
		return Integer.valueOf(RedisUtil.getJedis().dbSize().toString());
	}

	/*****************************************************简单类型********************************************************/
	
	public static void putString(String key, String value){
		Jedis jedis=null;
		try {
			jedis=RedisUtil.getJedis();
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 保存
	 * @Title: putStrings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 * @param value
	 */
	public static void putHV(String key, Map<String,String> value) {
		Jedis jedis=null;
		try {
			jedis = RedisUtil.getJedis();
			jedis.hmset(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 从头部插入
	 * @Title: putLpush
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 * @param members
	 */
	public static void putLpush(String key, String ...members) {
		Jedis jedis=null;
		try {
			jedis = RedisUtil.getJedis();
			jedis.lpush(key, members);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}

	/**
	 * 从尾部移除
	 * @Title: popRrange
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 */
	public static void removeRpop(String key) {
		Jedis jedis=null;
		try {
			jedis=RedisUtil.getJedis();
			jedis.rpop(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 获取hashmap
	 * @Title: getHV
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 * @return
	 */
	public static Map<String, String> getHV(String key) {
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			return jedis.hgetAll(key);
		} catch (Exception e) {
			e.printStackTrace();	
			return null;
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 获取List
	 * @Title: getStrings
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 * @return
	 */
	public static List<String> getSort(String key) {
		Jedis jedis = null;
		try {
			jedis=RedisUtil.getJedis();
			SortingParams params = new SortingParams();
			params.by("sort");
			params.asc();
			params.alpha();
			return jedis.sort(key,params);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	public static List<String> getSortDESC(String key) {
		Jedis jedis=null;
		try {
			jedis=RedisUtil.getJedis();
			SortingParams params = new SortingParams();
			params.by("sort");
			params.desc();
			params.alpha();
			return jedis.sort(key,params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 获取list分页
	 * @Title: getLrange
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> getLrange(String key,long start,long end) {
		Jedis jedis=null;
		try {
			jedis = RedisUtil.getJedis();
			return jedis.lrange(key, 0, -1);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 获取String
	 * @Title: getString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 * @return
	 */
	public static String getString(String key){
		Jedis jedis = null;
		try {
			jedis=RedisUtil.getJedis();
			return jedis.get(key);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 移除
	 * @Title: remove
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 * @return
	 */
	public static Long remove(String key) {
		Jedis jedis=RedisUtil.getJedis();
		try {
			jedis=RedisUtil.getJedis();
			return jedis.expire(key, 0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 查看key是否存在
	 * @param key
	 * @return
	 */
	public static boolean exists(String key) {
		Jedis jedis=null;
		try {
			jedis=RedisUtil.getJedis();
			return jedis.exists(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}
	
	/**
	 * 移除已存在的值
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long lrem(String key,String value) {
		Jedis jedis= null;
		try {
			jedis = RedisUtil.getJedis(); 
			return jedis.lrem(key, 0, value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			RedisUtil.closeJedis(jedis);
		}
	}
}
