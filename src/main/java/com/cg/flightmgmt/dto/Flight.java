package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="flight_details")
public class Flight {
	@Id
	@GeneratedValue
   private BigInteger flightId;
   private String carrierName;
   private String flightModel;
   private int seatCapacity;
public Flight() {
	super();
	// TODO Auto-generated constructor stub
}
public Flight(BigInteger flightId, String carrierName, String flightModel, int seatCapacity) {
	super();
	this.flightId = flightId;
	this.carrierName = carrierName;
	this.flightModel = flightModel;
	this.seatCapacity = seatCapacity;
}
public Flight(String carrierName, String flightModel, int seatCapacity) {
	super();
	this.carrierName = carrierName;
	this.flightModel = flightModel;
	this.seatCapacity = seatCapacity;
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
