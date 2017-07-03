package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="xxj_video_list")
public class XxjVideoUrl implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 7041787552781436018L;
	@Id
	@GeneratedValue
	private Integer video_id;
	private Integer platformId;
	private String video_url;
	
	public XxjVideoUrl() {
		// TODO Auto-generated constructor stub
	}
}
