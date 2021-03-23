package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Passenger;
@Repository
public interface IPassengerRepository extends JpaRepository<Passenger,Integer>{

}
