package com.cognitivescale.poc.bank.business.to;

public class BeneficiaryTO {

	long id;
	long customerAccountNum;
	long beneficiaryAccountNumber;
	String ifcsCode;
	String nickName;
	long customerID;
	String accountName;
	
public BeneficiaryTO(){}
	
	public BeneficiaryTO(long id, long customerAccountNum, long beneficiaryAccountNumber, String ifcsCode,
			String nickName, long customerID, String accountName) {
		super();
		this.id = id;
		this.customerAccountNum = customerAccountNum;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.ifcsCode = ifcsCode;
		this.nickName = nickName;
		this.customerID = customerID;
		this.accountName = accountName;
	}
	
	public BeneficiaryTO(long customerAccountNum, long beneficiaryAccountNumber, String ifcsCode,
			String nickName, long customerID, String accountName) {
		super();
		this.customerAccountNum = customerAccountNum;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
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

	public long getCustomerAccountNum() {
		return customerAccountNum;
	}

	public void setCustomerAccountNum(long customerAccountNum) {
		this.customerAccountNum = customerAccountNum;
	}

	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
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

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
