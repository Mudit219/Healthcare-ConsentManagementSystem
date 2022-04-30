package com.springboot.ConsentManagement.ContractModel;

public class Transaction {

	private String contract;
	private long amount;

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}