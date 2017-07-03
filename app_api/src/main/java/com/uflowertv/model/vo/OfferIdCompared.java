package com.uflowertv.model.vo;

import com.google.common.base.MoreObjects;
/**
 * 
 * 版权所有：2017年3月8日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：套餐比较类（用于本地套餐与Boss接口套餐）
 * 类名称：com.uflowertv.model.vo.OfferIdCompared     
 * 创建人：liguoliang 
 * 创建时间：2017年3月8日 下午5:59:47   
 * 修改人：
 * 修改时间：2017年3月8日 下午5:59:47   
 * 修改备注：   
 * @version   V1.0
 */
public class OfferIdCompared {

    private String offerId;
    private String offerName;
    private String productId;
    private String productName;
    private String productStatus;
    private String validDate;
    private String expireDate;
    
    public OfferIdCompared() {}

	public OfferIdCompared(String offerId) {
		super();
		this.offerId = offerId;
	}

	public OfferIdCompared(String offerId, String offerName) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
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

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("offerId", offerId)
						  .add("offerName", offerName)
						  .add("expireDate", expireDate)
						  .add("productId", productId)
						  .add("productName", productName)
						  .add("productStatus", productStatus)
						  .add("validDate", validDate)
						  .omitNullValues()
						  .toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
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
		OfferIdCompared other = (OfferIdCompared) obj;
		if (offerId == null) {
			if (other.offerId != null)
				return false;
		} else if (!offerId.equals(other.offerId))
			return false;
		return true;
	}
	
}
