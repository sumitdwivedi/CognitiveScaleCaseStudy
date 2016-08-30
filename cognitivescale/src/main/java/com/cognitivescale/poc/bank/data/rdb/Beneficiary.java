package com.cognitivescale.poc.bank.data.rdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sumdwive
 *
 */
@Entity
@Table(name = "beneficiary")
public class Beneficiary extends RDBBase {

	@Column(name = "ifcs_code")
	String ifcsCode;
	@Column(name = "nick_name")
	String nickName;
	@Column(name = "customer_ids")
	long customerID;
	@Column(name = "account_name")
	String accountName;
	@Column(name = "customer_account_num")
	long customerAccountNum;
	@Column(name = "beneficiary_account_number")
	long beneficiaryAccountNumber;
	
	@ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
	
	@ManyToOne
    @JoinColumn(name = "customer_account_num", referencedColumnName = "id")
    private Account account;

	public Beneficiary() {
	}
	
	public Beneficiary(long id, long customerAccountNum, long beneficiaryAccountNumber, String ifcsCode,
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
	
	public Beneficiary(long customerAccountNum, long beneficiaryAccountNumber, String ifcsCode,
			String nickName, long customerID, String accountName) {
		super();
		this.customerAccountNum = customerAccountNum;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.ifcsCode = ifcsCode;
		this.nickName = nickName;
		this.customerID = customerID;
		this.accountName = accountName;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}
