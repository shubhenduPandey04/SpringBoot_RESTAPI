package com.ofss;
// Model layer
public class Customer {
	int id;
	String firstName; // FIRST_NAME
	String lastName; // LAST_NAME
	long phoneNumber; // PHONE_NUMBER
	String emailId; // EMAIL_ID
	
	// default constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public Customer(int id, String firstName, String lastName, long phoneNumber, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	// Generate the required setter and getter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
