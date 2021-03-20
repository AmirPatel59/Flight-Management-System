package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.repository.IPassengerRepository;
@Service
@Transactional
public class PassengerService implements IPassengerService {

	@Autowired
	IPassengerRepository repository;
	@Override
	public Passenger addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		
		return repository.save(passenger);
	}

	@Override
	public Passenger viewPassenger(int passengerId) {
		Passenger passengerData=repository.findById(passengerId).orElse(null);
		return passengerData;
	}

	


}
