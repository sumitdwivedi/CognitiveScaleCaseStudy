package com.cognitivescale.poc.bank.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognitivescale.poc.bank.business.CustomerService;
import com.cognitivescale.poc.bank.business.to.CustomerTO;
import com.cognitivescale.poc.bank.web.dto.CustomerDTO;

/**
 * @author sumdwive
 *
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
		CustomerTO customerTO = createCustomerTO(customer);
		long id = customerService.createCustomer(customerTO);
		customer.setId(id);
		Resource<CustomerDTO> resource = new Resource(customer);
	    resource.add(linkTo(methodOn(CustomerController.class).getCustomer(id)).withRel("customer.customerID"));
	    return resource;
	}
	
	private CustomerTO createCustomerTO(CustomerDTO customer) {
		CustomerTO customerTO = new CustomerTO(customer.getCustomerID(), customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getAddress(), customer.getCountry()
				, customer.getEmail(), customer.getSex(), customer.getContactNumber());
		return customerTO;
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Resource<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer) {
    	CustomerTO customerTO = createCustomerTO(customer);
    	long id = customer.getId();
		customerTO.setId(id);
    	customerService.updateCustomer(customerTO);
    	Resource<CustomerDTO> resource = new Resource(customer);
	    resource.add(linkTo(methodOn(CustomerController.class).getCustomer(id)).withRel("customer.customerID"));
	    return resource;
	}
	
	@RequestMapping(value = "/{customerID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public void deleteCustomer(@PathVariable(value = "customerID") long id) {
    	customerService.deleteCustomer(id);
	}
    public List<CustomerDTO> getAllCustomers() {
		return null;
	}
    
    @RequestMapping(value = "/{customerID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Resource<CustomerDTO> getCustomer(long id) {
    	CustomerTO customerTO = customerService.getCustomer(id);
    	CustomerDTO CustomerDTO = new CustomerDTO(customerTO.getId(), customerTO.getCustomerID(), customerTO.getFirstName(), customerTO.getLastName(), customerTO.getAge(), customerTO.getAddress()
    			, customerTO.getCountry(), customerTO.getEmail(), customerTO.getSex(), customerTO.getContactNumber());
		Resource<CustomerDTO> resource = new Resource(CustomerDTO);
	    resource.add(linkTo(methodOn(CustomerController.class).getCustomer(id)).withSelfRel());
	    return resource;
	}   
    public List<CustomerDTO> getAllCustomers(String customerName) {
		return null;
	}
    
}
