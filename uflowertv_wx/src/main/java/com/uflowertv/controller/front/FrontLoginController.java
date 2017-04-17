package com.uflowertv.controller.front;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uflowertv.model.PhoneCode;
import com.uflowertv.service.PhoneCodeService;
import com.uflowertv.util.ConstantHolder;
import com.uflowertv.util.JsonUtils;
import com.uflowertv.util.MessageUtil;
/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：wxpublic   
 *
 * 类描述：
 * 类名称：com.uflowertv.controller.front.FrontLoginController     
 * 创建人：liguoliang 
 * 创建时间：2016年9月18日 下午12:34:41   
 * 修改人：
 * 修改时间：2016年9月18日 下午12:34:41   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("/mobile")
public class FrontLoginController {

	@Autowired
	private PhoneCodeService phoneCodeService;
	/**
	 * 验证
	 * @Title: modify_customer_info_phone
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param mobilePhone
	 * @param authCode
	 * @return
	 */
	@RequestMapping("/modify_customer_info_phone.shtml")
	@ResponseBody
	public Map<String,Object> modify_customer_info_phone(String mobilePhone, String authCode){
		Map<String,Object> map = new HashMap<String,Object>();
		PhoneCode phoneCode = phoneCodeService.getPhoneCode(mobilePhone);
		if(authCode.equals(phoneCode.getCode())){
			map.put("resultCode", 0);
			return map;
		}else{
			map.put("errorCode", "注册失败");
			return map;
		}
	}
	
	/**
	 * 注册
	 * @Title: check_code
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param session
	 * @param mobilePhone
	 * @param catpcha
	 * @param isRegisterValidate
	 * @return
	 */
	@RequestMapping("/check_code.shtml")
	@ResponseBody
	public Map<String,Object> check_code(HttpSession session,String mobilePhone, String catpcha,String isRegisterValidate){
		Map<String,Object> map = new HashMap<String,Object>();
		String code = (String) session.getAttribute("code");
		if(catpcha.toUpperCase().equals(code)){
			 boolean sendMessage = isRegisterValidate.equals(ConstantHolder.SEND_MESSAGE);
			// 发送验证码------生产发，测试环境不发
	        if (sendMessage) {
	        	String validata = MessageUtil.madeVali();
				String paras = MessageUtil.getMsgJson(mobilePhone, validata);
				String result = MessageUtil.transmessage(ConstantHolder.SMSURL, paras);
				int resultCode = (int) JsonUtils.json2Map(result).get("code");
				String resultMsg = (String) JsonUtils.json2Map(result).get("msg");
				if(resultCode == 1000){
					PhoneCode phoneCode = phoneCodeService.getPhoneCode(mobilePhone);
					if(phoneCode == null){//save
						PhoneCode phoneCode2 = new PhoneCode();
						phoneCode2.setPhone(mobilePhone);
						phoneCode2.setCode(validata);
						phoneCode2.setAmount((byte)1);
						phoneCode2.setTime(new Date());
						phoneCodeService.save(phoneCode2);
					}else{//update
						phoneCode.setPhone(mobilePhone);
						phoneCode.setCode(validata);
						phoneCode.setAmount((byte)(phoneCode.getAmount()+1));
						phoneCode.setTime(new Date());
						phoneCodeService.update(phoneCode);
					}
				}else{
					map.put("errorCode", resultMsg);
					return map;
				}
			}
	        map.put("resultCode", 100000);
			return map;
		}else{
			map.put("errorCode", "图片验证码无效");
			return map;
		}
	}
}
