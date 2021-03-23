package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class Booking {
	
	@Id
	@GeneratedValue
	private BigInteger bookingId;
	//private User userId;
	private LocalDate bookingDate;
	
	private double ticketCost;
	private Flight flight=null;
	private int noOfPassangers;
 
	public int getNoOfPassangers() {
		return noOfPassangers;
	}

	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Passenger> passengerList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="scheduleFlightId",referencedColumnName = "scheduleFlightId")
	private ScheduledFlight scheduledFlight;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(BigInteger bookingId, LocalDate bookingDate, double ticketCost, List<Passenger> passengerList,
			ScheduledFlight scheduledFlight) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.passengerList = passengerList;
		this.scheduledFlight = scheduledFlight;
	}

	public Booking(LocalDate bookingDate, double ticketCost, List<Passenger> passengerList,
			ScheduledFlight scheduledFlight) {
		super();
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.passengerList = passengerList;
		this.scheduledFlight = scheduledFlight;
	}

	public BigInteger getBookingId() {
		return bookingId;
	}

	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}

	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", ticketCost=" + ticketCost
				+ ", passengerList=" + passengerList + ", scheduledFlight=" + scheduledFlight + "]";
	} 

	

}
