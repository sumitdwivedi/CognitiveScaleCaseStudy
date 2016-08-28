package com.cognitivescale.poc.bank.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognitivescale.poc.bank.business.to.TransactionTO;
import com.cognitivescale.poc.bank.data.TransactionDAO;
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
		TransactionTO TransactionTO = new TransactionTO(transaction.getId(), transaction.getTransactionID(), transaction.getTransactionType(), transaction.getTransactionMethod(), 
				transaction.getTransactionDate(), transaction.getChequeNum(), transaction.getAccountNum(), transaction.getAmount(), transaction.getCurrentBalance(), transaction.getRemarks(), transaction.getCustomerID());
		return TransactionTO;
	}

	@Override
	public List<TransactionTO> getAllTransaction(String transactionName) {
		// TODO Auto-generated method stub
		return null;
	}

}
