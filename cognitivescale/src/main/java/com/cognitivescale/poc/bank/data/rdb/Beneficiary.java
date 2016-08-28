package com.cognitivescale.poc.bank.data.rdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sumdwive
 *
 */
@Entity
@Table(name = "beneficiary")
public class Beneficiary extends RDBBase {

	@Column(name = "account_num")
	String accountNum;
	@Column(name = "ifcs_code")
	String ifcsCode;
	@Column(name = "nick_name")
	String nickName;
	@Column(name = "customer_ids")
	String customerID;
	@Column(name = "account_name")
	String accountName;

	public Beneficiary() {
	}

	public Beneficiary(long id, String accountNum, String ifcsCode, String nickName, String customerID,
			String accountName) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.ifcsCode = ifcsCode;
		this.nickName = nickName;
		this.customerID = customerID;
		this.accountName = accountName;
	}

	public Beneficiary(String accountNum, String ifcsCode, String nickName, String customerID, String accountName) {
		super();
		this.accountNum = accountNum;
		this.ifcsCode = ifcsCode;
		this.nickName = nickName;
		this.customerID = customerID;
		this.accountName = accountName;
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
