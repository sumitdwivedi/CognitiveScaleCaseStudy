package com.cognitivescale.poc.bank.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognitivescale.poc.bank.business.to.AccountTO;
import com.cognitivescale.poc.bank.data.AccountDAO;
import com.cognitivescale.poc.bank.data.rdb.Account;
import com.cognitivescale.poc.bank.data.util.HibernateUtil;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long createAccount(AccountTO accountTO) {
		Account account = new Account(accountTO.getAccountNum(), accountTO.getCustomerID(), accountTO.getBalance(), accountTO.getAccType(), accountTO.getAccountOpenDate());
		return (Long) hibernateUtil.create(account);
	}

	@Override
	public AccountTO updateAccount(AccountTO account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountTO> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountTO getAccount(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountTO> getAllAccounts(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}


}
