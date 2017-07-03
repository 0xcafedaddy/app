package com.uflowertv.model.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "xxj_product")
public class XxjProduct implements Serializable{

	private static final long serialVersionUID = 2057987260116246264L;
	@Id
	@GeneratedValue
	private Integer product_id;
	private Integer platformId;
	private String product_name;
	private String product_introduce;
	private String product_image;
	private Integer product_status;
	private Integer product_type;
	private Integer xued_id;
	private Integer grade_id;
	private Integer subject_id;
	private Integer subject_type;
	private Integer is_free;
	private String content_list;
	private Integer buy_days;
	private String buy_type;
	private String buy_tips;
	private Date effective;//产品有效期
	private Date expires;//产品失效期
	private Integer sort;

	public XxjProduct() {}
	
	public XxjProduct(Integer product_id, Integer xued_id) {
		super();
		this.product_id = product_id;
		this.xued_id = xued_id;
	}

	public XxjProduct(Integer grade_id, String content_list) {
		super();
		this.grade_id = grade_id;
		this.content_list = content_list;
	}
	 
	public XxjProduct(String content_list) {
		super();
		this.content_list = content_list;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_introduce() {
		return product_introduce;
	}

	public void setProduct_introduce(String product_introduce) {
		this.product_introduce = product_introduce;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public Integer getProduct_status() {
		return product_status;
	}

	public void setProduct_status(Integer product_status) {
		this.product_status = product_status;
	}

	public Integer getProduct_type() {
		return product_type;
	}

	public void setProduct_type(Integer product_type) {
		this.product_type = product_type;
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

	public Integer getSubject_type() {
		return subject_type;
	}

	public void setSubject_type(Integer subject_type) {
		this.subject_type = subject_type;
	}

	public Integer getIs_free() {
		return is_free;
	}

	public void setIs_free(Integer is_free) {
		this.is_free = is_free;
	}

	public String getContent_list() {
		return content_list;
	}

	public void setContent_list(String content_list) {
		this.content_list = content_list;
	}

	public Integer getBuy_days() {
		return buy_days;
	}

	public void setBuy_days(Integer buy_days) {
		this.buy_days = buy_days;
	}

	public String getBuy_type() {
		return buy_type;
	}

	public void setBuy_type(String buy_type) {
		this.buy_type = buy_type;
	}

	public String getBuy_tips() {
		return buy_tips;
	}

	public void setBuy_tips(String buy_tips) {
		this.buy_tips = buy_tips;
	}

	public Date getEffective() {
		return effective;
	}

	public void setEffective(Date effective) {
		this.effective = effective;
	}

	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
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
						  .add("product_id", product_id)
						  .add("platformId", platformId)
						  .add("product_name", product_name)
						  .add("product_introduce", product_introduce)
						  .add("product_image", product_image)
						  .add("product_status", product_status)
						  .add("product_type", product_type)
						  .add("xued_id", xued_id)
						  .add("grade_id", grade_id)
						  .add("subject_id", subject_id)
						  .add("subject_type", subject_type)
						  .add("is_free", is_free)
						  .add("content_list", content_list)
						  .add("buy_days", buy_days)
						  .add("buy_type", buy_type)
						  .add("buy_tips", buy_tips)
						  .add("effective", effective)
						  .add("expires", expires)
						  .add("sort", sort)
						  .omitNullValues()
						  .toString();
	}

}
