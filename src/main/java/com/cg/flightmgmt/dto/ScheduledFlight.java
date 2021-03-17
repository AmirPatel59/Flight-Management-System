package com.cg.flightmgmt.dto;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table
public class ScheduledFlight {
//@Id
private int id;
private Flight flight;
private int availableSeats;
private Schedule schedule;
private double fares; //cost per seat


//constructors
public ScheduledFlight() {
	super();
}


public ScheduledFlight(Flight flight, int availableSeats, Schedule schedule, double fares) {
	super();
	this.flight = flight;
	this.availableSeats = availableSeats;
	this.schedule = schedule;
	this.fares = fares;
}

//getter and setters

public Flight getFlight() {
	return flight;
}


public void setFlight(Flight flight) {
	this.flight = flight;
}


public int getAvailableSeats() {
	return availableSeats;
}


public void setAvailableSeats(int availableSeats) {
	this.availableSeats = availableSeats;
}


public Schedule getSchedule() {
	return schedule;
}


public void setSchedule(Schedule schedule) {
	this.schedule = schedule;
}


public double getFares() {
	return fares;
}


public void setFares(double fares) {
	this.fares = fares;
}


@Override
public String toString() {
	return "ScheduledFlight [flight=" + flight + ", availableSeats=" + availableSeats + ", schedule=" + schedule
			+ ", fares=" + fares + "]";
}

//to String



}
