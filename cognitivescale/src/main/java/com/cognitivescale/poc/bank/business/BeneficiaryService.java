package com.cognitivescale.poc.bank.business;

import java.util.List;

import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;

/**
 * @author sumdwive
 *
 */
public interface BeneficiaryService {
	
	public long addBeneficiary(BeneficiaryTO beneficiar);
    public void deleteBeneficiary(long id);
    public List<BeneficiaryTO> getAllBeneficiaries();
    public BeneficiaryTO getBeneficiary(long id);   
    public List<BeneficiaryTO> getAllBeneficiaries(long customerID);
}
