package com.uflowertv.model.dto;

import lombok.Data;

@Data
public class StartJson {

	private String platformID;//平台ID
	private String time;//时间段
	private Integer count;//访问量
	
	public StartJson() {}
}
