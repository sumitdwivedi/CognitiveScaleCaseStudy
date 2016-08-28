package com.cognitivescale.poc.bank.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;
import com.cognitivescale.poc.bank.data.BeneficiaryDAO;
import com.cognitivescale.poc.bank.data.rdb.Beneficiary;
import com.cognitivescale.poc.bank.data.util.HibernateUtil;

public class BeneficiaryDAOImpl implements BeneficiaryDAO {
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long addBeneficiary(BeneficiaryTO beneficiar) {
		Beneficiary Beneficiary = new Beneficiary(beneficiar.getAccountNum(), beneficiar.getIfcsCode(), beneficiar.getNickName(), beneficiar.getCustomerID(), beneficiar.getAccountName());
		return (Long)hibernateUtil.create(Beneficiary);
	}

	@Override
	public void deleteBeneficiary(long id) {
		hibernateUtil.delete(id, Beneficiary.class);

	}

	@Override
	public List<BeneficiaryTO> getAllBeneficiaries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeneficiaryTO getBeneficiary(long id) {
		Beneficiary beneficiary = hibernateUtil.fetchById(id, Beneficiary.class);
		BeneficiaryTO BeneficiaryTO = new BeneficiaryTO(beneficiary.getId(), beneficiary.getAccountNum(), beneficiary.getIfcsCode(), beneficiary.getNickName(), beneficiary.getCustomerID(), 
				beneficiary.getAccountName());
		return BeneficiaryTO;
	}

	@Override
	public List<BeneficiaryTO> getAllBeneficiaries(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
