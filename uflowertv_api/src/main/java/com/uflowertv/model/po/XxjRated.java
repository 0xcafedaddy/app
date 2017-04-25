package com.uflowertv.model.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity
@Table(name="xxj_rated")
public class XxjRated implements Serializable{

	private static final long serialVersionUID = 8732989341493010954L;
	@Id
	@GeneratedValue
	private Integer rated_id;
	private Integer platformId;
	private String combo_id;
	private String offer_id;
	private Integer product_id;
	private Integer product_type;
	private String rated_price;
	private String show_price;
	private Integer rated_type;
	private Date effective;
	private Date expires;

	public XxjRated() {}

	
	public XxjRated(String offer_id) {
		super();
		this.offer_id = offer_id;
	}

	public XxjRated(Integer productId, Integer productType, String showPrice) {
		super();
		this.product_id = productId;
		this.product_type = productType;
		this.show_price = showPrice;
	}

	public Integer getRated_id() {
		return rated_id;
	}

	public void setRated_id(Integer rated_id) {
		this.rated_id = rated_id;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	public String getCombo_id() {
		return combo_id;
	}

	public void setCombo_id(String combo_id) {
		this.combo_id = combo_id;
	}

	public String getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(String offer_id) {
		this.offer_id = offer_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getProduct_type() {
		return product_type;
	}

	public void setProduct_type(Integer product_type) {
		this.product_type = product_type;
	}

	public String getRated_price() {
		return rated_price;
	}

	public void setRated_price(String rated_price) {
		this.rated_price = rated_price;
	}

	public String getShow_price() {
		return show_price;
	}

	public void setShow_price(String show_price) {
		this.show_price = show_price;
	}

	public Integer getRated_type() {
		return rated_type;
	}

	public void setRated_type(Integer rated_type) {
		this.rated_type = rated_type;
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

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("rated_id", rated_id)
						  .add("platformId", platformId)
						  .add("combo_id", combo_id)
						  .add("offer_id", offer_id)
						  .add("product_id", product_id)
						  .add("product_type", product_type)
						  .add("rated_price", rated_price)
						  .add("show_price", show_price)
						  .add("rated_type", rated_type)
						  .add("effective", effective)
						  .add("expires", expires)
						  .omitNullValues()
						  .toString();
	}
	
}
