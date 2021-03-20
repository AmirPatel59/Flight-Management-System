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
	
//	@Autowired
//	IScheduleRepository repository;
//	
//	@Autowired
//	IFlightRepository flrepository;
//	
	
	
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
//		ScheduledFlight fl=new ScheduledFlight(id);
//		Flight f=fl.getFlight();
//		Schedule s=fl.getSchedule();
//		FlightService s1=new FlightService();
//		s1.removeFlight(f.getFlightId());
//		repository.deleteById(s.getScheduleId());
//		ScheduledFlight s=new ScheduledFlight();
//		s.setSchedule(null);
//		s.setFlight(null);
		
		ScheduledFlight f=scheduleflightrepository.findById(id).orElse(null); 
		if(f==null) {
			return null;
		}
//		Flight f1=f.getFlight();
//		FlightService s1=new FlightService();
//		flrepository.deleteById(f1.getFlightId());
//		Schedule s2=f.getSchedule();
		f.setSchedule(null);
		f.setFlight(null);
//		repository.deleteById(s2.getScheduleId());
		scheduleflightrepository.deleteById(id);
		
		return f;
	}
	@Override
	public List<ScheduledFlight> viewAllScheduledFlights() {
		// TODO Auto-generated method stub
		List<ScheduledFlight> list=scheduleflightrepository.findAll();
		return list;
	}
//	@Override
//	public List<Schedule> viewAllScheduledFlights(LocalDateTime arrivaldate) {
//		ScheduledFlight sc;
//		Schedule sched;
//		List<Schedule> list=scheduleflightrepository.viewByArrivalDate(arrivaldate);
//		return list;
//	}
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
