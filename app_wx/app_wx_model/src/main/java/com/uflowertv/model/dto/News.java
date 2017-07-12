package com.uflowertv.model.dto;

import lombok.Data;

@Data
public class News {
	private String title;
	private String description;
	private String url;
	private String picurl;
	
	public News() {
	}

	public News(String title, String description, String url, String picurl) {
		super();
		this.title = title;
		this.description = description;
		this.url = url;
		this.picurl = picurl;
	}
}
