package com.util.skye;

public class TreeAttributes {
	public TreeAttributes(String url){
		this.url = url;
	}
	private String url = "";
	private String point;
	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
