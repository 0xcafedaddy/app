package com.uflowertv.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * 版权所有：2017年2月24日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：JAVA对象复制
 * 类名称：com.uflowertv.util.BeanUtilsExt     
 * 创建人：liguoliang 
 * 创建时间：2017年2月24日 下午1:59:11   
 * 修改人：
 * 修改时间：2017年2月24日 下午1:59:11   
 * 修改备注：   
 * @version   V1.0
 */
public class BeanUtilsApache extends BeanUtils{
	private static Logger log = LoggerFactory.getLogger(BeanUtilsApache.class);
	
	 static{
	    ConvertUtils.register(new DateConverter(), java.util.Date.class);
	  }
	
	/**
	 * 对象间复制
	 * @Title: copyProperties
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param dest
	 * @param orig
	 */
	public static void copyProperties(Object dest, Object orig){
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			log.error("访问权限错误："+e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			log.error("由jar包冲突因起的编译错误："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 将MAP转为对象
	 * @Title: populate
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param dest
	 * @param map
	 */
	public static void populate(Object dest, Map<String, ? extends Object> map){
		try {
			BeanUtils.populate(dest, map);
		} catch (IllegalAccessException e) {
			log.error("访问权限错误："+e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			log.error("由jar包冲突因起的编译错误："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 将对象转为MAP
	 * @Title: describe
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param bean
	 * @return
	 */
	public static Map<String, String> describe(Object bean){
		try {
			return BeanUtils.describe(bean);
		} catch (IllegalAccessException e) {
			log.error("访问权限错误："+e.getMessage());
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			log.error("由jar包冲突因起的编译错误："+e.getMessage());
			e.printStackTrace();
			return null;
		} catch (NoSuchMethodException e) {
			log.error("获取构造方法错误："+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}