package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.service.IFlightBookingService;

@RestController

@RequestMapping("fms/controller/bookingController")
public class BookingController {

	@Autowired
	IFlightBookingService bookingService;
	
	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking){
		int no=booking.getNoOfPassangers();
		
			Booking bookingData=bookingService.addBooking(booking);
		
//		Booking bookingData=booking;
		return new ResponseEntity<Booking>(bookingData,HttpStatus.OK);
	}
	
	@GetMapping("/viewBooking/{bid}")
    public ResponseEntity<Booking> viewBooking(@PathVariable BigInteger bid) throws BookingNotFoundException {
		Booking bookingData=bookingService.viewBooking(bid);
		if(bookingData ==null) {
			throw new BookingNotFoundException("Booking is not found");
		}
		return new ResponseEntity<Booking>(bookingData,HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelBooking/{bid}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable BigInteger bid) throws BookingNotFoundException {
		Booking bookingData=bookingService.cancelBooking(bid);
		
		if(bookingData ==null) {
			throw new BookingNotFoundException("Booking is not removed");
		}
		bookingData=null;
		return new ResponseEntity<Booking>(bookingData,HttpStatus.OK);
	}
	
	@PutMapping("/updateBooking")
	public ResponseEntity<Booking> updateBooking(@Valid @RequestBody Booking booking) throws BookingNotFoundException{
		Booking bookingData=bookingService.updateBooking(booking);
		if(bookingData==null) {
			throw new BookingNotFoundException("Booking Not Found");
		}
		return new ResponseEntity<Booking>(bookingData, HttpStatus.OK);
	}
	
	@GetMapping("/viewBookingByDate")
	public ResponseEntity<List<Booking>> viewBookingByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		List<Booking> list=bookingService.viewBookingList(date);
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}
	
//	@GetMapping("/viewByFlightId/{id}")
//	public ResponseEntity<List<Booking>> viewByFlightId(@RequestBody BigInteger id){
//		List<Booking> list=bookingService.viewBookingList(id);
//		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
//	}
}
