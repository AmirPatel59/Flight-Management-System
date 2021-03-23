package com.cg.flightmgmt.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.FlightScheduleNotFoundException;

import com.cg.flightmgmt.repository.IScheduledFlightRepository;
import com.cg.flightmgmt.service.IScheduledFlightService;




@SpringBootTest
public class ScheduledFlightTest {

	@Autowired
	IScheduledFlightService service;
	
	@MockBean
	IScheduledFlightRepository repository;
	
	@Test
	public void addScheduledFlightValidTest() {
		ScheduledFlight scheduledFlight = new ScheduledFlight();
		Mockito.when(repository.save(scheduledFlight)).thenReturn(scheduledFlight);
		Assertions.assertEquals(scheduledFlight, service.addFlightSchedule(scheduledFlight));
	}
	
	@Test
	public void updateScheduledFlightValidTest() throws FlightScheduleNotFoundException {
		ScheduledFlight updateScheduledFlight = new ScheduledFlight();
		updateScheduledFlight.setScheduleFlightId(100);
		Mockito.when(repository.findById(100)).thenReturn(Optional.of(updateScheduledFlight));
		
		Mockito.when(repository.save(updateScheduledFlight)).thenReturn(updateScheduledFlight);
		Assertions.assertDoesNotThrow(() -> service.updateFlightSchedule(updateScheduledFlight));
	}
	
//	@Test
//	public void updateScheduledFlightInValidTest() throws FlightScheduleNotFoundException {
//		ScheduledFlight updateScheduledFlight = new ScheduledFlight();
//		updateScheduledFlight.setScheduleFlightId(100);
//		Mockito.when(repository.findById(100)).thenReturn(Optional.empty());
//		FlightScheduleNotFoundException fs = Assertions.assertThrows(FlightScheduleNotFoundException.class,() -> service.updateFlightSchedule(updateScheduledFlight));
//		Assertions.assertEquals("Flight Schedule not Found", fs.getMessage());
//	}
//	
	@Test
	public void removeUserValidTest() {
		ScheduledFlight ScheduledFlight = new ScheduledFlight();
		ScheduledFlight.setScheduleFlightId(100);
		Mockito.when(repository.findById(100)).thenReturn(Optional.of(ScheduledFlight));
		Assertions.assertDoesNotThrow(() -> service.removeFlightSchedule(100));
	}
	
//	@Test
//	public void removeUserInValidTest() throws FlightScheduleNotFoundException{
//		ScheduledFlight scheduledFlight = new ScheduledFlight();
//		scheduledFlight.setScheduleFlightId(100);
//		Mockito.when(repository.findById(100)).thenReturn(Optional.empty());
//		FlightScheduleNotFoundException fs = Assertions.assertThrows(FlightScheduleNotFoundException.class,() -> service.removeFlightSchedule(100));
//		Assertions.assertEquals("Flight Schedule not Found", fs.getMessage());
//	}
//	
	
	@Test
	public void testviewFlight() throws FlightScheduleNotFoundException{
		ScheduledFlight scheduledflight=getScheduleFlight();
		service.viewFlightSchedule(scheduledflight.getScheduleFlightId());
		verify(repository,times(1)).findById(scheduledflight.getScheduleFlightId());
	}
	
	private ScheduledFlight getScheduleFlight() {
		// TODO Auto-generated method stub
		ScheduledFlight sf=new ScheduledFlight();
		equals(sf.getScheduleFlightId());
		sf.setAvailableSeats(160);
		sf.setFares(5000);
		Flight flight=new Flight();
		flight.setCarrierName("AirIndia");
		flight.setFlightId(BigInteger.valueOf(100));
		flight.setFlightModel("cargo");
		flight.setSeatCapacity(180);
		sf.setFlight(flight);
		Schedule schedule =new Schedule();
		schedule.setAirrivalTime(LocalDateTime.of(2021,03,22,17,52,50,138));
		schedule.setDepartureTime(LocalDateTime.of(2021,03,22,22,52,50,138));
		schedule.setScheduleId(50);
		Airport sAirport=new Airport();
		Airport dAirport=new Airport();
		sAirport.setAirportid(50);
		sAirport.setAirportLocation("Mumbai");
		sAirport.setAirportName("CST");
		dAirport.setAirportid(80);
		dAirport.setAirportLocation("Delhi");
		dAirport.setAirportName("PJN");
		schedule.setSourceAirport(sAirport);
		schedule.setDestinationAirport(dAirport);
		sf.setSchedule(schedule);		
		return sf;
	}

	@Test
	public void testviewAllFlightSchedule() {
		ScheduledFlight scheduleFlight=getScheduleFlight();
		service.viewAllScheduledFlights();
		verify(repository,times(1)).findAll();		
	}
	@Test
	public void testviewAllFlightScheduleByDate() {
		ScheduledFlight scheduleFlight=getScheduleFlight();
		service.viewAllScheduledFlights();
		verify(repository,times(1)).findAll();		
	}
}
