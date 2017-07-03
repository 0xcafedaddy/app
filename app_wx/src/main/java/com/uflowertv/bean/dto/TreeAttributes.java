package com.uflowertv.bean.dto;

import lombok.Data;

@Data
public class TreeAttributes {
	private String url;
	
	public TreeAttributes() {}
	public TreeAttributes(String url){
		this.url = url;
	}

}
