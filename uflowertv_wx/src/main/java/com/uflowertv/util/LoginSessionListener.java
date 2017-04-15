package com.uflowertv.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.uflowertv.commons.BaseService;
import com.uflowertv.model.SessionInfo;
public class LoginSessionListener extends BaseService implements HttpSessionAttributeListener {

	Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		// 登录
		if (name.equals("sessionInfo")) {
			SessionInfo info = (SessionInfo) event.getValue();
			if (map.get(info.getUser().getEmail()) != null) {
				// map 中有记录，表明该帐号在其他机器上登录过，将以前的登录失效
				HttpSession session = map.get(info.getUser().getEmail());
				SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
				log.info("帐号" + sessionInfo.getUser().getEmail() + "在"+ sessionInfo.getUser().getIp() + "已经登录，该登录将被迫下线。");
				session.removeAttribute("sessionInfo");
			}
			// 将session以用户名为索引，放入map中
			map.put(info.getUser().getEmail(), event.getSession());
			log.info("帐号" + info.getUser().getEmail() + "在" + info.getUser().getIp()+ "登录。");
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();
		// 注销
		if (name.equals("sessionInfo")) {
			// 将该session从map中移除
			SessionInfo info = (SessionInfo) event.getValue();
			map.remove(info.getUser().getEmail());
			log.info("帐号" + info.getUser().getEmail() + "注销。");
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name = event.getName();
		// 没有注销的情况下，用另一个帐号登录
		if (name.equals("sessionInfo")) {
			// 移除旧的的登录信息
			SessionInfo info = (SessionInfo) event.getValue();
			map.remove(info.getUser().getEmail());
			// 新的登录信息
			SessionInfo personInfo = (SessionInfo) event.getSession().getAttribute("sessionInfo");
			// 也要检查新登录的帐号是否在别的机器上登录过
			if (map.get(personInfo.getUser().getEmail()) != null) {
				// map 中有记录，表明该帐号在其他机器上登录过，将以前的登录失效
				HttpSession session = map.get(personInfo.getUser().getEmail());
				session.removeAttribute("sessionInfo");
			}
			map.put("sessionInfo", event.getSession());
		}
	}
}
