package com.util;

import ch.qos.logback.classic.Level;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

public class LogUtil {
	private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

	public static void printLog(String level, String... content) throws Exception {
		level = level.toUpperCase();
		if (level.equals(String.valueOf(Level.DEBUG))) {
			for (String msg : content) {
				logger.debug(msg);
			}
		} else if (level.equals(String.valueOf(Level.INFO))) {
			for (String msg : content) {
				logger.info(msg);
			}
		} else if (level.equals(String.valueOf(Level.WARN))) {
			for (String msg : content) {
				logger.warn(msg);
			}
		} else if (level.equals(String.valueOf(Level.ERROR))) {
			for (String msg : content) {
				logger.error(DateFormatUtils.format(Calendar.getInstance(), "yy/MM/dd HH:mm:ss"));
				logger.error(msg);

			}
		}
	}
}
