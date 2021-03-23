package com.cg.flightmgmt.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue
	//private String customerId;
	private int customerId;
	
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String address;
	
	//constructors for Customer
	public Customer() {
		super();
	}
	
	
	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String email,
			String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
	}


	public Customer(String firstName, String lastName, String mobileNumber, String email, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
	}


	//Getters Setters for Customers
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	// to string methods
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + "]";
	}
	
	
	
	
}
