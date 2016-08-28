package com.cognitivescale.poc.bank.data;

import java.util.List;

import com.cognitivescale.poc.bank.data.rdb.Account;



/**
 * @author sumdwive
 *
 */
public interface AccountDAO {
	
	public long createAccount(Account account);
    public Account updateAccount(Account account);
    public void deleteAccount(long id);
    public List<Account> getAllAccounts();
    public Account getAccount(long id);   
    public List<Account> getAllAccounts(long customerID);
}
