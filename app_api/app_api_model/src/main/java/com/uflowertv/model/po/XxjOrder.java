package com.uflowertv.model.po;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="xxj_order")
@DynamicInsert
@DynamicUpdate
@Data	
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
	@Column(name = "gmt_create")
	private Date created;
	@Column(name = "gmt_modified")
	private Date modify;
	
	public XxjOrder() {}
	
	

	//营业厅订购
	public XxjOrder(Integer platformId, Integer user_id,String oper_comboId, String oper_offerId, String oper_offerName, String oper_productId,
			String oper_productName, Integer oper_productStatus, String oper_orderId, Integer product_id, String product_name,
			Integer order_souces, String order_price, Integer order_status, Integer buy_type,
			Date effective, Date expires,Date created,Date modify) {
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
		this.created = created;
		this.modify = modify;
	}


	public XxjOrder(String oper_offerId) {
		super();
		this.oper_offerId = oper_offerId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oper_offerId == null) ? 0 : oper_offerId.hashCode());
		return result;
	}
}
