package com.uflowertv.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
@Data
public class OauthAccessToken {

	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	private String lang;

	public String getLang() {
		if(StringUtils.isBlank(lang))return "zh_CN";
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public OauthAccessToken() {}
}
