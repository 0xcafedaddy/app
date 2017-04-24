package com.uflowertv.model.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DayActiveCount {

	private Date dateTime;
	private int platformID;
	private int total;
}
