package com.uflowertv.model.dto;

import com.google.common.base.MoreObjects;

public class ProductDTO {

    private String productId;
    private String productName;
    private String status;
    private String validDate;
    private String expireDate;
    
    public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("productId", productId)
				  .add("productName", productName)
				  .add("status", status)
				  .add("validDate", validDate)
				  .add("expireDate", expireDate)
				  .omitNullValues()
				  .toString();
	}
	
}
