package com.cognitivescale.poc.bank.data;

import java.util.List;

import com.cognitivescale.poc.bank.business.to.TransactionTO;

/**
 * @author sumdwive
 *
 */
public interface TransactionDAO {
	
	public long createTransaction(TransactionTO customer);
    public List<TransactionTO> getAllTransactions();
    public TransactionTO getTransaction(long id);   
    public List<TransactionTO> getAllTransaction(long customerPK);
}
