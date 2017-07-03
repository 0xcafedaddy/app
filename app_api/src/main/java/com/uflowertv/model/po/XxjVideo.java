package com.uflowertv.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

import lombok.Data;

@Entity
@Table(name="xxj_video")
@Data
public class XxjVideo implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 5595766658152744835L;
	@Id
	@GeneratedValue
	private Integer video_id;
	private String video_name;
	private Integer xued_id;
	private Integer grade_id;
	private Integer subject_id;
	private Integer point_id;
	private Integer term;
	private Integer teacher_id;
	private Integer video_status;
	private Integer is_free;
	private Integer courseware_count;
	private Integer sort;
	
	public XxjVideo() {}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("video_id", video_id)
						  .add("video_name", video_name)
						  .add("xued_id", xued_id)
						  .add("grade_id", grade_id)
						  .add("subject_id", subject_id)
						  .add("point_id", point_id)
						  .add("term", term)
						  .add("teacher_id", teacher_id)
						  .add("video_status", video_status)
						  .add("is_free", is_free)
						  .add("courseware_count", courseware_count)
						  .add("sort", sort)
						  .omitNullValues()
						  .toString();
	}
}
