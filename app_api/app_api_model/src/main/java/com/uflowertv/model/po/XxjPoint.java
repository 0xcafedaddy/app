package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xxj_point")
public class XxjPoint implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 1148548004843204080L;
	@Id
	@GeneratedValue
	private Integer point_id;
	private String point_name;
	private Integer xued_id;
	private Integer grade_id;
	private Integer subject_id;
	private Integer term;
	private String params;
	private Integer status;
	private Integer sort;
	
	public XxjPoint() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPoint_id() {
		return point_id;
	}

	public void setPoint_id(Integer point_id) {
		this.point_id = point_id;
	}

	public String getPoint_name() {
		return point_name;
	}

	public void setPoint_name(String point_name) {
		this.point_name = point_name;
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

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
