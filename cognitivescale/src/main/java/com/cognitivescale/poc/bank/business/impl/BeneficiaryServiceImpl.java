package com.cognitivescale.poc.bank.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognitivescale.poc.bank.business.BeneficiaryService;
import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;
import com.cognitivescale.poc.bank.data.BeneficiaryDAO;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {
	
	@Autowired
    private BeneficiaryDAO beneficiaryDAO;

	@Override
	public long addBeneficiary(BeneficiaryTO beneficiar) {
		// TODO Auto-generated method stub
		return beneficiaryDAO.addBeneficiary(beneficiar);
	}

	@Override
	public void deleteBeneficiary(long id) {
		beneficiaryDAO.deleteBeneficiary(id);

	}

	@Override
	public List<BeneficiaryTO> getAllBeneficiaries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeneficiaryTO getBeneficiary(long id) {
		return beneficiaryDAO.getBeneficiary(id);
	}

	@Override
	public List<BeneficiaryTO> getAllBeneficiaries(long customerPK) {
		return beneficiaryDAO.getAllBeneficiaries(customerPK);
	}

}
