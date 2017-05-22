package com.util;

import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * 
 * 版权所有：2017年3月11日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：将指定字符串编码转换为UTF-8
 * 类名称：com.uflowertv.util.StringEcodingUtil     
 * 创建人：liguoliang 
 * 创建时间：2017年3月11日 上午11:10:22   
 * 修改人：
 * 修改时间：2017年3月11日 上午11:10:22   
 * 修改备注：   
 * @version   V1.0
 */
public class StringEcodingUtil {

	private static Logger log = LoggerFactory.getLogger(StringEcodingUtil.class);
	
	public static String ecodingTransform(String str,String ecoding){
		try {
			return new String(str.getBytes(ecoding),CharEncoding.UTF_8);
		} catch (UnsupportedEncodingException e) {
			log.info("The Character Encoding is not supported");
			e.printStackTrace();
			return null;
		}
	}
	
}
