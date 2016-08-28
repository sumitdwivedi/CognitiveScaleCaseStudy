package com.cognitivescale.poc.bank.data.impl;

import java.util.List;

import com.cognitivescale.poc.bank.business.to.TransactionTO;
import com.cognitivescale.poc.bank.data.TransactionDAO;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public long createTransaction(TransactionTO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TransactionTO> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionTO getTransaction(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionTO> getAllTransaction(String transactionName) {
		// TODO Auto-generated method stub
		return null;
	}

}
