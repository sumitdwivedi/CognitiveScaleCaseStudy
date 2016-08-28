package com.cognitivescale.poc.bank.data;

import java.util.List;

import com.cognitivescale.poc.bank.data.rdb.Beneficiary;

//oracle.zoom.us/j/147217617?pwd=CKL7RQT%2Fz2c%3Dpackage com.cognitivescale.poc.bank.data;

/**
 * @author sumdwive
 *
 */
public interface BeneficiaryDAO {
	
	public long addBeneficiary(Beneficiary beneficiar);
    public void deleteBeneficiary(long id);
    public List<Beneficiary> getAllBeneficiaries();
    public Beneficiary getBeneficiary(long id);   
    public List<Beneficiary> getAllBeneficiaries(long customerID);
}
