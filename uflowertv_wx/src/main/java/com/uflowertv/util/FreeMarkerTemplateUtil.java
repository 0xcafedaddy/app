package com.uflowertv.util;

import freemarker.core.ParseException;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * 
 * 版权所有：2017年2月23日-油菜花
 * 项目名称：uflowertv_wx   
 *
 * 类描述：FreeMarkerTemplateUtil
 * 类名称：com.uflowertv.util.FreeMarkerTemplateUtil     
 * 创建人：liguoliang 
 * 创建时间：2017年2月23日 下午5:43:44   
 * 修改人：
 * 修改时间：2017年2月23日 下午5:43:44   
 * 修改备注：   
 * @version   V1.0
 */
public class FreeMarkerTemplateUtil {

	private static Logger log = LoggerFactory.getLogger(FreeMarkerTemplateUtil.class);

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
	 * @param req
	 * @param propMap
	 * @param htmlFileFtl
	 * @return
	 */
	/*public static String geneHtmlFileTest(HttpServletRequest req,Map<String, Object> propMap, String htmlFileFtl) {
		// @todo 从配置中取得要静态文件存放的根路径:需要改为自己的属性类调用
		Writer out = null;
		SFTPChannel channel = new SFTPChannel();
	    ChannelSftp chSftp = null;
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
	 * @param req
	 * @param propMap
	 * @param htmlFileFtl
	 * @return
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
