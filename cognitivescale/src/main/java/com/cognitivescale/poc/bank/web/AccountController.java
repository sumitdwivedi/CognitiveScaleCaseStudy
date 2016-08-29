package com.cognitivescale.poc.bank.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognitivescale.poc.bank.business.AccountService;
import com.cognitivescale.poc.bank.business.to.AccountTO;
import com.cognitivescale.poc.bank.web.dto.AccountDTO;
import com.cognitivescale.poc.bank.web.dto.CustomerDTO;



/**
 * @author sumdwive
 *
 */
@Controller
@RequestMapping(value = "/customer/{customerID}/account")
public class AccountController {
	
	@Autowired
    private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
		AccountTO accountTO = createAccountTO(accountDTO);
		long id = accountService.createAccount(accountTO);
		accountDTO.setId(id);
		Resource<AccountDTO> resource = new Resource(accountDTO);
	    resource.add(linkTo(methodOn(AccountController.class).getAccount(id)).withRel("customer.customerID.account.accountID"));
	    return resource;
	}
	
	private AccountTO createAccountTO(AccountDTO accountDTO) {
		AccountTO accountTO = new AccountTO(accountDTO.getAccountNum(), accountDTO.getCustomerID(), accountDTO.getBalance(), accountDTO.getAccType(), accountDTO.getAccountOpenDate());
		return accountTO;
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Resource<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO) {
    	AccountTO account = createAccountTO(accountDTO);
    	long id = accountDTO.getId();
		account.setId(id);
    	accountService.updateAccount(account);
    	Resource<AccountDTO> resource = new Resource(accountDTO);
	    resource.add(linkTo(methodOn(AccountController.class).getAccount(id)).withRel("customer.customerID.account.accountID"));
	    return resource;
	}
    
	@RequestMapping(value = "/{accountID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public void deleteAccount(@PathVariable(value = "accountID") long id) {
    	accountService.deleteAccount(id);
	}
	
    public List<AccountDTO> getAllAccounts() {
		return null;
	}
    
    @RequestMapping(value = "/{accountID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Resource<AccountDTO> getAccount(long id) {
		AccountTO account = accountService.getAccount(id);
		AccountDTO accountDTO = createAccountDTO(account);
		Resource<AccountDTO> resource = new Resource(accountDTO);
	    resource.add(linkTo(methodOn(AccountController.class).getAccount(id)).withSelfRel());
	    return resource;
	}
    
	private AccountDTO createAccountDTO(AccountTO account) {
		AccountDTO accountDTO = new AccountDTO(account.getId(), account.getAccountNum(), account.getCustomerID(), account.getBalance(), account.getAccType(), account.getAccountOpenDate());
		return accountDTO;
	} 
	
    public List<AccountDTO> getAllAccounts(long customerID) {
		return null;
	}
}
