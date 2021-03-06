package com.uflowertv.bean.dto;

import com.uflowertv.wechat.model.User;
import lombok.Data;

/**
 * sessionInfo模型，只要登录成功，就需要设置到session里面，便于系统使用
 * 
 */
@Data
public class SessionInfo{

	private User user;

	public SessionInfo() {}
}
