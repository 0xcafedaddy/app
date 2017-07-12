package com.uflowertv.model.dto;

public class TextMessage extends SendCustom{
	
	private TextMessage text;
	private String content;
	
	public TextMessage() {
	}
	public TextMessage(String content) {
		super();
		this.content = content;
	}

	public TextMessage getText() {
		return text;
	}

	public void setText(TextMessage text) {
		this.text = text;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
