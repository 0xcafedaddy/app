package com.uflowertv.statistics.model;

import java.util.Date;

public class DayActiveCount {

	private Date dateTime;
	private int platformID;
	private int total;
	
	public int getPlatformID() {
		return platformID;
	}
	public void setPlatformID(int platformID) {
		this.platformID = platformID;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
