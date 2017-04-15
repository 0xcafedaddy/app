package com.uflowertv.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.uflowertv.commons.BaseService;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

public class FreeMarkerTemplateUtil extends BaseService{

	
	private static Configuration freemarker_cfg = null;
	
	/**
	 * 获取freemarker的配置. freemarker本身支持classpath,目录和从ServletContext获取.
	 */
	protected static Configuration getFreeMarkerCFG(HttpServletRequest req) {
		if (null == freemarker_cfg) {
			File templateFile = new File(req.getSession().getServletContext().getRealPath("/WEB-INF/ftl/"));
			Version version = new Version("2.3.23", true, new Date());
			freemarker_cfg = new Configuration(version);
			try {
				freemarker_cfg.setDirectoryForTemplateLoading(templateFile);
				freemarker_cfg.setObjectWrapper( new DefaultObjectWrapper( version ) );
				freemarker_cfg.setEncoding(Locale.CHINA, "UTF-8");
			} catch (IOException e) {
				log.error("Get tempalte error", e);
			}
		}
		return freemarker_cfg;
	}

	/**
	 * 生成静态文件.(测试环境下使用)
	 * 
	 * @param templateFileName
	 *            模板文件名,相对htmlskin路径,例如"/tpxw/view.ftl"
	 * @param propMap
	 *            用于处理模板的属性Object映射
	 * @param htmlFilePath
	 *            要生成的静态文件的路径,相对设置中的根路径,例如 "/tpxw/1/2005/4/"
	 * @param htmlFileName
	 *            要生成的文件名,例如 "1.htm"
	 */
/*	public static String geneHtmlFile(HttpServletRequest req,Map<String, Object> propMap, String htmlFileFtl) {
		// @todo 从配置中取得要静态文件存放的根路径:需要改为自己的属性类调用
		Writer out = null;
		SFTPChannel channel = new SFTPChannel();
	    ChannelSftp chSftp = null;
		try {
		    String temp = String.valueOf(new Date().getTime());
		    String htmlFileName = temp+".html";
			String sRootDir = ConstantHolder.SERVER_ROOT + ConstantHolder.HTML_FLODER + htmlFileName;
			Template t = getFreeMarkerCFG(req).getTemplate(htmlFileFtl);
			File afile = new File(sRootDir);
		    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(afile), "UTF-8"));
			t.process(propMap, out);
			out.flush();
			//写入到远程服务器
	        chSftp = channel.getChannel(60000);
	        chSftp.put(new FileInputStream(afile),sRootDir,ChannelSftp.OVERWRITE); // 代码段
	        return htmlFileName;
		} catch (TemplateException e) {
			log.error("Error while processing FreeMarker template "+ htmlFileFtl, e);
			return null;
		} catch (SftpException e) {
			e.printStackTrace();
			return null;
		} catch (JSchException e) {
			e.printStackTrace();
			return null;
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				out.close();
				chSftp.quit();
				channel.closeChannel();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/
	/**
	 * 生成静态文件.（正式环境下使用）
	 * 
	 * @param templateFileName
	 *            模板文件名,相对htmlskin路径,例如"/tpxw/view.ftl"
	 * @param propMap
	 *            用于处理模板的属性Object映射
	 * @param htmlFilePath
	 *            要生成的静态文件的路径,相对设置中的根路径,例如 "/tpxw/1/2005/4/"
	 * @param htmlFileName
	 *            要生成的文件名,例如 "1.htm"
	 */
	public static String geneHtmlFile(HttpServletRequest req,Map<String, Object> propMap, String htmlFileFtl) {
		Writer out = null;
		try {
			String temp = String.valueOf(new Date().getTime());
			String htmlFileName = temp+".html";
			//String sRootDir = ConstantHolder.FILE_SERVER + ConstantHolder.HTML_FLODER + htmlFileName;
			String sRootDir = req.getSession().getServletContext().getRealPath("upload")+ ConstantHolder.HTML_FLODER + htmlFileName;
			Template t = getFreeMarkerCFG(req).getTemplate(htmlFileFtl);
			File afile = new File(sRootDir);
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(afile), "UTF-8"));
			t.process(propMap, out);
			out.flush();
			return htmlFileName;
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (TemplateException e) {
			log.error("Error while processing FreeMarker template "+ htmlFileFtl, e);
			return null;
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 创建多级目录
	 * 
	 * @param aParentDir
	 *            String
	 * @param aSubDir
	 *            以 / 开头
	 * @return boolean 是否成功
	 */
	public static boolean creatDirs(String aParentDir, String aSubDir) {
		File aFile = new File(aParentDir);
		if (!aFile.exists()) {
			aFile.mkdirs();
		}
		File aSubFile = new File(aParentDir + aSubDir);
		if (!aSubFile.exists()) {
			return aSubFile.mkdirs();
		} else {
			return true;
		}
	}
}
