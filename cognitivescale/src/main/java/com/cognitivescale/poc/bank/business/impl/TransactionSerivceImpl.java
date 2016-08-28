package com.cognitivescale.poc.bank.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognitivescale.poc.bank.business.TransactionSerivce;
import com.cognitivescale.poc.bank.business.to.TransactionTO;
import com.cognitivescale.poc.bank.data.TransactionDAO;

@Service
@Transactional
public class TransactionSerivceImpl implements TransactionSerivce {
	
	@Autowired
    private TransactionDAO TransactionDAO;

	@Override
	public long createTransaction(TransactionTO transactionTO) {
		// TODO Auto-generated method stub
		return TransactionDAO.createTransaction(transactionTO);
	}

	@Override
	public List<TransactionTO> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionTO getTransaction(long id) {
		// TODO Auto-generated method stub
		return TransactionDAO.getTransaction(id);
	}

	@Override
	public List<TransactionTO> getAllTransaction(long customerPK) {
		// TODO Auto-generated method stub
		return null;
	}

}
