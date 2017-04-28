package com.util.ctvit.gather;

/**
 * 公共应用参数接口
 * */
public class PublicAppParamters {
	
	private  String appcode ;//应用标识  应用唯一标识（由荔枝云平台提供）
	
	private  String versionId;//版本号 接口版本号，当前版本号为V1
	
	private  String companyId;//企业标识 企业唯一标识（由荔枝云平台提供）
	
	private  String userId;//用户唯一标识（用户填充）
	
	
	public String getAppcode() {
		return appcode;
	}
	public void setAppcode(String appcode) {
		this.appcode = appcode;
	}
	public String getVersionId() {
		return versionId;
	}
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
