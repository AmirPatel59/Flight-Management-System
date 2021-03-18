package com.cg.flightmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Customer;
import com.cg.flightmgmt.service.ICustomerService;

@RestController
@RequestMapping("fms/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer cust=customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateEmployee(@RequestBody Customer customer) {
		Customer customer1 = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}
//	@GetMapping("/viewCustomer")
//	public ResponseEntity<Customer> viewCustomer(){
//		Customer customer=customerService.viewCustomer();
//	}
	
}