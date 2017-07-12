package com.uflowertv.model.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * TbProvCityAreaStreet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_prov_city_area_street")
@Data
public class TbProvCityAreaStreet implements java.io.Serializable {

	// Fields    
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 8020610438803669396L;
	@Id
	private Integer id;
	private Integer pid;
	private String name;
	private Integer level;

	// Constructors

	/** default constructor */
	public TbProvCityAreaStreet() {
	}

	/** minimal constructor */
	public TbProvCityAreaStreet(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TbProvCityAreaStreet(Integer id, Integer pid, String name, Integer level) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.level = level;
	}
}