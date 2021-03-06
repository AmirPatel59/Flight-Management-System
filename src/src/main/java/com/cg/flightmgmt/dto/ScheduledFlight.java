package com.cg.flightmgmt.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ScheduledFlight {
@Id
private int scheduleFlightId;

private int availableSeats;
private double fares; //cost per seat


public ScheduledFlight(int scheduleFlightId) {
	super();
	this.scheduleFlightId = scheduleFlightId;
}
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="scheduleId", referencedColumnName = "scheduleId")
private Schedule schedule;



@OneToOne(cascade = CascadeType.ALL)
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
