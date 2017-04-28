package com.util.skye;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;

public class FreeMarkertUtil {

	/**
	 * 
	 * @param templatePath 模板文件存放路径
	 * @param templateName 模板文件名称
	 * @param fileName 生成的文件名称
	 * @param root 参数
	 */
	public static boolean analysisTemplate(String templatePath,
			String templateName, String fileName, Map<?, ?> root) {
		try {
			Configuration config = new Configuration(Configuration.VERSION_2_3_23);
			// 设置要解析的模板所在的目录，并加载模板文件
			config.setDirectoryForTemplateLoading(new File(templatePath));
			// 设置包装器，并将对象包装为数据模型
			BeansWrapperBuilder beansWrapperBuilder = new BeansWrapperBuilder(Configuration.VERSION_2_3_23);
			ObjectWrapper outerIdentity = beansWrapperBuilder.build().getOuterIdentity();
			config.setObjectWrapper(outerIdentity);

			// 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
			// 否则会出现乱码
			Template template = config.getTemplate(templateName, "UTF-8");
			// 合并数据模型与模板
			FileOutputStream fos = new FileOutputStream(fileName);
			Writer out = new OutputStreamWriter(fos, "UTF-8");
			template.process(root, out);
			out.flush();
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (TemplateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		String templatePath = "F:/project/111/fundWeb/ftl/";
		String templateName = "user.ftl";
		String fileName = "F:/project/111/fundWeb/ftl/aaa.html";
		Map root = new HashMap();
		//普通属性
		root.put("userPassword", "aaaaaaaaaaa");
		//集合
		List list = new ArrayList();
		for(int i=0;i<10;i++){
			Object[] o = new Object[2];
			o[0]=i+"";
			o[1]="第"+i+"个";
			list.add(o);
		}
		root.put("l", list);
		//map
		Map map = new HashMap();
		map.put("one", "11111111111111");
		Object[] mapfoo = new Object[2];
		mapfoo[0]="xxxxxx";
		mapfoo[1]="gggggg";
		map.put("two", mapfoo);
		root.put("m", map);
		
		root.put("test", 1);
		FreeMarkertUtil.analysisTemplate(templatePath, templateName, fileName, root);
	}
}
