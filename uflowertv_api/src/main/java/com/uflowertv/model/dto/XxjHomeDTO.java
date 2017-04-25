package com.uflowertv.model.dto;

import com.google.common.base.MoreObjects;

public class XxjHomeDTO {
	
	private String home_image;//首页图片
	private String home_location;//图片位置
	private String ui_name;//UIID
	private String ui_url;//url
	private String effective;//生效时间
	private String expires;//失效时间
	private String status;//发布 0未发布1已发布
	private String params;//首页参数
	
	
	public XxjHomeDTO() {}
	
	public String getEffective() {
		return effective;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		this.expires = expires;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHome_image() {
		return home_image;
	}


	public void setHome_image(String home_image) {
		this.home_image = home_image;
	}


	public String getHome_location() {
		return home_location;
	}


	public void setHome_location(String home_location) {
		this.home_location = home_location;
	}


	public String getUi_name() {
		return ui_name;
	}


	public void setUi_name(String ui_name) {
		this.ui_name = ui_name;
	}


	public String getUi_url() {
		return ui_url;
	}


	public void setUi_url(String ui_url) {
		this.ui_url = ui_url;
	}


	public String getParams() {
		return params;
	}


	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("home_image", home_image)
				  .add("home_location", home_location)
				  .add("ui_name", ui_name)
				  .add("ui_url", ui_name)
				  .add("status", status)
				  .add("params", params)
				  .add("effective", effective)
				  .add("expires", expires)
				  .omitNullValues()
				  .toString();
	}
}
