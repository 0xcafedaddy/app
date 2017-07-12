package com.uflowertv.model.dto;

import lombok.Data;
@Data
public class XxjProductDTO {

	//产品
	private String product_image;
	private String xued_id;
	private String grade_id;
	private String subject_id;
	private String subject_type;
	private String is_free;
	private String content_list;
	private String buy_days;
	private String buy_tips;
	private String product_id;//产品ID
	private String product_name;//产品名称
	private String product_introduce;//产品介绍
	private String product_type;//产品类型
	private String product_status;//产品状态
	private String product_effective;//产品有效期
	private String product_expires;	//产品失效期
	
	//订价
	private String order_id;
	private String oper_comboId;
	private String oper_offerId;
	private String oper_offerName;
	private String oper_productId;
	private String oper_productName;
	private String oper_productStatus;
	private String oper_orderId;
	private String order_souces;
	private String order_status;
	private String order_desc;
	private String buy_type;
	private String serial_number;
	private String pay_type;
	private String pay_desc;
	private String order_price;//产品价格
	private String order_effective;//订单有效期
	private String order_expires;	//订单失效期
	
	public XxjProductDTO() {
		// TODO Auto-generated constructor stub
	}
}
