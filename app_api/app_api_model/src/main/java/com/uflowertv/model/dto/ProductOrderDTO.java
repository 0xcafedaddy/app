
package com.uflowertv.model.dto;

import java.util.List;

import com.google.common.base.MoreObjects;


public class ProductOrderDTO {
	
    private String lineOrPoint;
    private String offerId;
    private String offerInstId;
    private String offerName;
    private List<ProductDTO> productLs;
    
	public ProductOrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getLineOrPoint() {
		return lineOrPoint;
	}

	public void setLineOrPoint(String lineOrPoint) {
		this.lineOrPoint = lineOrPoint;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getOfferInstId() {
		return offerInstId;
	}

	public void setOfferInstId(String offerInstId) {
		this.offerInstId = offerInstId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public List<ProductDTO> getProductLs() {
		return productLs;
	}

	public void setProductLs(List<ProductDTO> productLs) {
		this.productLs = productLs;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("lineOrPoint", lineOrPoint)
				  .add("offerId", offerId)
				  .add("offerInstId", offerInstId)
				  .add("offerName", offerName)
				  .add("productLs", productLs)
				  .omitNullValues()
				  .toString();
	}
	
}
