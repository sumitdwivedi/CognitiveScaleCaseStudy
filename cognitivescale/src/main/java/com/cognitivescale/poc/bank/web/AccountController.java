package com.cognitivescale.poc.bank.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cognitivescale.poc.bank.business.AccountService;
import com.cognitivescale.poc.bank.business.to.AccountTO;
import com.cognitivescale.poc.bank.web.dto.AccountDTO;



/**
 * @author sumdwive
 *
 */
@Controller
public class AccountController {
	
	@Autowired
    private AccountService accountService;
	
	public long createAccount(AccountDTO accountDTO) {
		AccountTO accountTO = new AccountTO(accountDTO.getAccountNum(), accountDTO.getCustomerID(), accountDTO.getBalance(), accountDTO.getAccType(), accountDTO.getAccountOpenDate());
		return accountService.createAccount(accountTO);
	}
    public AccountDTO updateAccount(AccountDTO account) {
		return null;
	}
    public void deleteAccount(long id) {
	}
    public List<AccountDTO> getAllAccounts() {
		return null;
	}
    public AccountDTO getAccount(long id) {
		return null;
	}   
    public List<AccountDTO> getAllAccounts(long customerID) {
		return null;
	}
}
