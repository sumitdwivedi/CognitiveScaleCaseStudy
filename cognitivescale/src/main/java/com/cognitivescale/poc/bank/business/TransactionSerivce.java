package com.cognitivescale.poc.bank.business;

import java.util.List;

import com.cognitivescale.poc.bank.business.to.TransactionTO;

/**
 * @author sumdwive
 *
 */
public interface TransactionSerivce {
	
	public long createTransaction(TransactionTO customer);
    public List<TransactionTO> getAllTransactions();
    public TransactionTO getTransaction(long id);   
    public List<TransactionTO> getAllTransaction(long customerPK);
}
