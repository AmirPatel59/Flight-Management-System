package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;

public interface IScheduledFlightService {
	
	public Flight addFlightSchedule(Flight flight);
	public Flight viewFlightSchedule(BigInteger flightno);
	public Flight removeFlightSchedule(BigInteger flightno);
	public Flight updateFlightSchedule(ScheduledFlight flight);
	public List<ScheduledFlight> viewAllScheduledFlights();
	public List<ScheduledFlight> viewAllScheduledFlights(Date arrivaldate);
	public List<ScheduledFlight> viewAllScheduledFlights(Date date1,Date date2);

}
