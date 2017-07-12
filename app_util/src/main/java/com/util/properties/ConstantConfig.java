package com.util.properties;

import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 版权所有：2017年2月23日-油菜花
 * 项目名称：uflowertv_wx   
 *
 * 类描述：读取配置文件类
 * 类名称：com.uflowertv.util.ConstantConfig     
 * 创建人：liguoliang 
 * 创建时间：2017年2月23日 下午5:44:23   
 * 修改人：
 * 修改时间：2017年2月23日 下午5:44:23   
 * 修改备注：   
 * @version   V1.0
 */
public class ConstantConfig {
	
	private static Properties pro = new Properties();
	
	static {
		loadConfig();
	}

	private static void loadConfig() {
		try {
			InputStream stream = ConstantConfig.class.getResourceAsStream("/constant.properties");
			pro.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void loadConfig(String propertiesFileName) {
		try {
			InputStream stream = ConstantConfig.class.getResourceAsStream("/"+propertiesFileName+".properties");
			pro.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String proName) {
			return pro.getProperty(proName);
	}


	public static String getProperty(String proName, String defaultValue) {
			return pro.getProperty(proName, defaultValue);
	}

}
