package com.cognitivescale.poc.bank.data;

import java.util.List;

import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;

//oracle.zoom.us/j/147217617?pwd=CKL7RQT%2Fz2c%3Dpackage com.cognitivescale.poc.bank.data;

/**
 * @author sumdwive
 *
 */
public interface BeneficiaryDAO {
	
	public long addBeneficiary(BeneficiaryTO beneficiar);
    public void deleteBeneficiary(long id);
    public List<BeneficiaryTO> getAllBeneficiaries();
    public BeneficiaryTO getBeneficiary(long id);   
    public List<BeneficiaryTO> getAllBeneficiaries(long customerPK);
}
