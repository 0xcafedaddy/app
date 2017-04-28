package com.util.skye;

import java.util.HashMap;
import java.util.Map;
public class OutJson {
	/**
	 * 访问正常
	 */
	public static final int SUCCESS_CODE = 200;
	/**
	 * 禁止访问
	 */
	public static final int FORBIDDEN_CODE = 403;
	/**
	 * 服务器异常
	 */
	public static final int ERROR_CODE = 500;

	public static synchronized Map jsonObj(int code ,Object data){
		Map result = new HashMap();
		result.put("code", code);
		result.put("data", data);
		return result;
	}
}
