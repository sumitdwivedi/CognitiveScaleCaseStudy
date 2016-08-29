package com.cognitivescale.poc.bank.data;

import com.cognitivescale.poc.bank.business.to.LoginTO;

public interface LoginDAO {

	LoginTO findByUserName(String userName);
}
