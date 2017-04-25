package com.uflowertv.controller.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uflowertv.exception.BusinessException;
import com.uflowertv.exception.ParameterException;
import com.uflowertv.service.TestService;


/**
 * 
 * 版权所有：2017年3月7日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：测试SpringMVC异常视图
 * 类名称：com.uflowertv.controller.exception.TestController     
 * 创建人：liguoliang 
 * 创建时间：2017年3月7日 下午4:46:20   
 * 修改人：
 * 修改时间：2017年3月7日 下午4:46:20   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
public class TestController extends BaseController {
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/controller", method = RequestMethod.GET)
	public void controller(HttpServletResponse response, Integer id) throws Exception {
		switch(id) {
		case 1:
			throw new BusinessException("10", "controller10");
		case 2:
			throw new BusinessException("20", "controller20");
		case 3:
			throw new BusinessException("30", "controller30");
		case 4:
			throw new BusinessException("40", "controller40");
		case 5:
			throw new BusinessException("50", "controller50");
		default:
			throw new ParameterException("Controller Parameter Error");
		}
	}
	
	/**
	 * 业务层测试
	 * @Title: service
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param response
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public void service(HttpServletResponse response, Integer id) throws Exception {
		testService.exception(id);
	}
	
	/**
	 * 数据层测试
	 * @Title: dao
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param response
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value = "/dao", method = RequestMethod.GET)
	public void dao(HttpServletResponse response, Integer id) throws Exception {
		testService.dao(id);
	}
}