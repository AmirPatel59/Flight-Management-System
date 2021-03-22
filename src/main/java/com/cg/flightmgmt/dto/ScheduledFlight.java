package com.cg.flightmgmt.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;

@Entity
@Table
public class ScheduledFlight {
@Id
@GeneratedValue
private int scheduleFlightId;
@Max(value=199)
private int availableSeats;
@Digits(fraction = 0, integer = 5)
private double fares; //cost per seat


//Mapping 
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="scheduleId", referencedColumnName = "scheduleId")
private Schedule schedule;



@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
@JoinColumn(name="flightId", referencedColumnName = "flightId")
private Flight flight;

//constructors
public ScheduledFlight() {
	super();
}
public ScheduledFlight(int scheduleFlightId, int availableSeats, double fares, Schedule schedule, Flight flight) {
	super();
	this.scheduleFlightId = scheduleFlightId;
	this.availableSeats = availableSeats;
	this.fares = fares;
	this.schedule = schedule;
	this.flight = flight;
}
public ScheduledFlight(int availableSeats, double fares, Schedule schedule, Flight flight) {
	super();
	this.availableSeats = availableSeats;
	this.fares = fares;
	this.schedule = schedule;
	this.flight = flight;
}

//Getters & Setters

public int getScheduleFlightId() {
	return scheduleFlightId;
}
public void setScheduleFlightId(int scheduleFlightId) {
	this.scheduleFlightId = scheduleFlightId;
}
public int getAvailableSeats() {
	return availableSeats;
}
public void setAvailableSeats(int availableSeats) {
	this.availableSeats = availableSeats;
}
public double getFares() {
	return fares;
}
public void setFares(double fares) {
	this.fares = fares;
}
public Schedule getSchedule() {
	return schedule;
}
public void setSchedule(Schedule schedule) {
	this.schedule = schedule;
}
public Flight getFlight() {
	return flight;
}
public void setFlight(Flight flight) {
	this.flight = flight;
}
@Override
public String toString() {
	return "ScheduledFlight [scheduleFlightId=" + scheduleFlightId + ", availableSeats=" + availableSeats + ", fares="
			+ fares + ", schedule=" + schedule + ", flight=" + flight + "]";
}





}
