package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class FlightService implements IFlightService {

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
		Set<Flight> flight=new HashSet<Flight>();
		List<Flight> flightList=new ArrayList<Flight>(flight);
		repository.findAll().forEach(flight1->flight.add(flight1));
		return flight;
	}

	@Override
	public Flight removeFlight(BigInteger flightno) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		Optional<Flight> findById=repository.findById(flightno);
		if(findById.isPresent()) {
		Flight flight=new Flight();
		repository.deleteById(flightno);
		return flight;}
		else
			throw new FlightNotFoundException("Flight with Id: "+ flightno +" not exists");		
	}

	@Override
	public Flight updateFlight(Flight flight) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		Optional<Flight> findById=repository.findById(flight.getFlightId());
		if(findById.isPresent()) {
			repository.save(flight);
		}else
	throw new FlightNotFoundException("Flight with Id: "+flight.getFlightId() +" not exists");
		return flight;
	}

}
