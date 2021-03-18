package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

public interface IFlightService {

	public Flight addFlight(Flight flight);
	public Flight viewFlight(BigInteger flightno) throws FlightNotFoundException;
	public Set<Flight> viewAllFlights();
	public Flight removeFlight(BigInteger flightno);
	//Flight removeFlight(Flight flight);
	public Flight updateFlight(Flight flight);
	
}
