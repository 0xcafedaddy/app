package com.uflowertv.wechat.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;
import com.uflowertv.bean.dto.SessionInfo;
import com.uflowertv.wechat.controller.support.BaseController;
import com.uflowertv.wechat.controller.support.JsonResult;
import com.uflowertv.wechat.model.User;
import com.uflowertv.wechat.service.UserService;
import com.util.GUIDUtil;
import com.util.Mail;
import com.util.properties.ConstantConfig;
import com.util.security.CipherUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
     *
     * @param user
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JsonResult login(User user, HttpSession session, HttpServletRequest request) {
        String email = user.getEmail();
        String pwd = user.getPwd();
        user.setPwd(CipherUtil.generator(pwd));
        user = userService.selectOne(new EntityWrapper<User>().where("email={0}", email).eq("pwd", user.getPwd()));
        if (user != null) {
            user.setIp(request.getRemoteAddr());//记录IP地址
            user.setId(user.getId());
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.setUser(user);
            session.setAttribute(ConstantConfig.getProperty("sessionInfoName"), sessionInfo);
            user.setLogintime(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
            userService.updateById(user);
            return renderSuccess("登录成功");
        }
        user = user = userService.findByEmail(email);
        if (user != null) {
            boolean equals = StringUtils.equals(user.getPwd(), pwd);
            if (!equals) {
                return renderError("密码错误");
            }
        }
        return renderError("该邮箱还没有被注册");
    }


    /**
     * 注销
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JsonResult logout(HttpSession session) {
        session.invalidate();
        return renderSuccess();
    }

    /**
     * 注册
     *
     * @param user
     * @param passwd
     * @return
     */
    @RequestMapping(value = "/reg",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JsonResult reg(User user, String passwd) {
        User u = userService.findByEmail(user.getEmail());
        if (u != null) {
            return renderError("该邮箱已被注册");
        }
        //将密码加密保存
        user.setId(GUIDUtil.get());
        user.setPwd(CipherUtil.generator(passwd));
        user.setCreated(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        user.setLogintime(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        boolean insert = userService.insert(user);
        return renderSuccess("注册成功");
    }

	/**
	 * 更新密码
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param uId
	 * @param uPwd
	 * @return
	 */
	@RequestMapping(value = "/aftUpdatePwd",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public JsonResult update(String uId, String uPwd) {
        User u = userService.selectById(uId);
		if(u != null){
			if(CipherUtil.validate(u.getPwd(), uPwd)){
			    return renderError("不能与近期密码相同");
			}
			u.setPwd(CipherUtil.generator(uPwd));
            boolean flag = userService.updateById(u);
            return flag?renderSuccess("密码修改成功，请重新登录！"):renderError("密码修改失败，请联系客服！");
		}
		return renderSuccess("用户不存在");
	}
	
	/**
	 * 发送邮件链接
	 * @Title: forget_password
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/forget_password",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public JsonResult befPwd(HttpServletRequest request,String email){
        Map<String,Object> map = Maps.newHashMap();
        User user = userService.findByEmail(email);
        if(user == null){
            return renderError("该邮箱不存在");
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
            return Mail.sendMail()?renderSuccess("邮件已发送"):renderError("邮件发送失败");
        }
        return renderError("系统错误，请联系客服！");
	}

    /**
     * 验证邮件链接
     * @param sid
     * @param email
     * @return
     */
	@RequestMapping(value = "/reset_password")
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
	@RequestMapping(value = "/befUpdatePwd",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public JsonResult updatePwd(String passwd,String email){
		User user = userService.findByEmail(email);
		if(user!=null){
		    if (StringUtils.isNotBlank(passwd)){
                if(CipherUtil.validate(user.getPwd(), passwd)){
                    return renderError("不能与近期密码相同");
                }
                user.setPwd(CipherUtil.generator(passwd));
                boolean flag = userService.updateById(user);
                if(flag){
                    return renderSuccess("密码更新成功");
                }
            }
		}
		return renderError("用户不存在");
	}
}