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
@Table(name = "transaction")
public class Transaction extends RDBBase{

	
	@Column(name = "transaction_id")
	String transactionID;
	@Column(name = "transaction_type")
	String transactionType;
	@Column(name = "transaction_method")
	String transactionMethod;
	
	@Column(name = "transaction_date")
	String transactionDate;
	
	@Column(name = "cheque_num")
	String chequeNum;
	@Column(name = "account_num")
	String accountNum;
	@Column(name = "amount")
	Double amount;
	@Column(name = "current_balance")
	Double currentBalance;
	@Column(name = "remarks")
	String remarks;
	@Column(name = "customer_id")
	String customerID;
	
	@ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
	
public Transaction(){}
	
	public Transaction(long id, String transactionID, String transactionType, String transactionMethod,
			String transactionDate, String chequeNum, String accountNum, Double amount, Double currentBalance,
			String remarks, String customerID) {
		super();
		this.id = id;
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.transactionMethod = transactionMethod;
		this.transactionDate = transactionDate;
		this.chequeNum = chequeNum;
		this.accountNum = accountNum;
		this.amount = amount;
		this.currentBalance = currentBalance;
		this.remarks = remarks;
		this.customerID = customerID;
		
	}
		
		public Transaction(String transactionID, String transactionType, String transactionMethod,
				String transactionDate, String chequeNum, String accountNum, Double amount, Double currentBalance,
				String remarks, String customerID) {
			super();
			this.transactionID = transactionID;
			this.transactionType = transactionType;
			this.transactionMethod = transactionMethod;
			this.transactionDate = transactionDate;
			this.chequeNum = chequeNum;
			this.accountNum = accountNum;
			this.amount = amount;
			this.currentBalance = currentBalance;
			this.remarks = remarks;
			this.customerID = customerID;
	}
	
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionMethod() {
		return transactionMethod;
	}
	public void setTransactionMethod(String transactionMethod) {
		this.transactionMethod = transactionMethod;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getChequeNum() {
		return chequeNum;
	}
	public void setChequeNum(String chequeNum) {
		this.chequeNum = chequeNum;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
