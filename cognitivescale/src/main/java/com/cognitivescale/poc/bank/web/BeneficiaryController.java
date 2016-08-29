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

import com.cognitivescale.poc.bank.business.BeneficiaryService;
import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;
import com.cognitivescale.poc.bank.business.to.TransactionTO;
import com.cognitivescale.poc.bank.web.dto.BeneficiaryDTO;
import com.cognitivescale.poc.bank.web.dto.TransactionDTO;

/**
 * @author sumdwive
 *
 */
@Controller
@RequestMapping(value = "/customer/{customerID}/account/{accountID}/beneficiary")
public class BeneficiaryController {
	
	@Autowired
    private BeneficiaryService beneficiaryService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<BeneficiaryDTO> addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) {
		BeneficiaryTO beneficiaryTO = new BeneficiaryTO(beneficiaryDTO.getAccountNum(), beneficiaryDTO.getIfcsCode(), beneficiaryDTO.getNickName(), beneficiaryDTO.getCustomerID(), beneficiaryDTO.getAccountName());
		long id =  beneficiaryService.addBeneficiary(beneficiaryTO);
		beneficiaryDTO.setId(id);
		Resource<BeneficiaryDTO> resource = new Resource(beneficiaryDTO);
	    resource.add(linkTo(methodOn(BeneficiaryController.class).getBeneficiary(id)).withRel("customer.customerID.account.accountID.beneficiary.beneficiaryID"));
	    return resource;
	}
	
	@RequestMapping(value = "/{beneficiaryID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public void deleteBeneficiary(@PathVariable(value = "beneficiaryID")  long id) {
    	beneficiaryService.deleteBeneficiary(id);
	}
    
    public List<BeneficiaryDTO> getAllBeneficiaries(long custmerID) {
    	List<BeneficiaryTO> beneficiaryTOList = beneficiaryService.getAllBeneficiaries(custmerID);
    	List<BeneficiaryDTO> beneficiaryDTOList = new ArrayList<>();
    	for(BeneficiaryTO beneficiaryTO : beneficiaryTOList) {
    		BeneficiaryDTO BeneficiaryDTO = getBeneficiaryDTO(beneficiaryTO);
    		beneficiaryDTOList.add(BeneficiaryDTO);
    	}
		return beneficiaryDTOList;
	}
    
    /*public List<BeneficiaryDTO> getAllBeneficiaries() {
		return null;
	}*/
    
    @RequestMapping(value = "/{beneficiaryID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   	@ResponseBody
    public Resource<BeneficiaryDTO> getBeneficiary(@PathVariable(value = "beneficiaryID") long id) {
    	BeneficiaryTO beneficiaryTO = beneficiaryService.getBeneficiary(id);
    	BeneficiaryDTO beneficiaryDTO = getBeneficiaryDTO(beneficiaryTO);
    	beneficiaryDTO.setId(id);
		Resource<BeneficiaryDTO> resource = new Resource(beneficiaryDTO);
	    resource.add(linkTo(methodOn(BeneficiaryController.class).getBeneficiary(id)).withSelfRel());
	    return resource;
	}  
    
    @RequestMapping(value = "/{beneficiaryID}/trnasferFund/{amount}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
   	@ResponseBody
    public Resource<TransactionDTO> trnasferFund(@PathVariable(value = "accountID") long accountID, @PathVariable(value = "beneficiaryID") long beneficiaryID, 
    		@PathVariable(value = "amount") double amount) {
    	TransactionTO transactionTO = beneficiaryService.trnasferFund(accountID, beneficiaryID, amount);
    	TransactionDTO transactionDTO = TransactionDTO.getTransactionDTO(transactionTO);
		Resource<TransactionDTO> resource = new Resource(transactionDTO);
	    resource.add(linkTo(methodOn(TransactionController.class).getTransaction(transactionTO.getId())).withRel("customer.customerID.transaction.transactionID"));
	    return resource;
	}   
    
    /*public List<BeneficiaryDTO> getAllBeneficiaries(long customerID) {
		return null;
	}*/
	private BeneficiaryDTO getBeneficiaryDTO(BeneficiaryTO beneficiaryTO) {
		BeneficiaryDTO BeneficiaryDTO = new BeneficiaryDTO(beneficiaryTO.getId(), beneficiaryTO.getAccountNum(), beneficiaryTO.getIfcsCode(), beneficiaryTO.getNickName(), beneficiaryTO.getCustomerID()
    			, beneficiaryTO.getAccountName());
		return BeneficiaryDTO;
	}
}
