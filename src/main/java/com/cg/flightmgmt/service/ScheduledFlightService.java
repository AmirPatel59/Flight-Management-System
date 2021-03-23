package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightScheduleNotFoundException;
import com.cg.flightmgmt.repository.IFlightRepository;
import com.cg.flightmgmt.repository.IScheduleRepository;
import com.cg.flightmgmt.repository.IScheduledFlightRepository;

@Service
@Transactional
public class ScheduledFlightService implements IScheduledFlightService {

	@Autowired
	IScheduledFlightRepository scheduleflightrepository;
	
	
	
	@Override
	public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight) {
		// TODO Auto-generated method stub
		scheduleflightrepository.save(scheduledFlight);
		return scheduledFlight;
	}
	
	
	@Override
	public ScheduledFlight viewFlightSchedule(int id) throws FlightScheduleNotFoundException{
		// TODO Auto-generated method stub
		
		return scheduleflightrepository.findById(id).orElse(null);
	}
	
	
	@Override
	public ScheduledFlight removeFlightSchedule(int id) throws FlightScheduleNotFoundException{
		// TODO Auto-generated method stub
		
		ScheduledFlight f=scheduleflightrepository.findById(id).orElse(null); 
		if(f==null) {
			return null;
		}

		f.setSchedule(null);
		f.setFlight(null);
		scheduleflightrepository.deleteById(id);
		
		return f;
	}
	
	
	@Override
	public List<ScheduledFlight> viewAllScheduledFlights() {
		// TODO Auto-generated method stub
		List<ScheduledFlight> list=scheduleflightrepository.findAll();
		return list;
	}
	
	
	@Override
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDateTime arrivaldate) {
		System.out.println(arrivaldate);
		List<ScheduledFlight> list=scheduleflightrepository.findAllBySchedule(arrivaldate);
		return list;
	}
	
	
	@Override
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight) throws FlightScheduleNotFoundException{
		// TODO Auto-generated method stub
		int id=flight.getScheduleFlightId();
		ScheduledFlight flightData=scheduleflightrepository.findById(id).orElse(null);
		if(flightData==null) {
			return null;
		}
		return scheduleflightrepository.save(flight);
	}
		

}
