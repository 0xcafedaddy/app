package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity
@Table(name="xxj_teacher")
public class XxjTeacher implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = -8464011148185548929L;
	@Id
	@GeneratedValue
	private Integer tc_id;
	private String tc_name;
	private String grade_list;
	private String subject_list;
	private String tc_job;
	private String tc_image;
	private String tc_thumbnail;
	private String tc_introduce;
	private String tc_say;
	private Integer status;
	private String tc_pic;
	private String subject_name;
	private String params;
	private Integer sort;
	
	public XxjTeacher() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getTc_id() {
		return tc_id;
	}

	public void setTc_id(Integer tc_id) {
		this.tc_id = tc_id;
	}

	public String getTc_name() {
		return tc_name;
	}

	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}

	public String getGrade_list() {
		return grade_list;
	}

	public void setGrade_list(String grade_list) {
		this.grade_list = grade_list;
	}

	public String getSubject_list() {
		return subject_list;
	}

	public void setSubject_list(String subject_list) {
		this.subject_list = subject_list;
	}

	public String getTc_job() {
		return tc_job;
	}

	public void setTc_job(String tc_job) {
		this.tc_job = tc_job;
	}

	public String getTc_image() {
		return tc_image;
	}

	public void setTc_image(String tc_image) {
		this.tc_image = tc_image;
	}

	public String getTc_thumbnail() {
		return tc_thumbnail;
	}

	public void setTc_thumbnail(String tc_thumbnail) {
		this.tc_thumbnail = tc_thumbnail;
	}

	public String getTc_introduce() {
		return tc_introduce;
	}

	public void setTc_introduce(String tc_introduce) {
		this.tc_introduce = tc_introduce;
	}

	public String getTc_say() {
		return tc_say;
	}

	public void setTc_say(String tc_say) {
		this.tc_say = tc_say;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTc_pic() {
		return tc_pic;
	}

	public void setTc_pic(String tc_pic) {
		this.tc_pic = tc_pic;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
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
						  .add("tc_id", tc_id)
						  .add("tc_name", tc_name)
						  .add("grade_list", grade_list)
						  .add("subject_list", subject_list)
						  .add("tc_job", tc_job)
						  .add("tc_image", tc_image)
						  .add("tc_thumbnail", tc_thumbnail)
						  .add("tc_introduce", tc_introduce)
						  .add("tc_say", tc_say)
						  .add("status", status)
						  .add("tc_pic", tc_pic)
						  .add("subject_name", subject_name)
						  .add("params", params)
						  .add("sort", sort)
						  .omitNullValues()
						  .toString();
	}
}
