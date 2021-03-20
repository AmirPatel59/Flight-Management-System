package com.cg.flightmgmt.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.service.IPassengerService;

@RestController
@RequestMapping("/fms/controller/passengerController")
public class PassengerController {
 
	@Autowired
	IPassengerService service;
	
	@PostMapping("/addPassenger")
	public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
		Passenger passengerData=service.addPassenger(passenger);
		return new ResponseEntity<Passenger>(passengerData,HttpStatus.OK);
	}
	
	@GetMapping("/getPassengerByid/{id}")
	public ResponseEntity<Passenger> getPassengerByid(@PathVariable int id){
		Passenger passengerData=service.viewPassenger(id);
		return new ResponseEntity<Passenger>(passengerData,HttpStatus.OK);
	}
	
}
