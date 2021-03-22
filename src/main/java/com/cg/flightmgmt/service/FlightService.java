package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    IFlightRepository flightrepository;
	
	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		Flight flightData=flightrepository.save(flight);
		return flightData;
	}

	@Override
	public Flight viewFlight(BigInteger flightno) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		return flightrepository.findById(flightno).orElse(null);		
	}

	@Override
	public Set<Flight> viewAllFlights() {
		// TODO Auto-generated method stub
		Set<Flight> flight=new HashSet<Flight>();
		List<Flight> flightList=new ArrayList<Flight>(flight);
		flightrepository.findAll().forEach(flight1->flight.add(flight1));
		return flight;
	}

	@Override
	public Flight removeFlight(BigInteger flightno) throws FlightNotFoundException {
		// TODO Auto-generated method stub
	Flight flight=flightrepository.findById(flightno).orElse(null);
		if(flight==null) {
		return null;}
		else
		{
			flightrepository.deleteById(flightno);
			return flight;
		}	
	}

	@Override
	public Flight updateFlight(Flight flight) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		BigInteger flightId=flight.getFlightId();
		Flight flight1=flightrepository.findById(flightId).orElse(null);
		if(flight1==null) {
			return null;
		}
		else
		{
			Flight flightData=flightrepository.save(flight);
			return flightData;
		}
		
	}
	
}
