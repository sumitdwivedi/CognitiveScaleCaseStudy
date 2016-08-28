package com.cognitivescale.poc.bank.data.rdb;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sumdwive
 *
 */
@Entity
@Table(name = "account")
public class Account extends RDBBase{
	
	@Column(name = "account_num")
	String accountNum;
	@Column(name = "customer_ids")
	String customerID;
	@Column(name = "balance")
	double balance;
	@Column(name = "acc_type")
	String accType;
	@Column(name = "account_open_date")
	Date accountOpenDate;
	
	public Account(){}
	
	public Account(long id, String accountNum, String customerID, double balance, String accType,
			Date accountOpenDate) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.balance = balance;
		this.accType = accType;
		this.accountOpenDate = accountOpenDate;
	}
	
	public Account(String accountNum, String customerID, double balance, String accType,
			Date accountOpenDate) {
		super();
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.balance = balance;
		this.accType = accType;
		this.accountOpenDate = accountOpenDate;
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
