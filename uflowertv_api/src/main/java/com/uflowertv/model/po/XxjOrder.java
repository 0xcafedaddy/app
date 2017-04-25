package com.uflowertv.model.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.google.common.base.MoreObjects;

@Entity
@Table(name="xxj_order")
@DynamicInsert
@DynamicUpdate
public class XxjOrder implements Serializable{

	private static final long serialVersionUID = -510358473180089803L;
	@Id
	@GeneratedValue
	private Integer order_id;
	private Integer platformId;
	private Integer user_id;
	private String oper_comboId;
	private String oper_offerId;
	private String oper_offerName;
	private String oper_productId;
	private String oper_productName;
	private Integer oper_productStatus;
	private String oper_orderId;
	private Integer product_id;
	private String product_name;
	private Integer order_souces;
	private String order_price;
	private Integer order_status;
	private String order_desc;
	private Integer buy_type;
	private String serial_number;
	private String pay_type;
	private String pay_desc;
	private Date effective;
	private Date expires;
	
	public XxjOrder() {}
	public XxjOrder(String oper_offerId) {
		super();
		this.oper_offerId = oper_offerId;
	}
	
	//营业厅订购
	public XxjOrder(Integer platformId, Integer user_id,String oper_comboId, String oper_offerId, String oper_offerName, String oper_productId,
			String oper_productName, Integer oper_productStatus, String oper_orderId, Integer product_id, String product_name,
			Integer order_souces, String order_price, Integer order_status, Integer buy_type,Date effective, Date expires) {
		super();
		this.platformId = platformId;
		this.user_id = user_id;
		this.oper_comboId = oper_comboId;
		this.oper_offerId = oper_offerId;
		this.oper_offerName = oper_offerName;
		this.oper_productId = oper_productId;
		this.oper_productName = oper_productName;
		this.oper_productStatus = oper_productStatus;
		this.oper_orderId = oper_orderId;
		this.product_id = product_id;
		this.product_name = product_name;
		this.order_souces = order_souces;
		this.order_price = order_price;
		this.order_status = order_status;
		this.buy_type = buy_type;
		this.effective = effective;
		this.expires = expires;
	}
	
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getOper_comboId() {
		return oper_comboId;
	}

	public void setOper_comboId(String oper_comboId) {
		this.oper_comboId = oper_comboId;
	}

	public String getOper_offerId() {
		return oper_offerId;
	}
	
	public void setOper_offerId(String oper_offerId) {
		this.oper_offerId = oper_offerId;
	}
	
	public String getOper_offerName() {
		return oper_offerName;
	}
	
	public void setOper_offerName(String oper_offerName) {
		this.oper_offerName = oper_offerName;
	}
	
	public String getOper_productId() {
		return oper_productId;
	}

	public void setOper_productId(String oper_productId) {
		this.oper_productId = oper_productId;
	}

	public String getOper_productName() {
		return oper_productName;
	}

	public void setOper_productName(String oper_productName) {
		this.oper_productName = oper_productName;
	}

	public Integer getOper_productStatus() {
		return oper_productStatus;
	}

	public void setOper_productStatus(Integer oper_productStatus) {
		this.oper_productStatus = oper_productStatus;
	}

	public String getOper_orderId() {
		return oper_orderId;
	}

	public void setOper_orderId(String oper_orderId) {
		this.oper_orderId = oper_orderId;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getOrder_souces() {
		return order_souces;
	}

	public void setOrder_souces(Integer order_souces) {
		this.order_souces = order_souces;
	}

	public String getOrder_price() {
		return order_price;
	}

	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
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
	
	public Integer getBuy_type() {
		return buy_type;
	}

	public void setBuy_type(Integer buy_type) {
		this.buy_type = buy_type;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getPay_type() {
		return pay_type;
	}
	
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	
	public String getPay_desc() {
		return pay_desc;
	}

	public void setPay_desc(String pay_desc) {
		this.pay_desc = pay_desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oper_offerId == null) ? 0 : oper_offerId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XxjOrder other = (XxjOrder) obj;
		if (oper_offerId == null) {
			if (other.oper_offerId != null)
				return false;
		} else if (!oper_offerId.equals(other.oper_offerId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("order_id", order_id)
						  .add("platformId", platformId)
						  .add("user_id", user_id)
						  .add("oper_comboId", oper_comboId)
						  .add("oper_offerId", oper_offerId)
						  .add("oper_offerName", oper_offerName)
						  .add("oper_productId", oper_productId)
						  .add("oper_productName", oper_productName)
						  .add("oper_productStatus", oper_productStatus)
						  .add("product_id", product_id)
						  .add("product_name", product_name)
						  .add("order_souces", order_souces)
						  .add("order_price", order_price)
						  .add("order_status", order_status)
						  .add("order_desc", order_desc)
						  .add("buy_type", buy_type)
						  .add("serial_number", serial_number)
						  .add("pay_type", pay_type)
						  .add("pay_desc", pay_desc)
						  .add("effective", effective)
						  .add("expires", expires)
						  .omitNullValues()
						  .toString();
	}
}
