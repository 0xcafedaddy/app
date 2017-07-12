package com.util.context;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
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
		// TODO Auto-generated method stub

	}

}
