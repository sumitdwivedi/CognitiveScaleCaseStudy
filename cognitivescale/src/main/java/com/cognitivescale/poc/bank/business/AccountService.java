package com.cognitivescale.poc.bank.business;

import java.util.List;

import com.cognitivescale.poc.bank.business.to.AccountTO;


/**
 * @author sumdwive
 *
 */
public interface AccountService {
	
	public long createAccount(AccountTO account);
    public AccountTO updateAccount(AccountTO account);
    public void deleteAccount(long id);
    public List<AccountTO> getAllAccounts();
    public AccountTO getAccount(long id);   
    public List<AccountTO> getAllAccounts(long customerID);
}
