package com.uflowertv.exception;

import com.util.exception.BusinessException;
import com.util.exception.ParameterException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);
		
		// 根据不同错误转向不同页面
		if(ex instanceof BusinessException) {
			return new ModelAndView("exception/error-business", model);
		}else if(ex instanceof ParameterException) {
			return new ModelAndView("exception/error-parameter", model);
		} else {
			return new ModelAndView("exception/error", model);
		}
	}
}
