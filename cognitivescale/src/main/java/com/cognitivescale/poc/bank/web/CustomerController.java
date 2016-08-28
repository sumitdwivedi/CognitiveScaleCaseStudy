package com.cognitivescale.poc.bank.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cognitivescale.poc.bank.business.CustomerService;
import com.cognitivescale.poc.bank.business.to.CustomerTO;
import com.cognitivescale.poc.bank.web.dto.CustomerDTO;

/**
 * @author sumdwive
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;
	
	public long createCustomer(CustomerDTO customer) {
		CustomerTO customerTO = createCustomerTO(customer);
		return customerService.createCustomer(customerTO);
	}
	private CustomerTO createCustomerTO(CustomerDTO customer) {
		CustomerTO customerTO = new CustomerTO(customer.getCustomerID(), customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getAddress(), customer.getCountry()
				, customer.getEmail(), customer.getSex(), customer.getContactNumber());
		return customerTO;
	}
    public CustomerDTO updateCustomer(CustomerDTO customer) {
    	CustomerTO customerTO = createCustomerTO(customer);
    	customerTO.setId(customer.getId());
    	customerService.updateCustomer(customerTO);
		return customer;
	}
    public void deleteCustomer(long id) {
    	customerService.deleteCustomer(id);
	}
    public List<CustomerDTO> getAllCustomers() {
		return null;
	}
    public CustomerDTO getCustomer(long id) {
    	CustomerTO customerTO = customerService.getCustomer(id);
    	CustomerDTO CustomerDTO = new CustomerDTO(customerTO.getId(), customerTO.getCustomerID(), customerTO.getFirstName(), customerTO.getLastName(), customerTO.getAge(), customerTO.getAddress()
    			, customerTO.getCountry(), customerTO.getEmail(), customerTO.getSex(), customerTO.getContactNumber());
		return CustomerDTO;
	}   
    public List<CustomerDTO> getAllCustomers(String customerName) {
		return null;
	}
}
