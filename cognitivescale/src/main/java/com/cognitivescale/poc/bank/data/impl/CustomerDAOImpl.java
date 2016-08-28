package com.cognitivescale.poc.bank.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognitivescale.poc.bank.business.to.CustomerTO;
import com.cognitivescale.poc.bank.data.CustomerDAO;
import com.cognitivescale.poc.bank.data.rdb.Customer;
import com.cognitivescale.poc.bank.data.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
    private HibernateUtil hibernateUtil;
	
	@Override
	public long createCustomer(CustomerTO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CustomerTO updateCustomer(CustomerTO customerTO) {
		Customer customer = new Customer(customerTO.getCustomerID(), customerTO.getFirstName(), customerTO.getLastName(), customerTO.getAge(), customerTO.getAddress(), customerTO.getCountry(), 
				customerTO.getEmail(), customerTO.getSex(), customerTO.getContactNumber());
		hibernateUtil.create(customer);
		customerTO.setId(customer.getId());
		return customerTO;
	}

	@Override
	public void deleteCustomer(long id) {
		hibernateUtil.delete(id, Customer.class);

	}

	@Override
	public List<CustomerTO> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerTO getCustomer(long id) {
		Customer customer = hibernateUtil.fetchById(id, Customer.class);
		CustomerTO CustomerTO = new CustomerTO(customer.getId(), customer.getCustomerID(), customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getAddress(), 
				customer.getCountry(), customer.getEmail(), customer.getSex(), customer.getContactNumber());
		return CustomerTO;
	}

	@Override
	public List<CustomerTO> getAllCustomers(String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
