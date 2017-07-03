package com.util.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ResponseBody {
	
	private String code;
		
	private String message;
	
	@JsonDeserialize(using = StringDeserializer.class)
	private String data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
