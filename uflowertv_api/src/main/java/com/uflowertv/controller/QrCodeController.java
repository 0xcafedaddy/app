package com.uflowertv.controller;

import com.google.common.collect.Maps;
import com.uflowertv.service.XxjOrderServiceI;
import com.uflowertv.util.QRCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.Status;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * 
 * 版权所有：2017年3月27日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：生成送书二维码
 * 类名称：com.uflowertv.controller.QrCodeController     
 * 创建人：liguoliang 
 * 创建时间：2017年3月27日 下午6:06:59   
 * 修改人：
 * 修改时间：2017年3月27日 下午6:06:59   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
public class QrCodeController {

	@Autowired
	private XxjOrderServiceI xxjOrderService;
	
	/**
	 * 生成二维码
	 * @Title: qrcode
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "QrCode",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> qrcode(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = Maps.newHashMap();
		OutputStream output = null;
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String imgPath = realPath+"images/logo.png";
			String platformId = request.getParameter("platformId"); 
			String orderId = request.getParameter("orderId");
			String content = xxjOrderService.getQrcodeUrl(Integer.valueOf(platformId), Integer.valueOf(orderId));
			if(StringUtils.isBlank(content)){
				map.put("code", Status.INTERNAL_SERVER_ERROR.getStatusCode());
				map.put("msg", "参数错误");
				return map;
			}
			output = response.getOutputStream();
			QRCodeUtil.encode(content, imgPath, output, true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", Status.INTERNAL_SERVER_ERROR.getStatusCode());
			map.put("msg", "系统内部错误");
			return map;
		}finally {
			try {
				if(output!=null){
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
