package com.cognitivescale.poc.bank.business.to;

import java.util.Date;

public class AccountTO {

	long id;
	String accountNum;
	String customerID;
	double balance;
	String accType;
	Date accountOpenDate;
	
	public AccountTO(){}
	
	public AccountTO(long id, String accountNum, String customerID, double balance, String accType,
			Date accountOpenDate) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.balance = balance;
		this.accType = accType;
		this.accountOpenDate = accountOpenDate;
	}
	
	public AccountTO(String accountNum, String customerID, double balance, String accType,
			Date accountOpenDate) {
		super();
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.balance = balance;
		this.accType = accType;
		this.accountOpenDate = accountOpenDate;
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

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Date getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}
}
