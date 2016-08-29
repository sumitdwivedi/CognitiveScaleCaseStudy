package com.cognitivescale.poc.bank.web.dto;

import com.cognitivescale.poc.bank.business.to.TransactionTO;

public class TransactionDTO {

	long id;
	String transactionID;
	String transactionType;
	String transactionMethod;
	
	String transactionDate;
	
	String chequeNum;
	String accountNum;
	Double amount;
	Double currentBalance;
	String remarks;
	String customerID;
	
	public TransactionDTO(){}
	
	public TransactionDTO(long id, String transactionID, String transactionType, String transactionMethod,
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
		
		public TransactionDTO(String transactionID, String transactionType, String transactionMethod,
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

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
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
		
		public static TransactionDTO getTransactionDTO(TransactionTO transactionTO) {
			TransactionDTO TransactionDTO = new TransactionDTO(transactionTO.getId(), transactionTO.getTransactionID(), transactionTO.getTransactionType(), transactionTO.getTransactionMethod(), 
	    			transactionTO.getTransactionDate(), transactionTO.getChequeNum(), transactionTO.getAccountNum(), transactionTO.getAmount(), transactionTO.getCurrentBalance(), transactionTO.getRemarks(), 
	    			transactionTO.getCustomerID());
			return TransactionDTO;
		}  
}
