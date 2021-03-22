package com.cg.flightmgmt.test;



import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigInteger;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.IFlightBookingRepository;
import com.cg.flightmgmt.service.IFlightBookingService;
import com.google.common.base.Optional;

@SpringBootTest
public class BookingTest {
	@Autowired
	private IFlightBookingService bookingService;
	@MockBean
	IFlightBookingRepository bookingrepository;
	
	static LocalDate date = LocalDate.now();
	 
	 	
	
	@Test
	public void testbookingId() {
		Booking Id=new Booking();
//		Id.setBookingId(101);
		Id.setBookingDate(LocalDate.of(2020,9,18));
		Id.setTicketCost(500);
		Id.setNoOfPassangers(5);
		Mockito.when(bookingrepository.save(Id)).thenReturn(Id);
		assertSame(bookingService.addBooking(Id),Id);
	}
	@Test
	public void testupdateBooking() throws BookingNotFoundException {
		Booking updateBooking=new Booking();
		equals(updateBooking.getBookingId());
//		updateBooking.setBookingId(101);
		updateBooking.setBookingDate(LocalDate.of(2020,9,18));
		updateBooking.setTicketCost(500);
		updateBooking.setNoOfPassangers(5);
		Mockito.when(bookingrepository.save(updateBooking)).thenReturn(updateBooking);
		assertSame(bookingService.addBooking(updateBooking),updateBooking);
	
	}
	@Test
	public void testcancelBooking() throws BookingNotFoundException {
		Booking booking=new Booking();
		equals(booking.getBookingId());
		BigInteger bookingid = null;
		booking.setBookingId(BigInteger.valueOf(100));
		booking.setBookingDate(LocalDate.of(2020,9,10));
		booking.setTicketCost(500);
		booking.setNoOfPassangers(4);
		Mockito.when(bookingrepository.save(booking)).thenReturn(booking);
		Assertions.assertDoesNotThrow(()->bookingService.cancelBooking(BigInteger.valueOf(100)));

	}
	
	@Test
	public void testviewBooking() throws BookingNotFoundException {
		Booking booking=new Booking();
		equals(booking.getBookingId());
//		booking.setBookingId(102);
		booking.setBookingDate(LocalDate.of(2020,9,18));
		booking.setTicketCost(500);
		booking.setNoOfPassangers(2);
		Mockito.when(bookingrepository.save(booking)).thenReturn(booking);
		assertSame(bookingService.addBooking(booking),booking);

	}

}


