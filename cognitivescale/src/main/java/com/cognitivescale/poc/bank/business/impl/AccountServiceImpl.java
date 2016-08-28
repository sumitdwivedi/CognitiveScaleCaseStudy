package com.cognitivescale.poc.bank.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognitivescale.poc.bank.business.AccountService;
import com.cognitivescale.poc.bank.business.to.AccountTO;
import com.cognitivescale.poc.bank.data.AccountDAO;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
    private AccountDAO accountDAO;
	
	@Override
	public long createAccount(AccountTO accountTO) {
		return accountDAO.createAccount(accountTO);
	}

	@Override
	public AccountTO updateAccount(AccountTO account) {
		return accountDAO.updateAccount(account);
	}

	@Override
	public void deleteAccount(long id) {
		accountDAO.deleteAccount(id);

	}

	@Override
	public List<AccountTO> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountTO getAccount(long id) {
		return accountDAO.getAccount(id);
	}

	@Override
	public List<AccountTO> getAllAccounts(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
