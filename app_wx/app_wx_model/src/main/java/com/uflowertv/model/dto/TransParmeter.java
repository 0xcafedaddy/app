package com.uflowertv.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransParmeter extends ResponseError{
	//请求翻译query	UTF-8编码
	private String q;
	
	//翻译源语言语言列表(可设置为auto)
	private String from;
	
	//语言列表(不可设置为auto)
	private String to;

	//可在管理控制台查看
	private String appid;
	
	//随机数	
	private String salt;
	
	//签名	appid+q+salt+密钥 的MD5值
	private String sign;
	
	private String monLang;
	private String query;
	@JsonDeserialize(using=StringDeserializer.class)
	private String trans_result;
	
	public TransParmeter() {
		
	}

	public TransParmeter(String q, String from, String to, String appid,
			String salt, String sign) {
		super();
		this.q = q;
		this.from = from;
		this.to = to;
		this.appid = appid;
		this.salt = salt;
		this.sign = sign;
	}
}
