package com.uflowertv.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.uflowertv.exception.BusinessException;
import com.uflowertv.exception.ParameterException;
/**
 * 
 * 版权所有：2017年3月7日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：SpringMVC异常处理视图基类
 * 类名称：com.uflowertv.controller.exception.BaseController     
 * 创建人：liguoliang 
 * 创建时间：2017年3月7日 下午4:44:51   
 * 修改人：
 * 修改时间：2017年3月7日 下午4:44:51   
 * 修改备注：   
 * @version   V1.0
 */
public class BaseController {
	
	/** 基于@ExceptionHandler异常处理 */
	//(value = { BusinessException.class, ParameterException.class, Exception.class})
	@ExceptionHandler
	public String exp(HttpServletRequest request, Exception ex) {
		
		request.setAttribute("ex", ex);
		
		// 根据不同错误转向不同页面
		if(ex instanceof BusinessException) {
			return "exception/error-business";
		}else if(ex instanceof ParameterException) {
			return "exception/error-parameter";
		} else {
			return "exception/error";
		}
	}
}