package com.util.redis;

import com.util.commons.ConstantHolder;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
 * 版权所有：2017年1月10日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：jedis 工具类
 * 类名称：com.uflowertv.util.RedisUtil     
 * 创建人：liguoliang 
 * 创建时间：2016年7月27日 e下午4:21:47
 * 修改人：
 * 修改时间：2016年7月27日 e下午4:21:47
 * 修改备注：   
 * @version   V1.0
 */
public class RedisUtil {
	/*
	 * // Redis服务器IP private static String ADDR = "192.168.1.159";
	 * 
	 * // Redis的端口号 private static int PORT = 6379;
	 * 
	 * // 访问密码 // private static String AUTH = "admin";
	 * 
	 * // 可用连接实例的最大数目，默认值为8； //
	 * 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	 * private static int MAX_ACTIVE = 300;
	 * 
	 * // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。 private static int MAX_IDLE
	 * = 200;
	 * 
	 * // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	 * private static int MAX_WAIT = 10000;
	 * 
	 * private static int TIMEOUT = 10000;
	 * 
	 * // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的； private
	 * static boolean TEST_ON_BORROW = true;
	 * 
	 * private static JedisPool jedisPool = null;
	 * 
	 *//**
		 * 初始化Redis连接池
		 */
	/*
	 * static { try { JedisPoolConfig config = new JedisPoolConfig();
	 * config.setMaxIdle(MAX_ACTIVE); // change "maxActive" -> "maxTotal" and
	 * "maxWait" -> "maxWaitMillis" // in all examples.
	 * config.setMaxTotal(MAX_ACTIVE); config.setMaxIdle(MAX_IDLE);
	 * config.setMaxWaitMillis(MAX_WAIT);
	 * config.setTestOnBorrow(TEST_ON_BORROW); jedisPool = new JedisPool(config,
	 * ADDR, PORT, TIMEOUT); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 *//**
		 * 获取Jedis实例
		 * 
		 * @return
		 */
	/*
	 * public synchronized static Jedis getJedis() { try { if (jedisPool !=
	 * null) { Jedis resource = jedisPool.getResource(); return resource; } else
	 * { return null; } } catch (Exception e) { e.printStackTrace(); return
	 * null; } }
	 * 
	 *//**
		 * 释放jedis资源
		 * 
		 * @param jedis
		 *//*
		 * public static void returnResource(final Jedis jedis) { if (jedis !=
		 * null) { jedisPool.returnResource(jedis); } }
		 */

	private static JedisPool jedisPool = null;
	/**
	 * 构建redis连接池，单例模式
	 * 
	 * @return JedisPool
	 * 
	 * 
	 */
	public static JedisPool getPool() {
		/**
		 * 线上内网 
		 10.25.178.35
		 */
		 /**
		  * String host = "127.0.0.1";
		  */
		/**
		 * 外网 123.56.176.178
		 */
		if (jedisPool != null) {
			return jedisPool;
		}
		/**
		 * 本地环境
		 */
		String host = ConstantHolder.HOST;
 
		int port = Integer.valueOf(ConstantHolder.PORT); 
		int db = Integer.valueOf(ConstantHolder.DB); 
		/**
		 * 阿里环境
		 */
		/*	String host ="10.25.178.35";
			int port = 9763; */
		JedisPoolConfig config = new JedisPoolConfig();
		// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
		config.setBlockWhenExhausted(true);
		// 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
		config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
		// 是否启用pool的jmx管理功能, 默认true
		config.setJmxEnabled(true);
		// MBean ObjectName = new
		// ObjectName("org.apache.commons.pool2:type=GenericObjectPool,name=" +
		// "pool" + i); 默 认为"pool", JMX不熟,具体不知道是干啥的...默认就好.
		config.setJmxNamePrefix("pool");
		// 是否启用后进先出, 默认true
		config.setLifo(false);
		// 最大空闲连接数, 默认8个
		config.setMaxIdle(500);
		// 最大连接数, 默认8个
		config.setMaxTotal(100000);
		// 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,
		// 默认-1
		config.setMaxWaitMillis(-1);
		// 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
		config.setMinEvictableIdleTimeMillis(1800000);
		// 最小空闲连接数, 默认0
		config.setMinIdle(0);
		// 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
		config.setNumTestsPerEvictionRun(3);
		// 对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数
		// 时直接逐出,不再根据MinEvictableIdleTimeMillis判断 (默认逐出策略)
		config.setSoftMinEvictableIdleTimeMillis(1800000);
		// 在获取连接的时候检查有效性, 默认false
		config.setTestOnBorrow(false);
		// 在空闲时检查有效性, 默认false
		config.setTestWhileIdle(false);
		// 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
		config.setTimeBetweenEvictionRunsMillis(-1);
		jedisPool = new JedisPool(config, host, port, 20000,null,db);
		return jedisPool;
	}

	/**
	 * 获取jedis
	 * 
	 * @author Youzhen Wang
	 * @return
	 */
	public static Jedis getJedis() {
		try {
			return getPool().getResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭一个Jedis
	 * 
	 * @return
	 */
	public static boolean closeJedis(Jedis jedis) {
		if (null != jedis) {
			jedis.close();
		}
		return true;
	}

	/**
	 * 关闭连接池
	 * 
	 * Mrchang
	 */
	public static void closePool() {
		if (jedisPool != null) {
			jedisPool.destroy();
		}
	}

}
