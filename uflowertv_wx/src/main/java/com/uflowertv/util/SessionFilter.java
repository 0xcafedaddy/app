package com.uflowertv.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 版权所有：2017年2月23日-油菜花
 * 项目名称：uflowertv_wx   
 *
 * 类描述：用于过滤需要拦截的JSP文件
 * 类名称：com.uflowertv.util.SessionFilter     
 * 创建人：liguoliang 
 * 创建时间：2017年2月23日 下午5:09:34   
 * 修改人：
 * 修改时间：2017年2月23日 下午5:09:34   
 * 修改备注：   
 * @version   V1.0
 */
public class SessionFilter implements Filter {
	private Logger log = LoggerFactory.getLogger(getClass());

	private List<String> list = new ArrayList<String>();

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String servletPath = request.getServletPath();

		for (String url : list) {
			if (servletPath.indexOf(url) > -1) {// 需要过滤
				log.info("进入session过滤器->访问路径为[" + servletPath + "]");
				if (request.getSession().getAttribute("sessionInfo") == null) {// session不存在需要拦截
					if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
						 Map<String, Object> map = new HashMap<String, Object>();
		        		 map.put("message", "登录已超时，请重新登录！");
		        		 response.getWriter().print(JsonUtils.bean2Json(map));//session失效
		        	}else{
		        		request.setAttribute("message", "您还没有登录或登录已超时，请重新登录！");
		        		request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
		        	}
					return;
				}
				break;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// 初始化需要拦截的文件夹
		String include = filterConfig.getInitParameter("include");
		if (!StringUtils.isBlank(include)) {
			StringTokenizer st = new StringTokenizer(include, ",");
			list.clear();
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
		}
	}
	
	public void destroy() {
		
	}
}
