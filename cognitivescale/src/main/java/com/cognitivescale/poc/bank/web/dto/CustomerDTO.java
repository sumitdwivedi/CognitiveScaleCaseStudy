package com.cognitivescale.poc.bank.web.dto;

public class CustomerDTO {

	long id;
	String customerID;
	String firstName;
	String lastName;
	int age;
	String address;
	String country;
	String email;
	String sex;
	int contactNumber;
	
	public CustomerDTO(){}
	
	public CustomerDTO(long id, String customerID, String firstName, String lastName, int age, String address,
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
	
	public CustomerDTO(String customerID, String firstName, String lastName, int age, String address,
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
}
