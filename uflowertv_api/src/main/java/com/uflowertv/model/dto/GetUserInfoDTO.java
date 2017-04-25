package com.uflowertv.model.dto;

import com.crunii.ccn.ectchannel.server.webservice.impl.ReturnData;
import com.google.common.base.MoreObjects;

public class GetUserInfoDTO extends ReturnData{

	private CustInfoDTO custInfo;
    
    public GetUserInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public CustInfoDTO getCustInfo() {
		return custInfo;
	}

	public void setCustInfo(CustInfoDTO custInfo) {
		this.custInfo = custInfo;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("custInfo", custInfo)
				  .omitNullValues()
				  .toString();
	}
}
