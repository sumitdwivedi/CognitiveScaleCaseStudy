package com.cognitivescale.poc.bank.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cognitivescale.poc.bank.business.to.TransactionTO;
import com.cognitivescale.poc.bank.web.dto.TransactionDTO;
import com.cognitivescale.poc.bank.business.TransactionSerivce;

/**
 * @author sumdwive
 *
 */
@Controller
public class TransactionController {
	
	@Autowired
    private TransactionSerivce transactionSerivce;
	
	public long createTransaction(TransactionDTO transactionDTO) {
		TransactionTO TransactionTO = new TransactionTO(transactionDTO.getTransactionID(), transactionDTO.getTransactionType(), transactionDTO.getTransactionMethod(), 
				transactionDTO.getTransactionDate(), transactionDTO.getChequeNum(), transactionDTO.getAccountNum(), transactionDTO.getAmount(), transactionDTO.getCurrentBalance(), 
				transactionDTO.getRemarks(), transactionDTO.getCustomerID());
		return transactionSerivce.createTransaction(TransactionTO);
	}
    public List<TransactionDTO> getAllTransactions() {
		return null;
	}
    public TransactionDTO getTransaction(long id) {
    	TransactionTO transactionTO = transactionSerivce.getTransaction(id);
    	TransactionDTO TransactionDTO = new TransactionDTO(transactionTO.getId(), transactionTO.getTransactionID(), transactionTO.getTransactionType(), transactionTO.getTransactionMethod(), 
    			transactionTO.getTransactionDate(), transactionTO.getChequeNum(), transactionTO.getAccountNum(), transactionTO.getAmount(), transactionTO.getCurrentBalance(), transactionTO.getRemarks(), 
    			transactionTO.getCustomerID());
		return TransactionDTO;
	}   
    public List<TransactionDTO> getAllTransaction(String transactionName) {
		return null;
	}
}
