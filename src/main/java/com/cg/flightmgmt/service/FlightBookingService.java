package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.IFlightBookingRepository;

@Service
@Transactional
public class FlightBookingService implements IFlightBookingService {
	@Autowired
	IFlightBookingRepository repository;

	@Override
	public Booking addBooking(Booking booking) {
		Booking bookingData= repository.save(booking);
		return bookingData;
	}

	@Override
	public Booking cancelBooking(BigInteger bookingid) throws BookingNotFoundException {
		repository.deleteById(bookingid);
		return viewBooking(bookingid);
	}

	@Override
	public Booking viewBooking(BigInteger bookingid) throws BookingNotFoundException {
		return repository.findById(bookingid).orElse(null);
		
	}

	@Override
	public List<Booking> viewBookingList(Date bookingdate) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Booking> viewBookingList(BigInteger flightid) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Booking> viewBookingHistory(BigInteger userid) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Booking updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		return repository.save(booking);
	}
	

}
