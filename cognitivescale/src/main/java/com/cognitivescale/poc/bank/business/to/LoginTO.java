package com.cognitivescale.poc.bank.business.to;

import javax.persistence.Column;

public class LoginTO {

	String userName;
	String password;
	String userType;
	String question;
	String ans;
	public LoginTO(String userName, String password, String userType, String question, String ans) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.question = question;
		this.ans = ans;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
}
