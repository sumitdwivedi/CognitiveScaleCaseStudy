package com.cognitivescale.poc.bank.data;

import java.util.List;

import com.cognitivescale.poc.bank.business.to.AccountTO;



/**
 * @author sumdwive
 *
 */
public interface AccountDAO {
	
	public long createAccount(AccountTO accountTO);
    public AccountTO updateAccount(AccountTO account);
    public void deleteAccount(long id);
    public List<AccountTO> getAllAccounts();
    public AccountTO getAccount(long id);   
    public List<AccountTO> getAllAccounts(long customerID);
}
