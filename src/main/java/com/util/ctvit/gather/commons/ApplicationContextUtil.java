package com.util.ctvit.gather.commons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	private static final ApplicationContext applicationContext;
	static {
		applicationContext = new ClassPathXmlApplicationContext(new String[] { "../classes/config/applicationContext.xml", "../classes/config/applicationContext-wsclient.xml" });
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
