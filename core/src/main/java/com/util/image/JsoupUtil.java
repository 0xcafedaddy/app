package com.util.image;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 
 * 版权所有：2017年2月23日-油菜花
 * 项目名称：uflowertv_wx   
 *
 * 类描述：图片工具
 * 类名称：com.uflowertv.util.JsoupUtil     
 * 创建人：liguoliang 
 * 创建时间：2015年9月23日下午5:04:51   
 * 修改人：
 * 修改时间：2015年9月23日下午5:04:51
 * 修改备注：   
 * @version   V1.0
 */
public class JsoupUtil {
	private static Logger log = LoggerFactory.getLogger(JsoupUtil.class);

	/**
	 * 获取DOM
	 * liguoliang
	 * 2015年9月23日下午5:04:51
	 * @param urlString
	 * @return Document
	 */
	public static Document getDocument(String urlString) {
		Document document = null;
		try {
			document = Jsoup.connect(urlString).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("获取联接失败" + e.getMessage());
		}
		return document;
	}

	/**
	 * 通过URL获取元素
	 * liguoliang
	 * 2015年9月23日下午5:05:05
	 * @param urlString
	 * @param cssQuery
	 * @return Elements
	 */
	public static Elements getElements(String urlString, String cssQuery) {
		return getElements(getDocument(urlString), cssQuery);
	}

	/**
	 * 通过DOM获取元素
	 * liguoliang
	 * 2015年9月23日下午5:05:47
	 * @param document
	 * @param cssQuery
	 * @return Elements
	 */
	public static Elements getElements(Document document, String cssQuery) {
		return document.select(cssQuery);
	}

	/**
	 * 通过URL获取元素文本信息
	 * liguoliang
	 * 2015年9月23日下午5:06:14
	 * @param urlString
	 * @param cssQuery
	 * @return String[]
	 */
	public static String[] getElementsStringArray(String urlString, String cssQuery) {
		return getElementsStringArray(getDocument(urlString), cssQuery);
	}

	/**
	 * 通过DOM获取元素文本信息
	 * liguoliang
	 * 2015年9月23日下午5:07:08
	 * @param document
	 * @param cssQuery
	 * @return String[]
	 */
	public static String[] getElementsStringArray(Document document, String cssQuery) {
		return getElementsStringArray(getElements(document, cssQuery));
	}

	/**
	 * 获取元素文本信息
	 * liguoliang
	 * 2015年9月23日下午5:07:41
	 * @param elements
	 * @return String[]
	 */
	public static String[] getElementsStringArray(Elements elements) {
		String[] stringArray = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			stringArray[i] = elements.get(i).text().trim();
		}
		return stringArray;
	}

	/**
	 * 获取第一个元素
	 * liguoliang
	 * 2015年9月23日下午5:08:26
	 * @param document
	 * @param cssQuery
	 * @return Element
	 */
	public static Element getElement(Document document, String cssQuery) {
		return document.select(cssQuery).first();
	}

	/**
	 * 获取指定DOM文本信息
	 * liguoliang
	 * 2015年9月23日下午5:09:03
	 * @param document
	 * @param cssQuery
	 * @return String
	 */
	public static String getElementString(Document document, String cssQuery) {
		return getElement(document, cssQuery).text();
	}
}