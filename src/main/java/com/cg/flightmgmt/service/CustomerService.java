package com.cg.flightmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Customer;
import com.cg.flightmgmt.repository.ICustomerRepository;
@Service
@Transactional
public class CustomerService implements ICustomerService{

	@Autowired
	ICustomerRepository repository;
	
	@Override
	public Customer addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		Customer customer=repository.save(cust);		
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		Customer customer=repository.save(cust);
		return cust;
	}

	@Override
	public Customer removeCustomer(Customer cust) {
		// TODO Auto-generated method stub
		repository.delete(cust);
		return cust;
	}

	@Override
	public Customer viewCustomer(Customer cust) {
		// TODO Auto-generated method stub
		int id=cust.getCustomerId();
		Customer customer=repository.findById(id).orElse(null);
		return customer;
	}


}
