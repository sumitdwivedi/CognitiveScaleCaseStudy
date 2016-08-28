package com.cognitivescale.poc.bank.data;

import java.util.List;

import com.cognitivescale.poc.bank.business.to.CustomerTO;

/**
 * @author sumdwive
 *
 */
public interface CustomerDAO {
	
	public long createCustomer(CustomerTO customer);
    public CustomerTO updateCustomer(CustomerTO customer);
    public void deleteCustomer(long id);
    public List<CustomerTO> getAllCustomers();
    public CustomerTO getCustomer(long id);   
    public List<CustomerTO> getAllCustomers(String customerName);
}
