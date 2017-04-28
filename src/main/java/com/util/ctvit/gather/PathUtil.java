package com.util.ctvit.gather;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class PathUtil {
	private static String webroot;

	private static String classpath;

	public static StringBuffer attribute = new StringBuffer();

	public static List<String> list = new ArrayList<String>();

	/**
	 * 
	 * @return classpath
	 */
	public static String getClasspath() {
		classpath = PathUtil.class.getClassLoader().getResource("/").getPath();
		return classpath;

	}

	/**
	 * 
	 * @return webroot
	 */
	public static String getWebroot() {
		classpath = getClasspath();
		webroot = classpath.substring(0, classpath.indexOf("/WEB-INF/classes"));
		webroot = webroot.replace("\\/", "\\");
		webroot = webroot.replaceAll("\\\\", "//");
		return webroot.endsWith("/") ? webroot : webroot + "/";
	}

	/**
	 * 
	 * @param xml sourceFile
	 * @param accesstype 访问方式 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getPathFromSourceFile(String xml, String accesstype) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List<Element> fileGroups = root.elements("FileGroup");
			for (Element fileGroup : fileGroups) {
				if ("5".equals(fileGroup.elementText("GroupType"))) {
					Element extendAttributes = fileGroup.element("ExtendAttributes");
					List<Element> extendAttributeList = extendAttributes.elements("ExtentionAttribute");
					for (Element extendAttribute : extendAttributeList) {
						Element itemCode = extendAttribute.element("ItemCode");
						String itemCodeValue = itemCode.getText();
						if (itemCodeValue.equals("gatherInfo")) {
							Element value = extendAttribute.element("Value");
							Document childDocument = DocumentHelper.parseText(value.getText());
							Element childRoot = childDocument.getRootElement();
							String storageid = childRoot.elementText("storageid");
							return getPathByStorageId(storageid, accesstype);
						}
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param xml sourceFile
	 * @param newValue 插入值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String editXML(String xml, String newValue) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List<Element> fileGroups = root.elements("FileGroup");
			for (Element fileGroup : fileGroups) {
				Element fileItem = fileGroup.element("FileItem");
				Element fileName = fileItem.element("FileName");
				fileName.setText(newValue + fileName.getText());
			}
			return document.asXML();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param root
	 *            根元素
	 * @param attributeName
	 *            元素名
	 * @return String 元素value
	 */
	@SuppressWarnings("unchecked")
	public static String getAttribute(Element root, String attributeName) {
		List<Element> elements = root.elements();
		// 如果根节点下有子节点
		if (elements.size() > 0) {
			// 遍历子节点
			for (Element element : elements) {
				if (attributeName.equals(element.getName())) {
					attribute = new StringBuffer();
					attribute.append(element.getText()).toString();
				} else if (!attributeName.equals(element.getName())) {
					if (element.getName().equals("Value")) {
						Document childDocument = null;
						try {
							childDocument = DocumentHelper.parseText(element.getStringValue());
							Element childRoot = childDocument.getRootElement();
							getAttribute(childRoot, attributeName);
						} catch (DocumentException e) {
							e.printStackTrace();
						}
					}
					if (element.elements().size() > 0) {
						getAttribute(element, attributeName);
					}
				}
			}
		}
		return attribute.toString();
	}

	/**
	 * 
	 * @param root 根元素
	 * @param attributeName 元素名
	 * @return List 元素值
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getAttributes(Element root, String attributeName) {
		List<Element> elements = root.elements();
		// 如果根节点下有子节点
		if (elements.size() > 0) {
			// 遍历子节点
			for (Element element : elements) {
				if (attributeName.equals(element.getName())) {
					System.out.println(element.getStringValue());
					list.add(element.getStringValue());
				} else if (!attributeName.equals(element.getName())) {
					if (element.getName().equals("Value")) {
						Document childDocument = null;
						try {
							childDocument = DocumentHelper.parseText(element.getStringValue());
							Element childRoot = childDocument.getRootElement();
							getAttributes(childRoot, attributeName);
						} catch (DocumentException e) {
							e.printStackTrace();
						}
					}
					if (element.elements().size() > 0) {
						getAttributes(element, attributeName);
					}
				}
			}
		}
		return list;
	}

	/**
	 * 
	 * @param root 根节点
	 * @param attributeName 节点名
	 * @return String groupType为5的FileGroup下的节点值 
	 */
	@SuppressWarnings("unchecked")
	public static String getAttributeFromType5(Element root, String attributeName) {
		List<Element> fileGroups = root.elements();
		// 如果根节点下有子节点
		for (Element fileGroup : fileGroups) {
			if ("5".equals(fileGroup.elementText("GroupType"))) {
				if (attributeName.equals(fileGroup.getName())) {
					attribute = new StringBuffer();
					attribute.append(fileGroup.getText()).toString();
				} else if (!attributeName.equals(fileGroup.getName())) {
					getAttribute(fileGroup, attributeName);
				}
			}
		}
		return attribute.toString();
	}

	/**
	 * 
	 * @param storagetype
	 *            存储类型
	 * @param accesstype
	 *            访问方式
	 * @return
	 */
	public static String getPathByType(String storagetype, String accesstype) {
		//		PathUtilsService pathUtilsService = ContextHolder
		//				.getService(PathUtilsService.class);
		//		return pathUtilsService.getAccessAddressByType(storagetype, accesstype);

		return null;
	}

	/**
	 * 
	 * @param storageid
	 *            存储id
	 * @param accesstype
	 *            访问方式
	 * @return
	 */
	public static String getPathByStorageId(String storageid, String accesstype) {
		//		PathUtilsService pathUtilsService = ContextHolder
		//				.getService(PathUtilsService.class);
		//		return pathUtilsService.getAccessAddressById(storageid, accesstype);

		return null;
	}
	//	public  String getAccessPathByStorageId(String storageid, String accesstype){
	//		ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext();
	//		AccessService accessService=(AccessService)ctx.getBean("accessService");
	//		StorageAccess storageAccess = accessService.getStorageAccess(storageid, accesstype);
	//		 return storageAccess.getAccessaddress();
	//	}
}
