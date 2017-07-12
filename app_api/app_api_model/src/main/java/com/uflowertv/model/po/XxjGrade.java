package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xxj_grade")
public class XxjGrade implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 2671144404315023876L;
	@Id
	@GeneratedValue
	private Integer grade_id;
	private String grade_name;
	private Integer xued_id;
	private Integer sort;
	
	public XxjGrade() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(Integer grade_id) {
		this.grade_id = grade_id;
	}

	public String getGrade_name() {
		return grade_name;
	}

	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

	public Integer getXued_id() {
		return xued_id;
	}

	public void setXued_id(Integer xued_id) {
		this.xued_id = xued_id;
	}
	
	
}
