package com.cognitivescale.poc.bank.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognitivescale.poc.bank.data.AccountDAO;
import com.cognitivescale.poc.bank.data.rdb.Account;
import com.cognitivescale.poc.bank.data.util.HibernateUtil;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long createAccount(Account account) {
		return (Long) hibernateUtil.create(account);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccounts(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
