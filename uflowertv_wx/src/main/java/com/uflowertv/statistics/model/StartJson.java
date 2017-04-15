package com.uflowertv.statistics.model;

public class StartJson {

	private String platformID;//平台ID
	private String time;//时间段
	private Integer count;//访问量
	
	public StartJson() {
		// TODO Auto-generated constructor stub
	}

	public String getPlatformID() {
		return platformID;
	}

	public void setPlatformID(String platformID) {
		this.platformID = platformID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
