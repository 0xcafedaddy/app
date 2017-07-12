package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity
@Table(name="xxj_content")
public class XxjContent implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 8261943908485779093L;
	@Id
	@GeneratedValue
	private Integer content_id;
	private String content_name;
	private Integer content_status;
	private String content_introduce;
	private String video_list;
	private Integer xued_id;
	private Integer grade_id;
	private Integer subject_id;
	private Integer sort;
	
	public XxjContent() {
		// TODO Auto-generated constructor stub
	}

	public Integer getContent_id() {
		return content_id;
	}

	public void setContent_id(Integer content_id) {
		this.content_id = content_id;
	}

	public String getContent_name() {
		return content_name;
	}

	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}

	public Integer getContent_status() {
		return content_status;
	}

	public void setContent_status(Integer content_status) {
		this.content_status = content_status;
	}

	public String getContent_introduce() {
		return content_introduce;
	}

	public void setContent_introduce(String content_introduce) {
		this.content_introduce = content_introduce;
	}

	public String getVideo_list() {
		return video_list;
	}

	public void setVideo_list(String video_list) {
		this.video_list = video_list;
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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("content_id", content_id)
						  .add("content_name", content_name)
						  .add("content_status", content_status)
						  .add("content_introduce", content_introduce)
						  .add("video_list", video_list)
						  .add("xued_id", xued_id)
						  .add("grade_id", grade_id)
						  .add("subject_id", subject_id)
						  .add("sort", sort)
						  .omitNullValues()
						  .toString();
	}

}
