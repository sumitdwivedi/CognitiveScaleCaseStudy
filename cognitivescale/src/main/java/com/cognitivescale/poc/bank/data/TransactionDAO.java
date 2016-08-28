package com.cognitivescale.poc.bank.data;

import java.util.List;

import com.cognitivescale.poc.bank.data.rdb.Transaction;

/**
 * @author sumdwive
 *
 */
public interface TransactionDAO {
	
	public long createTransaction(Transaction customer);
    public List<Transaction> getAllTransactions();
    public Transaction getTransaction(long id);   
    public List<Transaction> getAllTransaction(String transactionName);
}
