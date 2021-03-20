package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
@Repository
public interface IFlightRepository extends JpaRepository<Flight, BigInteger>{
//
//	public Flight addFlight(Flight flight);
//	public Flight viewFlight(BigInteger flightno) throws FlightNotFoundException;
//	public Set<Flight> viewAllFlights();
//	public Flight removeFlight(BigInteger flightno);
//	public Flight updateFlight(Flight flight);
}
