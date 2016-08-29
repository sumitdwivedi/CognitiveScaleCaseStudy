package com.cognitivescale.poc.bank.business.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognitivescale.poc.bank.business.UserService;
import com.cognitivescale.poc.bank.business.to.LoginTO;
import com.cognitivescale.poc.bank.data.LoginDAO;
 
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private LoginDAO dao;
 
    public LoginTO findByUserName(String userName) {
        return dao.findByUserName(userName);
    }
 
}