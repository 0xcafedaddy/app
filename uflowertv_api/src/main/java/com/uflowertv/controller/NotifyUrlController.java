package com.uflowertv.controller;

import com.uflowertv.service.XxjOrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * 版权所有：2017年3月7日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：支付回调接口
 * 类名称：com.uflowertv.controller.NotifyUrlController     
 * 创建人：liguoliang 
 * 创建时间：2017年3月7日 下午4:39:29   
 * 修改人：
 * 修改时间：2017年3月7日 下午4:39:29   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("payment")
public class NotifyUrlController {

	@Autowired
	private XxjOrderServiceI xxjOrderService;
	
	
	/**
	 * 支付回调接口
	 * @Title: notify
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param orderId
	 * @param paySeq
	 * @param payState
	 * @param payDesc
	 * @param payType
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/charge",method=RequestMethod.GET)
	public void notify(String orderId,String paySeq,String payState,String payDesc,String payType,HttpServletResponse response) throws IOException{
		orderId = orderId.substring(6);
		xxjOrderService.updateOrderInfo(orderId, paySeq, payState, payDesc, payType);
        response.getWriter().write("success");  
        return;
	}
}
