package com.uflowertv.model;

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
