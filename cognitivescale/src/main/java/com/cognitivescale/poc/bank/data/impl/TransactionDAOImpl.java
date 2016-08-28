package com.cognitivescale.poc.bank.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;
import com.cognitivescale.poc.bank.business.to.TransactionTO;
import com.cognitivescale.poc.bank.data.TransactionDAO;
import com.cognitivescale.poc.bank.data.rdb.Beneficiary;
import com.cognitivescale.poc.bank.data.rdb.Customer;
import com.cognitivescale.poc.bank.data.rdb.Transaction;
import com.cognitivescale.poc.bank.data.util.HibernateUtil;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
    private HibernateUtil hibernateUtil;
	
	@Override
	public long createTransaction(TransactionTO transactionTO) {
		Transaction transaction = new Transaction(transactionTO.getTransactionID(), transactionTO.getTransactionType(), transactionTO.getTransactionMethod(), 
				transactionTO.getTransactionDate(), transactionTO.getChequeNum(), transactionTO.getAccountNum(), transactionTO.getAmount(), transactionTO.getCurrentBalance(), transactionTO.getRemarks(), 
				transactionTO.getCustomerID());
		return (Long)hibernateUtil.create(transaction);
	}

	@Override
	public List<TransactionTO> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionTO getTransaction(long id) {
		Transaction transaction = hibernateUtil.fetchById(id, Transaction.class);
		TransactionTO TransactionTO = getTransactionTO(transaction);
		return TransactionTO;
	}

	private TransactionTO getTransactionTO(Transaction transaction) {
		TransactionTO TransactionTO = new TransactionTO(transaction.getId(), transaction.getTransactionID(), transaction.getTransactionType(), transaction.getTransactionMethod(), 
				transaction.getTransactionDate(), transaction.getChequeNum(), transaction.getAccountNum(), transaction.getAmount(), transaction.getCurrentBalance(), transaction.getRemarks(), transaction.getCustomerID());
		return TransactionTO;
	}

	@Override
	public List<TransactionTO> getAllTransaction(long customerPK) {
		Customer Customer = hibernateUtil.fetchById(customerPK, Customer.class);
		List<Transaction> transactionList = Customer.getTransactionsList();
		List<TransactionTO> transactionTOList = new ArrayList<>();
		for(Transaction  transaction : transactionList){
			TransactionTO transactionTO = getTransactionTO(transaction);
			transactionTOList.add(transactionTO);
		}
		return null;
	}

}
