package com.uflowertv.util;

import java.util.ResourceBundle;

/**
 * 
 * 版权所有：2017年2月23日-油菜花
 * 项目名称：uflowertv_wx   
 *
 * 类描述：项目参数工具类
 * 类名称：com.uflowertv.util.ConfigUtil     
 * 创建人：liguoliang 
 * 创建时间：2017年2月23日 下午5:45:53   
 * 修改人：
 * 修改时间：2017年2月23日 下午5:45:53   
 * 修改备注：   
 * @version   V1.0
 */
public class ConfigUtil {

	private static final ResourceBundle bundle = ResourceBundle.getBundle("constant");

	/**
	 * 获得sessionInfo名字
	 * 
	 * @return
	 */
	public static final String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}

	/**
	 * 通过键获取值
	 * 
	 * @param key
	 * @return
	 */
	public static final String get(String key) {
		return bundle.getString(key);
	}

}
