package com.uflowertv.model.dto;

import lombok.Data;

@Data
public class AccessToken {
	private String token;
	private String expiresIn;
}
