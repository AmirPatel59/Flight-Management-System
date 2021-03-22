package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightScheduleNotFoundException;

public interface IScheduledFlightService {
	
	public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight);
	public ScheduledFlight viewFlightSchedule(int id) throws FlightScheduleNotFoundException;
	public ScheduledFlight removeFlightSchedule(int id) throws FlightScheduleNotFoundException;
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight) throws FlightScheduleNotFoundException;
	public List<ScheduledFlight> viewAllScheduledFlights();
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDateTime arrivaldate);
	
}
