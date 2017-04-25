
package com.uflowertv.model.dto;

import com.google.common.base.MoreObjects;

public class BalanceDTO {

    private String balance;
    private String balanceId;
    private String balanceName;

    public BalanceDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(String balanceId) {
		this.balanceId = balanceId;
	}

	public String getBalanceName() {
		return balanceName;
	}

	public void setBalanceName(String balanceName) {
		this.balanceName = balanceName;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
						  .add("balance", balance)
						  .add("balanceId", balanceId)
						  .add("balanceName", balanceName)
						  .omitNullValues()
						  .toString();
	}
}
