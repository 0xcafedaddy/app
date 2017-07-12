package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="xxj_special_list")
@Data
public class XxjSpecialList implements Serializable{
	
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = -172954052503640893L;
	@Id
	@GeneratedValue
	private Integer special_id;
	private Integer video_id;
	private String video_name;
	private Integer xued_id;
	private Integer grade_id;
	private Integer subject_id;
	private Integer point_id;
	private String point_name;
	private Integer term;
	private Integer sort;
	private String subject_name;
	private Integer is_free;
	
	public XxjSpecialList() {}
}
