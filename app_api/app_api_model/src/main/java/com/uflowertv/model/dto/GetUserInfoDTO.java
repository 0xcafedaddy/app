package com.uflowertv.model.dto;

import com.google.common.base.MoreObjects;
import lombok.Data;

@Data
public class GetUserInfoDTO {

	private String code;
	private String msg;
	private CustInfoDTO custInfo;
    
    public GetUserInfoDTO() {}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("custInfo", custInfo)
				  .add("code",code)
				  .add("msg",msg)
				  .omitNullValues()
				  .toString();
	}
}
