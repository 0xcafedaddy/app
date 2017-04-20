package com.uflowertv.model;

import lombok.Data;

@Data
public class TreeAttributes {
	private String url;
	
	public TreeAttributes() {}
	public TreeAttributes(String url){
		this.url = url;
	}

}
