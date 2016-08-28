package com.cognitivescale.poc.bank.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognitivescale.poc.bank.business.AccountService;
import com.cognitivescale.poc.bank.business.to.AccountTO;
import com.cognitivescale.poc.bank.data.AccountDAO;
import com.cognitivescale.poc.bank.data.rdb.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
    private AccountDAO accountDAO;
	
	@Override
	public long createAccount(AccountTO accountTO) {
		Account account = new Account(accountTO.getAccountNum(), accountTO.getCustomerID(), accountTO.getBalance(), accountTO.getAccType(), accountTO.getAccountOpenDate());
		return accountDAO.createAccount(account);
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
