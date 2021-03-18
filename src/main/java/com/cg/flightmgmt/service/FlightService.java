package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.IFlightRepository;

@Service
@Transactional
public class FlightService implements IFlightService{
	
	@Autowired
    IFlightRepository repository;
	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		Flight flightData=repository.save(flight);
		return flightData;
	}

	@Override
	public Flight viewFlight(BigInteger flightno) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		return repository.findById(flightno).orElse(null);	
	}

	@Override
	public Set<Flight> viewAllFlights() {
		// TODO Auto-generated method stub
	 Set<Flight> set=new HashSet<Flight>();
	 return set;
	}

	@Override
	public Flight removeFlight(BigInteger flightno) {
	  Flight flight=new Flight();
	return  flight;
	 }
	
	/*@Override
	public Flight removeFlight(Flight flight) {
		// TODO Auto-generated method stub
		BigInteger flightno=flight.getFlightId();
		repository.deleteById(flightno);
		return flight;
	}*/
	
	

	@Override
	public Flight updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		return repository.save(flight);
	}

	
	

}
