package com.cognitivescale.poc.bank.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognitivescale.poc.bank.business.BeneficiaryService;
import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;
import com.cognitivescale.poc.bank.web.dto.BeneficiaryDTO;

/**
 * @author sumdwive
 *
 */
@Controller
@RequestMapping(value = "/customer/{customerID}/account/{accountID}/beneficiary")
public class BeneficiaryController {
	
	@Autowired
    private BeneficiaryService beneficiaryService;
	
	public long addBeneficiary(BeneficiaryDTO beneficiaryDTO) {
		BeneficiaryTO BeneficiaryTO = new BeneficiaryTO(beneficiaryDTO.getAccountNum(), beneficiaryDTO.getIfcsCode(), beneficiaryDTO.getNickName(), beneficiaryDTO.getCustomerID(), beneficiaryDTO.getAccountName());
		return beneficiaryService.addBeneficiary(BeneficiaryTO);
	}
    public void deleteBeneficiary(long id) {
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
    
    public BeneficiaryDTO getBeneficiary(long id) {
    	BeneficiaryTO beneficiaryTO = beneficiaryService.getBeneficiary(id);
    	BeneficiaryDTO BeneficiaryDTO = getBeneficiaryDTO(beneficiaryTO);
		return BeneficiaryDTO;
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
