
package com.uflowertv.model.dto;

import java.util.List;

import com.google.common.base.MoreObjects;

public class UserDTO {

    private String caId;
    private String caModel;
    private String caType;
    private Integer isMain;
    private String prodInstId;
    private String status;
    private List<ProductOrderDTO> productOrderList;

    public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCaId() {
		return caId;
	}

	public void setCaId(String caId) {
		this.caId = caId;
	}

	public String getCaModel() {
		return caModel;
	}

	public void setCaModel(String caModel) {
		this.caModel = caModel;
	}

	public String getCaType() {
		return caType;
	}

	public void setCaType(String caType) {
		this.caType = caType;
	}

	public Integer getIsMain() {
		return isMain;
	}

	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}

	public String getProdInstId() {
		return prodInstId;
	}

	public void setProdInstId(String prodInstId) {
		this.prodInstId = prodInstId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProductOrderDTO> getProductOrderList() {
		return productOrderList;
	}

	public void setProductOrderList(List<ProductOrderDTO> productOrderList) {
		this.productOrderList = productOrderList;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("caId", caId)
				  .add("caModel", caModel)
				  .add("caType", caType)
				  .add("isMain", isMain)
				  .add("prodInstId", prodInstId)
				  .add("status", status)
				  .add("productOrderList", productOrderList)
				  .omitNullValues()
				  .toString();
	}
}
