package com.cg.flightmgmt.test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.IPassengerRepository;
import com.cg.flightmgmt.service.IPassengerService;

@SpringBootTest
class PassengerTest {
	
		@Autowired
		private IPassengerService passengerservice;
		@MockBean
		IPassengerRepository passengerrepository;
		@Test
		private Passenger getPassenger() {
			Passenger passenger=new Passenger();
			equals(passenger.getPnrNumber());
			passenger.setPassengerName("Abhishek");
			passenger.setAge(20);
			passenger.getPassengerUIN();
			passenger.setLuggage(213.9);
			return passenger;
		}
		
	

		@Test
		public void testviewPassenger() throws FlightNotFoundException{
			Passenger passenger=getPassenger();
			passengerservice.viewPassenger(passenger.getPnrNumber());
			verify(passengerrepository,times(1)).findById(passenger.getPnrNumber());
		}
}
