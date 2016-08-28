package com.cognitivescale.poc.bank.web.dto;

public class BeneficiaryDTO {

	long id;
	String accountNum;
	String ifcsCode;
	String nickName;
	String customerID;
	String accountName;
	
	public BeneficiaryDTO(){}
	
	public BeneficiaryDTO(long id, String accountNum, String ifcsCode, String nickName, String customerID,
			String accountName) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.ifcsCode = ifcsCode;
		this.nickName = nickName;
		this.customerID = customerID;
		this.accountName = accountName;
	}
	
	public BeneficiaryDTO(String accountNum, String ifcsCode, String nickName, String customerID,
			String accountName) {
		super();
		this.accountNum = accountNum;
		this.ifcsCode = ifcsCode;
		this.nickName = nickName;
		this.customerID = customerID;
		this.accountName = accountName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getIfcsCode() {
		return ifcsCode;
	}

	public void setIfcsCode(String ifcsCode) {
		this.ifcsCode = ifcsCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
