package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;

@Repository
public interface IFlightBookingRepository extends JpaRepository<Booking,BigInteger>{

	public Booking addBooking(Booking booking);
	public Booking cancelBooking(BigInteger bookingid) throws BookingNotFoundException;
	public Booking viewBooking(BigInteger bookingid) throws BookingNotFoundException;
	public List<Booking> viewBookingList(Date bookingdate);
	public List<Booking> viewBookingList(BigInteger flightid);
	public List<Booking> viewBookingHistory(BigInteger userid);
	public Booking updateBooking(Booking booking);
	
}
