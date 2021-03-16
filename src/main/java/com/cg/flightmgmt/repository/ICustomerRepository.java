package com.cg.flightmgmt.repository;

import java.util.List;

import com.cg.flightmgmt.dto.Customer;


public interface ICustomerRepository {
	public Customer addCustomer(Customer cust);
	public Customer updateCustomer(Customer cust);
	public Customer removeCustomer(Customer cust);
	public Customer viewCustomer(Customer cust);

}
