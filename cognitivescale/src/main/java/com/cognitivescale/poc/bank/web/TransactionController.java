package com.cognitivescale.poc.bank.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
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

import com.cognitivescale.poc.bank.business.to.TransactionTO;
import com.cognitivescale.poc.bank.web.dto.AccountDTO;
import com.cognitivescale.poc.bank.web.dto.CustomerDTO;
import com.cognitivescale.poc.bank.web.dto.TransactionDTO;
import com.cognitivescale.poc.bank.business.TransactionSerivce;

/**
 * @author sumdwive
 *
 */
@Controller
@RequestMapping(value = "/customer/{customerID}/transaction")
public class TransactionController {
	
	@Autowired
    private TransactionSerivce transactionSerivce;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<TransactionDTO> createTransaction(@RequestBody  TransactionDTO transactionDTO) {
		TransactionTO TransactionTO = new TransactionTO(transactionDTO.getTransactionID(), transactionDTO.getTransactionType(), transactionDTO.getTransactionMethod(), 
				transactionDTO.getTransactionDate(), transactionDTO.getChequeNum(), transactionDTO.getAccountNum(), transactionDTO.getAmount(), transactionDTO.getCurrentBalance(), 
				transactionDTO.getRemarks(), transactionDTO.getCustomerID());
		long id = transactionSerivce.createTransaction(TransactionTO);
		transactionDTO.setId(id);
		Resource<TransactionDTO> resource = new Resource(transactionDTO);
	    resource.add(linkTo(methodOn(TransactionController.class).getTransaction(id)).withRel("customer.customerID.transaction.transactionID"));
	    return resource;
	}
    public List<TransactionDTO> getAllTransactions() {
		return null;
	}
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Resource<TransactionDTO> getTransaction(@PathVariable(value = "transactionID") long id) {
    	TransactionTO transactionTO = transactionSerivce.getTransaction(id);
    	TransactionDTO transactionDTO = getTransactionDTO(transactionTO);
		transactionDTO.setId(id);
		Resource<TransactionDTO> resource = new Resource(transactionDTO);
	    resource.add(linkTo(methodOn(TransactionController.class).getTransaction(id)).withSelfRel());
	    return resource;
	}
    
	private TransactionDTO getTransactionDTO(TransactionTO transactionTO) {
		TransactionDTO transactionDTO = new TransactionDTO(transactionTO.getId(), transactionTO.getTransactionID(), transactionTO.getTransactionType(), transactionTO.getTransactionMethod(), 
    			transactionTO.getTransactionDate(), transactionTO.getChequeNum(), transactionTO.getAccountNum(), transactionTO.getAmount(), transactionTO.getCurrentBalance(), transactionTO.getRemarks(), 
    			transactionTO.getCustomerID());
		return transactionDTO;
	}   
	
	@RequestMapping(value = "/allTransactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TransactionDTO> getAllTransaction(@PathVariable(value = "customerID") long customerID) {
    	List<TransactionDTO> transactoinDTOList = new ArrayList<>();
    	List<TransactionTO> transactionTOList = transactionSerivce.getAllTransaction(customerID);
    	for(TransactionTO transactionTO : transactionTOList){
    		TransactionDTO transactionDTO = getTransactionDTO(transactionTO);
    		transactoinDTOList.add(transactionDTO);
    	}
		return transactoinDTOList;
	}
}
