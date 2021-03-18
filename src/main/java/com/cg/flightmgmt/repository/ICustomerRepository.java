package com.cg.flightmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//	public Customer addCustomer(Customer cust);
//	public Customer updateCustomer(Customer cust);
//	public Customer removeCustomer(Customer cust);
//	public Customer viewCustomer(Customer cust);

}
