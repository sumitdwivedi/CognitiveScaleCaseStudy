package com.cognitivescale.poc.bank.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;
import com.cognitivescale.poc.bank.data.BeneficiaryDAO;
import com.cognitivescale.poc.bank.data.rdb.Beneficiary;
import com.cognitivescale.poc.bank.data.rdb.Customer;
import com.cognitivescale.poc.bank.data.util.HibernateUtil;

public class BeneficiaryDAOImpl implements BeneficiaryDAO {
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long addBeneficiary(BeneficiaryTO beneficiaryTO) {
		Beneficiary beneficiary = new Beneficiary(beneficiaryTO.getCustomerAccountNum(), beneficiaryTO.getBeneficiaryAccountNumber(), beneficiaryTO.getIfcsCode(), beneficiaryTO.getNickName(), beneficiaryTO.getCustomerID(), 
				beneficiaryTO.getAccountName());
		return (Long)hibernateUtil.create(beneficiary);
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
		BeneficiaryTO BeneficiaryTO = getBeneficiaryTO(beneficiary);
		return BeneficiaryTO;
	}

	private BeneficiaryTO getBeneficiaryTO(Beneficiary beneficiary) {
		BeneficiaryTO BeneficiaryTO = new BeneficiaryTO(beneficiary.getId(), beneficiary.getCustomerAccountNum(), beneficiary.getBeneficiaryAccountNumber(), beneficiary.getIfcsCode(), beneficiary.getNickName(), beneficiary.getCustomerID(), 
				beneficiary.getAccountName());
		return BeneficiaryTO;
	}

	@Override
	public List<BeneficiaryTO> getAllBeneficiaries(long customerPK) {
		Customer Customer = hibernateUtil.fetchById(customerPK, Customer.class);
		List<Beneficiary> beneficiaryList = Customer.getBeneficiaries();
		List<BeneficiaryTO> beneficiaryTOList = new ArrayList<>();
		for(Beneficiary  beneficiary : beneficiaryList){
			BeneficiaryTO BeneficiaryTO = getBeneficiaryTO(beneficiary);
			beneficiaryTOList.add(BeneficiaryTO);
		}
		return beneficiaryTOList;
	}

}
