package com.cognitivescale.poc.bank.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognitivescale.poc.bank.business.AccountService;
import com.cognitivescale.poc.bank.business.BeneficiaryService;
import com.cognitivescale.poc.bank.business.TransactionSerivce;
import com.cognitivescale.poc.bank.business.to.AccountTO;
import com.cognitivescale.poc.bank.business.to.BeneficiaryTO;
import com.cognitivescale.poc.bank.business.to.TransactionTO;
import com.cognitivescale.poc.bank.data.BeneficiaryDAO;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {
	
	@Autowired
    private BeneficiaryDAO beneficiaryDAO;
	
	@Autowired
    private TransactionSerivce transactionSerivce;
	
	@Autowired
    private AccountService accountService;

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

	@Override
	public synchronized TransactionTO trnasferFund(long accountID, long beneficiaryID, double amount, String remarks) {
		TransactionTO transactionTO = null;
		AccountTO srcAccountTO = accountService.getAccount(accountID);
		BeneficiaryTO beneficiaryTO = getBeneficiary(beneficiaryID);
		AccountTO destAccountTO = accountService.getAccount(Long.parseLong(beneficiaryTO.getAccountNum()));
		if(srcAccountTO.getBalance()>= amount){
			double currentBalance = srcAccountTO.getBalance()-amount;
			srcAccountTO.setBalance(currentBalance);
			destAccountTO.setBalance(destAccountTO.getBalance()+amount);
			accountService.updateAccount(srcAccountTO);
			accountService.updateAccount(destAccountTO);
			Date date = new Date();
			transactionTO = new TransactionTO(""+System.currentTimeMillis(), "Debit", "OnLine Transaction", date.toString(), "", destAccountTO.getAccountNum(), amount, currentBalance, remarks, srcAccountTO.getAccountNum());
			transactionSerivce.createTransaction(transactionTO);
		} else {
			
		}
		return transactionTO;
	}

}
