package com.cg.flightmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.exception.FlightScheduleNotFoundException;
import com.cg.flightmgmt.service.IScheduledFlightService;

import javassist.expr.NewExpr;

@RestController
@RequestMapping("/fms/controller/scheduledFlightController")
public class ScheduledFlightController {

	@Autowired
	IScheduledFlightService service;
	
	@PostMapping("/addScheduledFlight")
	public ResponseEntity<ScheduledFlight> addScheduledFlight(@Valid @RequestBody ScheduledFlight scheduledFlight)
	{
		ScheduledFlight scheduledFlightData=service.addFlightSchedule(scheduledFlight);
		return new ResponseEntity<ScheduledFlight>(scheduledFlightData,HttpStatus.OK);
	}
	
	@GetMapping("/viewScheduledFlightById/{id}")
	public ResponseEntity<ScheduledFlight> viewScheduledFlightById(@PathVariable int id) throws FlightScheduleNotFoundException{
		ScheduledFlight scheduledFlightData=service.viewFlightSchedule(id);
		if(scheduledFlightData==null) {
			throw new FlightScheduleNotFoundException("Flight Schedule not Found");
		}
		return new ResponseEntity<ScheduledFlight>(scheduledFlightData,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteScheduledFlightById/{id}")
	public ResponseEntity<ScheduledFlight> deleteScheduledFlightById(@PathVariable int id) throws FlightScheduleNotFoundException{
			ScheduledFlight scheduleFlightData=service.removeFlightSchedule(id);
			if(scheduleFlightData==null) {
				throw new FlightScheduleNotFoundException("Flight Schedule not Found");
			}
			scheduleFlightData=null;
		return new ResponseEntity<ScheduledFlight>(scheduleFlightData,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllScheduledFlight")
	public ResponseEntity<List<ScheduledFlight>> viewAllScheduledFlight(){
		List<ScheduledFlight> scheduledFlightData=service.viewAllScheduledFlights();
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightData,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateScheduledFlight")
	public ResponseEntity<ScheduledFlight> updateScheduledFlight(@Valid @RequestBody ScheduledFlight scheduledFlight) throws FlightScheduleNotFoundException{
		ScheduledFlight scheduledFlightData=service.updateFlightSchedule(scheduledFlight);
		if(scheduledFlightData==null) {
			throw new FlightScheduleNotFoundException("Flight Schedule not Found");
		}
		return new ResponseEntity<ScheduledFlight>(scheduledFlightData,HttpStatus.OK);
	}
	
	
//	@GetMapping("/viewAllScheduled")
//	public ResponseEntity<List<ScheduledFlight>> viewAllScheduled(){
//		List<ScheduledFlight> scheduledFlightData=service.viewAllScheduledFlights(null);
//		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightData,HttpStatus.OK);
//	}
	
	
}
