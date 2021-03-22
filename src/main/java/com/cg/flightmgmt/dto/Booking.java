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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table
public class Booking {
	
	@Id
	@GeneratedValue
	private BigInteger bookingId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User userId;
	private LocalDate bookingDate;

	@Digits(fraction = 0, integer = 5)
	private double ticketCost;
//	private Flight flight=null;
	
	@Max(value = 4)
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



	public Booking(BigInteger bookingId, LocalDate bookingDate,
			@NotEmpty(message = "Ticketcost should not be empty") @Digits(fraction = 0, integer = 5) double ticketCost,
			@NotEmpty(message = "No of Passenger should not be Empty") @Max(4) int noOfPassangers,
			List<Passenger> passengerList, ScheduledFlight scheduledFlight) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.noOfPassangers = noOfPassangers;
		this.passengerList = passengerList;
		this.scheduledFlight = scheduledFlight;
	}

	public Booking(LocalDate bookingDate,
			@NotEmpty(message = "Ticketcost should not be empty") @Digits(fraction = 0, integer = 5) double ticketCost,
			@NotEmpty(message = "No of Passenger should not be Empty") @Max(4) int noOfPassangers,
			List<Passenger> passengerList, ScheduledFlight scheduledFlight) {
		super();
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.noOfPassangers = noOfPassangers;
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
