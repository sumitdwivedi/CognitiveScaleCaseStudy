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
		AccountTO accountTO = createAccountTO(accountDTO);
		return accountService.createAccount(accountTO);
	}
	
	private AccountTO createAccountTO(AccountDTO accountDTO) {
		AccountTO accountTO = new AccountTO(accountDTO.getAccountNum(), accountDTO.getCustomerID(), accountDTO.getBalance(), accountDTO.getAccType(), accountDTO.getAccountOpenDate());
		return accountTO;
	}
	
    public AccountDTO updateAccount(AccountDTO accountDTO) {
    	AccountTO account = createAccountTO(accountDTO);
    	account.setId(accountDTO.getId());
    	accountService.updateAccount(account);
		return accountDTO;
	}
    
    public void deleteAccount(long id) {
    	accountService.deleteAccount(id);
	}
    public List<AccountDTO> getAllAccounts() {
		return null;
	}
    public AccountDTO getAccount(long id) {
		AccountTO account = accountService.getAccount(id);
		AccountDTO accountDTO = createAccountDTO(account);
		return accountDTO;
	}
	private AccountDTO createAccountDTO(AccountTO account) {
		AccountDTO accountDTO = new AccountDTO(account.getId(), account.getAccountNum(), account.getCustomerID(), account.getBalance(), account.getAccType(), account.getAccountOpenDate());
		return accountDTO;
	}   
    public List<AccountDTO> getAllAccounts(long customerID) {
		return null;
	}
}
