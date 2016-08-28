package com.cognitivescale.poc.bank.data.rdb;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sumdwive
 *
 */
@Entity
@Table(name = "customer")
public class Customer extends RDBBase{

	@Column(name = "customer_id")
	String customerID;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;
	@Column(name = "age")
	int age;
	@Column(name = "address")
	String address;
	@Column(name = "country")
	String country;
	@Column(name = "email")
	String email;
	@Column(name = "sex")
	String sex;
	@Column(name = "contact_number")
	int contactNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",
            targetEntity = Account.class)
 private Set<Account> accounts = new HashSet<Account>(0);
	
public Customer(){}
	
	public Customer(long id, String customerID, String firstName, String lastName, int age, String address,
			String country, String email, String sex, int contactNumber) {
		super();
		this.id = id;
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.country = country;
		this.email = email;
		this.sex = sex;
		this.contactNumber = contactNumber;
	}
	
	public Customer(String customerID, String firstName, String lastName, int age, String address,
			String country, String email, String sex, int contactNumber) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.country = country;
		this.email = email;
		this.sex = sex;
		this.contactNumber = contactNumber;
	}

	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
