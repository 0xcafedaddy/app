package com.uflowertv.controller;

import com.baomidou.framework.controller.SuperController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;
import com.uflowertv.model.SessionInfo;
import com.uflowertv.model.ValidationData;
import com.uflowertv.model.po.User;
import com.uflowertv.service.UserService;
import com.uflowertv.util.CipherUtil;
import com.uflowertv.util.ConfigUtil;
import com.uflowertv.util.GUIDUtil;
import com.uflowertv.util.Mail;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：
 * 类名称：com.uflowertv.user.controller.UserController     
 * 创建人：liguoliang 
 * 创建时间：2016年8月16日 下午2:11:22   
 * 修改人：
 * 修改时间：2016年8月16日 下午2:11:22   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

    /**
     * 登录
     * @param user
     * @param session
     * @param request
     * @return
     */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String,Object> login(User user,HttpSession session,HttpServletRequest request){
		Map<String,Object> map = Maps.newHashMap();
		ValidationData data = new ValidationData();
		String email = user.getEmail();
		String pwd = user.getPwd();
        user.setPwd(CipherUtil.generator(pwd));
        user = userService.selectOne(new EntityWrapper<User>().where("email={0}",email).eq("pwd",user.getPwd()));
        if(user!=null){
            user.setIp(request.getRemoteAddr());//记录IP地址
            user.setId(user.getId());
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.setUser(user);
            session.setAttribute(ConfigUtil.getSessionInfoName(), sessionInfo);
            user.setLogintime(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
            userService.updateById(user);
            map.put("code", 200);
            map.put("message", "登录成功");
            return map;
        }
        user =  user = userService.findByEmail(email);
        if(user != null){
            boolean equals = StringUtils.equals(user.getPwd(), pwd);
            if(!equals){
                data.setPwdMsg("密码错误");
                map.put("data", data);
                return map;
            }
        }
		data.setEmialMsg("该邮箱还没有被注册");
		map.put("data", data);
		return map;
	}


    /**
     * 注销
     * @param session
     * @return
     */
	@RequestMapping("/logout")
	@ResponseBody
	public Map<String,Object> logout(HttpSession session){
		session.invalidate();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", true);
		return map;
	}

    /**
     * 注册
     * @param user
     * @param passwd
     * @return
     */
	@RequestMapping("/reg")
	@ResponseBody
	public Map<String,Object> reg(User user,String passwd){
		return userService.register(user,passwd);
	}

	/**
	 * 更新密码
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param uId
	 * @param uPwd
	 * @return
	 */
	@RequestMapping("/aftUpdatePwd")
	@ResponseBody
	public Map<String,Object> update(String uId, String uPwd) {
		Map<String,Object> map = new HashMap<String,Object>();
		User u = userService.selectById(uId);
		if(u != null){
			if(CipherUtil.validate(u.getPwd(), uPwd)){
				map.put("message", "不能与近期密码相同");
				return map;
			}
			u.setPwd(CipherUtil.generator(uPwd));
            boolean flag = userService.updateById(u);
            if(flag){
				map.put("code", 200);
				map.put("message", "密码修改成功，请重新登录！");
				return map;
			}
		}
		map.put("code", 200);
		map.put("message", "用户不存在");
		return map;
	}
	
	/**
	 * 发送邮件链接
	 * @Title: forget_password
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param email
	 * @return
	 */
	@RequestMapping("/forget_password")
	@ResponseBody
	public Map<String,Object> befPwd(HttpServletRequest request,String email){
        Map<String,Object> map = Maps.newHashMap();
        User user = userService.findByEmail(email);
        ValidationData data = new ValidationData();
        if(user == null){
            data.setEmialMsg("该邮箱不存在");
            map.put("data", data);
            return map;
        }
        String secretKey= GUIDUtil.get();  //密钥
        Date outDate = new Date(System.currentTimeMillis()+30*60*1000);//30分钟后过期
        long date = outDate.getTime()/1000*1000; //忽略毫秒数
        user.setValidatecode(secretKey);
        user.setOutdate(outDate);
        //保存到数据库
        boolean flag = userService.updateById(user);
        if(flag){
            String key = email+"$"+date+"$"+secretKey;
            String path = request.getContextPath();
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            String resetPassHref =  basePath+"user/reset_password?sid="+ CipherUtil.generator(key)+"&email="+email;
            String emailContent = "请勿回复本邮件。点击下面的链接，重设密码。tips:本邮件超过30分钟链接将会失效，需要重新申请。<br/>"
                    + "<a href="+resetPassHref +" target='_blank'>点击我重新设置密码</a>";

            Mail.setTo(user.getEmail());
            Mail.setContent(emailContent);
            boolean flag2 =	Mail.sendMail();
            if(flag2){
                map.put("code", 200);
                map.put("message", "邮件已发送");
                return map;
            }
        }
        map.put("code", 200);
        map.put("message", "邮件发送失败");
        return map;
	}

    /**
     * 验证邮件链接
     * @param sid
     * @param email
     * @return
     */
	@RequestMapping("/reset_password")
    public ModelAndView checkResetLink(String sid,String email){
		ModelAndView model = new ModelAndView("mailException");
        String msg = "";
        if(StringUtils.isBlank(sid) || StringUtils.isBlank(email)){
	        msg="链接不完整,请重新生成";
	        model.addObject("message",msg) ;
	        return model;
        }
    	User user = userService.findByEmail(email);
        if(user == null){
        	msg = "链接错误,无法找到匹配用户,请重新申请找回密码";
        	model.addObject("message",msg) ;
        	return model;
        }
        //表示已经过期
    	Date outDate = user.getOutdate();
        if(outDate.getTime() <= System.currentTimeMillis()){  
        	msg = "链接已经过期,请重新申请找回密码";
        	model.addObject("message",msg) ;
        	return model;
        }
    	//数字签名
    	String key = user.getEmail()+"$"+outDate.getTime()/1000*1000+"$"+user.getValidatecode();    
    	boolean validate = CipherUtil.validate(sid, key);
        if(!validate) {
        	msg = "链接不正确,请重新申请";
        	model.addObject("message",msg) ;
        	return model;
        }
        //返回到修改密码的界面
        model.setViewName("pwd_update");
        return model;
    }
	
	/**
	 * 修改密码
	 * @Title: updatePwd
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param passwd
	 * @param email
	 * @return
	 */
	@RequestMapping("/befUpdatePwd")
	@ResponseBody
	public Map<String,Object> updatePwd(String passwd,String email){
		Map<String,Object> map = new HashMap<String,Object>();
		User user = userService.findByEmail(email);
		ValidationData data = new ValidationData();
		if(user!=null && StringUtils.isNotBlank(passwd)){
			if(CipherUtil.validate(user.getPwd(), passwd)){
				data.setPwdMsg("不能与近期密码相同");
				map.put("data", data);
				return map;
			}
			user.setPwd(CipherUtil.generator(passwd));
            boolean flag = userService.updateById(user);
            if(flag){
				map.put("code", 200);
				map.put("message", "密码更新成功");
				return map;
			}
		}
		map.put("code", 200);
		map.put("message", "用户不存在");
		return map;
	}
}