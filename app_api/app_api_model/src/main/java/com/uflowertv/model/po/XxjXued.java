package com.uflowertv.model.po;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="xxj_xued")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY,region = "entityCache")
public class XxjXued implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = -8074569152459182396L;
	@Id
	@GeneratedValue
	private Integer xued_id;
	private String xued_name;
	private Integer sort;
	
	public XxjXued() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getXued_id() {
		return xued_id;
	}

	public void setXued_id(Integer xued_id) {
		this.xued_id = xued_id;
	}

	public String getXued_name() {
		return xued_name;
	}

	public void setXued_name(String xued_name) {
		this.xued_name = xued_name;
	}
	
}
