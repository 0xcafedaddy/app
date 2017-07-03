package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xxj_subject")
public class XxjSubject implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = -6475428713556010106L;
	@Id
	@GeneratedValue
	private Integer subject_id;
	private String subject_name;
	private String subject_image;
	private Integer xued_id;
	private Integer grade_id;
	private Integer sort;
	public XxjSubject() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_image() {
		return subject_image;
	}
	public void setSubject_image(String subject_image) {
		this.subject_image = subject_image;
	}
	public Integer getXued_id() {
		return xued_id;
	}
	public void setXued_id(Integer xued_id) {
		this.xued_id = xued_id;
	}
	public Integer getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(Integer grade_id) {
		this.grade_id = grade_id;
	}
	
}
