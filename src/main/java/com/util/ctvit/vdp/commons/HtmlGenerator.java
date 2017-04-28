package com.util.ctvit.vdp.commons;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

public class HtmlGenerator {
	private static final Logger logger = LoggerFactory.getLogger(HtmlGenerator.class);
	private static Configuration cfg;

	public HtmlGenerator(ServletContext sc, String dir) {
		if (cfg == null) {
			// Initialize the FreeMarker configuration;
			// - Create a configuration instance
			cfg = new Configuration(Configuration.VERSION_2_3_23);
			// - Templates are stoted in the WEB-INF/templates directory of the Web app.
			cfg.setServletContextForTemplateLoading(sc, dir);
			// - Set update dealy to 0 for now, to ease debugging and testing.
			//   Higher value should be used in production environment.
			cfg.setTemplateUpdateDelayMilliseconds(0);
			// - Set an error handler that prints errors so they are readable with
			//   a HTML browser.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
			// - Use beans wrapper (recommmended for most applications)
			BeansWrapperBuilder beansWrapperBuilder = new BeansWrapperBuilder(Configuration.VERSION_2_3_23);
			ObjectWrapper outerIdentity = beansWrapperBuilder.build().getOuterIdentity();
			cfg.setObjectWrapper(outerIdentity);
			// - Set the default charset of the template files
			cfg.setDefaultEncoding("UTF-8");
			// - Set the charset of the output. This is actually just a hint, that
			//   templates may require for URL encoding and for generating META element
			//   that uses http-equiv="Content-type".
			cfg.setOutputEncoding("UTF-8");
			// - Set the default locale
			cfg.setLocale(Locale.CHINA);
		}
	}

	// 创建页面
	public void generateHtmlPage(Map root, String templateName, String pagePath) throws Exception {
		// 加载模板
		Template navTemplate = cfg.getTemplate(templateName);
		File file = new File(pagePath);
		file.deleteOnExit();
		FileOutputStream out = new FileOutputStream(pagePath);
		Writer writer = new OutputStreamWriter(out, "utf-8");
		/* 将模板和数据模型合并 */
		navTemplate.process(root, writer);
		logger.info("页面" + pagePath + "生成成功");
		out.flush();
	}

}
