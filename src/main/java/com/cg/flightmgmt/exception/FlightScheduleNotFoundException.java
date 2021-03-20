package com.cg.flightmgmt.exception;

public class FlightScheduleNotFoundException extends RuntimeException {
	public FlightScheduleNotFoundException(String message) {
		super(message);
	}
}
