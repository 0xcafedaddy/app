package com.uflowertv.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.uflowertv.commons.BaseService;

public class SessionInterceptor extends BaseService implements HandlerInterceptor{
	
	@Override
	public void postHandle(HttpServletRequest requestuest,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest requestuest,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String servletPath = request.getServletPath();
		// 此处实现登陆的拦截判断
        if(request.getSession().getAttribute("sessionInfo")==null){
        	log.info("进入session拦截器->访问路径为[" + servletPath + "]");
    		request.setAttribute("message", "您还没有登录或登录已超时，请重新登录！");
    		request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
        	return false;
        }else{
            return true;
        }
/*        if(request.getSession().getAttribute("sessionInfo")==null){
        	log.info("进入session拦截器->访问路径为[" + servletPath + "]");
        	//如果是ajax请求响应头会有x-requested-with 
        	if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
        		Map<String, Object> map = new HashMap<String, Object>();
        		map.put("message", "登录已超时，请重新登录！");
        		response.getWriter().print(JsonUtils.bean2Json(map));//session失效
        		String path = request.getContextPath();
        		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        		System.out.println(basePath);
        		response.sendRedirect(basePath+"error/noSession.jsp");
        		//request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
        	}else{
        		//response.sendRedirect(servletPath + "/login.jsp");
        		request.setAttribute("message", "您还没有登录或登录已超时，请重新登录！");
        		request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
        	}
        	return false;
        }else{
        	return true;
        }
*/	}
}
