package com.cognitivescale.poc.bank.business;
import com.cognitivescale.poc.bank.business.to.LoginTO;
 
public interface UserService {
 
    LoginTO findByUserName(String userName);
     
     
}