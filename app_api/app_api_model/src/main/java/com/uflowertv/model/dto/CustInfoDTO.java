
package com.uflowertv.model.dto;

import java.util.List;

import com.google.common.base.MoreObjects;
public class CustInfoDTO{

    private String accountId;
    private String address;
    private String custCode;
    private String custId;
    private String custName;
    private String mobile;
    private String ownCorpOrg;
    private String oweTotalFee;
    private String phone;
    private String totleBalance;
    private List<BalanceDTO> balanceList;
    private List<UserDTO> userList;
    
	public CustInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getOweTotalFee() {
		return oweTotalFee;
	}

	public void setOweTotalFee(String oweTotalFee) {
		this.oweTotalFee = oweTotalFee;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOwnCorpOrg() {
		return ownCorpOrg;
	}

	public void setOwnCorpOrg(String ownCorpOrg) {
		this.ownCorpOrg = ownCorpOrg;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTotleBalance() {
		return totleBalance;
	}

	public void setTotleBalance(String totleBalance) {
		this.totleBalance = totleBalance;
	}

	public List<BalanceDTO> getBalanceList() {
		return balanceList;
	}

	public void setBalanceList(List<BalanceDTO> balanceList) {
		this.balanceList = balanceList;
	}

	public List<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDTO> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("accountId", accountId)
				  .add("address", address)
				  .add("custCode", custCode)
				  .add("custId", custId)
				  .add("custName", custName)
				  .add("mobile", mobile)
				  .add("ownCorpOrg", ownCorpOrg)
				  .add("oweTotalFee", oweTotalFee)
				  .add("phone", phone)
				  .add("totleBalance", totleBalance)
				  .add("balanceList", balanceList)
				  .add("userList", userList)
				  .omitNullValues()
				  .toString();
	}

}
