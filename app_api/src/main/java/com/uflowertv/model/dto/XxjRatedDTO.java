package com.uflowertv.model.dto;

import com.google.common.base.MoreObjects;

import lombok.Data;
@Data
public class XxjRatedDTO {
	
	private String xued_name;
	private String grade_name;
	private String product_name;
	private String product_type;
	private String comboType;
	private String show_price;
	private String buy_tips;
	private String combo_id;
	private String flag;
	
	
	public XxjRatedDTO(){}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("xued_name", xued_name)
				  .add("grade_name", grade_name)
				.add("product_name", product_name)
				.add("product_type", product_type)
				.add("comboType", comboType)
				  .add("show_price", show_price)
				  .add("buy_tips", buy_tips)
				  .add("combo_id", combo_id)
				  .add("flag", flag)
				  .omitNullValues()
				  .toString();
	}
}
