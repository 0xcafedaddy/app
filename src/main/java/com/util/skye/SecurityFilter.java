package com.util.skye;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
		// 

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession session = req.getSession();
	    
	    if (session.getAttribute("AdminUser") != null) {//登录后才能访问 
	        chain.doFilter(request, response);
	    } else {
	    	//String path = req.getContextPath();
	    	//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    	response.setCharacterEncoding("utf-8");
	    	response.getWriter().print("登录失效！");
	        //res.sendRedirect(basePath+"page/error/logintimeout.jsp");
	    } 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// 

	}

}
