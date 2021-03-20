package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table
public class Passenger {
	@Id
	@GeneratedValue
private int pnrNumber;
	@NotEmpty(message = "Passenger name should not be Empty")
private String passengerName;
	@Digits(fraction = 0, integer = 2)
private int age;
	
private BigInteger passengerUIN;
	@Max(value = 5)
private Double luggage;
public Passenger() {
	super();
	// TODO Auto-generated constructor stub
}
public Passenger(int pnrNumber, String passengerName, int age, BigInteger passengerUIN, Double luggage) {
	super();
	this.pnrNumber = pnrNumber;
	this.passengerName = passengerName;
	this.age = age;
	this.passengerUIN = passengerUIN;
	this.luggage = luggage;
}
public Passenger(String passengerName, int age, BigInteger passengerUIN, Double luggage) {
	super();
	this.passengerName = passengerName;
	this.age = age;
	this.passengerUIN = passengerUIN;
	this.luggage = luggage;
}
public int getPnrNumber() {
	return pnrNumber;
}
public void setPnrNumber(int pnrNumber) {
	this.pnrNumber = pnrNumber;
}
public String getPassengerName() {
	return passengerName;
}
public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public BigInteger getPassengerUIN() {
	return passengerUIN;
}
public void setPassengerUIN(BigInteger passengerUIN) {
	this.passengerUIN = passengerUIN;
}
public Double getLuggage() {
	return luggage;
}
public void setLuggage(Double luggage) {
	this.luggage = luggage;
}
@Override
public String toString() {
	return "Passenger [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", age=" + age + ", passengerUIN="
			+ passengerUIN + ", luggage=" + luggage + "]";
}


}
