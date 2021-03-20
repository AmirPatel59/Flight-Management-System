package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.IFlightBookingRepository;
import com.cg.flightmgmt.repository.IFlightRepository;
@Service
@Transactional
public class FlightBookingService implements IFlightBookingService {

	@Autowired
	IFlightBookingRepository bookingRepository;
	@Autowired
	IFlightRepository flrepository;
	
	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		Booking bookingData=bookingRepository.save(booking);
		return bookingData;
	}
	@Override
	public Booking viewBooking(BigInteger bookingid) throws BookingNotFoundException {
		return bookingRepository.findById(bookingid).orElse(null);
		
	}
	@Override
	public Booking cancelBooking(BigInteger bookingid) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		Booking booking=bookingRepository.findById(bookingid).orElse(null);
		if(booking==null) {
			return null;
		}
		booking.setPassengerList(null);
		booking.setScheduledFlight(null);
		bookingRepository.deleteById(bookingid);
		return booking;
	}
	@Override
	public Booking updateBooking(Booking booking) throws BookingNotFoundException{
		// TODO Auto-generated method stub
		BigInteger bookingid=booking.getBookingId();
		booking=bookingRepository.findById(bookingid).orElse(null);
		if(booking==null) {
			return null;
		}
		Booking bookingData=bookingRepository.save(booking);
		return bookingData;
		
	}
	@Override
	public List<Booking> viewBookingList(LocalDate bookingdate) {
		// TODO Auto-generated method stub
		List<Booking> list=bookingRepository.viewBookingList(bookingdate);
		return list;
	}
//	@Override
//	public List<Booking> viewBookingList(BigInteger flightid) {
//		// TODO Auto-generated method stub
////		ScheduledFlight flight=
////		List<Booking> b=bookingRepository.findByFlight(flight);
//		return null;
//	}

}
