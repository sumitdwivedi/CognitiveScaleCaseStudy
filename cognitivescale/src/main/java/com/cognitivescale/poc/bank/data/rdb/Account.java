package com.cognitivescale.poc.bank.data.rdb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name = "customer_id")
	long customerID;
	@Column(name = "balance")
	double balance;
	@Column(name = "acc_type")
	String accType;
	@Column(name = "account_open_date")
	Date accountOpenDate;
	
	@ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account",
            targetEntity = Beneficiary.class)
	private List<Beneficiary> beneficiaryList = new ArrayList<>(0);
	
	public Account(){}
	
	public Account(long id, String accountNum, long customerID, double balance, String accType,
			Date accountOpenDate) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.customerID = customerID;
		this.balance = balance;
		this.accType = accType;
		this.accountOpenDate = accountOpenDate;
	}
	
	public Account(String accountNum, long customerID, double balance, String accType,
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
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Beneficiary> getBeneficiaryList() {
		return beneficiaryList;
	}

	public void setBeneficiaryList(List<Beneficiary> beneficiaryList) {
		this.beneficiaryList = beneficiaryList;
	}
	
	
	
	
}
