package com.cognitivescale.poc.bank.data.rdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login extends RDBBase{

	@Column(name="user_name")
	String userName;
	@Column(name="user_password")
	String password;
	@Column(name="user_type")
	String userType;
	@Column(name="question")
	String question;
	@Column(name="ans")
	String ans;
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
