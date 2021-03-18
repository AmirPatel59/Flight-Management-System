package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.service.IFlightService;


@RestController
//@RequestMapping("")
public class FlightController {

	@Autowired
	IFlightService flightservice;
	
	@PostMapping("/addFlight")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
		Flight flightData=flightservice.addFlight(flight);
		return new ResponseEntity<Flight>(flightData, HttpStatus.OK);
	}
	
	@GetMapping("/viewFlight/{id}")
	public ResponseEntity<Flight> viewFlight(@PathVariable BigInteger id) throws FlightNotFoundException{
		Flight flight=flightservice.viewFlight(id);
		if(flight==null) {
			throw new FlightNotFoundException("No Flight is available with the given FlightId " + id);
		}
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);	
	}
	
	@GetMapping("viewAllFlights")
	public ResponseEntity<Set<Flight>> viewAllFlights(){
		Set<Flight> flightList=flightservice.viewAllFlights();
		return new ResponseEntity<Set<Flight>>(flightList,HttpStatus.OK);	
	}
	
	@DeleteMapping("/removeFlight/{id}")
	  public ResponseEntity<Flight> removeFlight(@PathVariable BigInteger id){
	 Flight flightData=flightservice.removeFlight(id);
	 return new ResponseEntity<Flight>(flightData,HttpStatus.OK);
	}
	 
	@PutMapping("/updateFlight")
	public ResponseEntity<Flight> updateEmployee(@RequestBody Flight flight) {
		Flight flightData = flightservice.updateFlight(flight);
		return new ResponseEntity<Flight>(flightData, HttpStatus.OK);
	}
}
