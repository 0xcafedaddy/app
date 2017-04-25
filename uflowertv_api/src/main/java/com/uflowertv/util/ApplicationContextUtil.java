package com.uflowertv.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	private static final ApplicationContext applicationContext;
	static {
		applicationContext = new ClassPathXmlApplicationContext(new String[] { "../classes/applicationContext.xml" });
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
