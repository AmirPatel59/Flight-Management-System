package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
@Entity
@Table
public class Flight {
	@Id
	@GeneratedValue
private BigInteger flightId;
	@NotEmpty(message = "Carrier Name should not be Empty")
private String carrierName;
	@NotEmpty(message = "Flight model should not be Empty")
private String flightModel;
	@Max(value = 200)
	@Min(value=150)
private int seatCapacity;

	
	
	
public Flight(@NotEmpty(message = "Carrier Name should not be Empty") String carrierName,
			@NotEmpty(message = "Flight model should not be Empty") String flightModel, @Max(200) int seatCapacity) {
		super();
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}


public Flight(BigInteger flightId, @NotEmpty(message = "Carrier Name should not be Empty") String carrierName,
			@NotEmpty(message = "Flight model should not be Empty") String flightModel, @Max(200) int seatCapacity) {
		super();
		this.flightId = flightId;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}


public Flight() {
	super();
}


public BigInteger getFlightId() {
	return flightId;
}
public void setFlightId(BigInteger flightId) {
	this.flightId = flightId;
}
public String getCarrierName() {
	return carrierName;
}
public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
}
public String getFlightModel() {
	return flightModel;
}
public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
}
public int getSeatCapacity() {
	return seatCapacity;
}
public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
}
@Override
public String toString() {
	return "Flight [flightId=" + flightId + ", carrierName=" + carrierName + ", flightModel=" + flightModel
			+ ", seatCapacity=" + seatCapacity + "]";
}



}
