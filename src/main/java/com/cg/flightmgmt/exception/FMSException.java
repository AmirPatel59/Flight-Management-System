package com.cg.flightmgmt.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class FMSException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(UserNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(FlightNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(BookingNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler(FlightScheduleNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(FlightScheduleNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler(PassengerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(PassengerNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
}