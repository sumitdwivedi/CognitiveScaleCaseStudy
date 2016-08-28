package com.cognitivescale.poc.bank.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognitivescale.poc.bank.business.CustomerService;
import com.cognitivescale.poc.bank.business.to.CustomerTO;
import com.cognitivescale.poc.bank.data.CustomerDAO;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
    private CustomerDAO customerDAO;
	
	@Override
	public long createCustomer(CustomerTO customer) {
		return customerDAO.createCustomer(customer);
	}

	@Override
	public CustomerTO updateCustomer(CustomerTO customer) {
		// TODO Auto-generated method stub
		return customerDAO.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(long id) {
		customerDAO.deleteCustomer(id);

	}

	@Override
	public List<CustomerTO> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerTO getCustomer(long id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}

	@Override
	public List<CustomerTO> getAllCustomers(String customerName) {
		// TODO Auto-generated method stub
		return customerDAO.getAllCustomers(customerName);
	}

}
