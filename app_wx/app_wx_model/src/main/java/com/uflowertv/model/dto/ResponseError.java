package com.uflowertv.model.dto;

import lombok.Data;

@Data
public class ResponseError {
	//微信错误码
	private int errcode;
	//微信错误信息
	private String errmsg;
	//百度翻译错误码
	private int error_code;
	//百度翻译错误信息
	private String error_msg;

}
