package com.util.skye;

import java.io.InputStream;
import java.util.Properties;


public class FuncConfig {
	
	private static Properties pro = new Properties();
	
	static {
		loadConfig();
	}

	private static void loadConfig() {
		try {
			InputStream stream = FuncConfig.class.getResourceAsStream("/funcConfig.properties");
			pro.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void loadConfig(String propertiesFileName) {
		try {
			InputStream stream = FuncConfig.class.getResourceAsStream("/"+propertiesFileName+".properties");
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
