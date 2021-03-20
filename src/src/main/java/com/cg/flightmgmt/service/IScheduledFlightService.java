package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;

public interface IScheduledFlightService {
	
	public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight);
	public ScheduledFlight viewFlightSchedule(int id);
	public ScheduledFlight removeFlightSchedule(int id);
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight);
	public List<ScheduledFlight> viewAllScheduledFlights();
//	public List<Schedule> viewAllScheduledFlights(LocalDateTime arrivaldate);
//	public List<ScheduledFlight> viewAllScheduledFlights(Date date1,Date date2);

}
