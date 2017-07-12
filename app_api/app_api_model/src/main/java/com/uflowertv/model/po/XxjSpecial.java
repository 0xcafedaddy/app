package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xxj_special")
public class XxjSpecial implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = -6726467237701633780L;
	@Id
	@GeneratedValue
	private Integer special_id;
	private Integer template;
	private String special_name;
	private String params;
	private String video_list;
	
	public XxjSpecial() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTemplate() {
		return template;
	}

	public void setTemplate(Integer template) {
		this.template = template;
	}

	public Integer getSpecial_id() {
		return special_id;
	}

	public void setSpecial_id(Integer special_id) {
		this.special_id = special_id;
	}

	public String getSpecial_name() {
		return special_name;
	}

	public void setSpecial_name(String special_name) {
		this.special_name = special_name;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getVideo_list() {
		return video_list;
	}

	public void setVideo_list(String video_list) {
		this.video_list = video_list;
	}
}
