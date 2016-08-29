package com.cognitivescale.poc.bank.data.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognitivescale.poc.bank.business.to.LoginTO;
import com.cognitivescale.poc.bank.data.LoginDAO;
import com.cognitivescale.poc.bank.data.rdb.Login;

public class LoginDAOImpl implements LoginDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public LoginTO findByUserName(String userName) {
		Login login = (Login)sessionFactory.getCurrentSession().createSQLQuery("from Login login where login.username="+userName).uniqueResult();
		LoginTO loginTO = new LoginTO(login.getUserName(), login.getPassword(), login.getUserType(), login.getQuestion(), login.getAns());
		return loginTO;
	}

}
