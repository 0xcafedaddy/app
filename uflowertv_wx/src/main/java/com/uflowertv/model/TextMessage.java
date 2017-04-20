package com.uflowertv.model;

import lombok.Data;

@Data
public class TextMessage extends SendCustom{
	
	private TextMessage text;
	private String content;
	
	public TextMessage() {
		// TODO Auto-generated constructor stub
	}
	public TextMessage(String content) {
		super();
		this.content = content;
	}
}
