package com.cognitivescale.poc.bank.data;

import java.util.List;

import com.cognitivescale.poc.bank.data.rdb.Customer;

/**
 * @author sumdwive
 *
 */
public interface CustomerDAO {
	
	public long createCustomer(Customer customer);
    public Customer updateCustomer(Customer employee);
    public void deleteCustomer(long id);
    public List<Customer> getAllCustomers();
    public Customer getCustomer(long id);   
    public List<Customer> getAllCustomers(String customerName);
}
