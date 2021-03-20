package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
@Repository
public interface IScheduledFlightRepository extends JpaRepository<ScheduledFlight, Integer>{
	
//	public Flight addFlightSchedule(Flight flight);
//	public Flight viewFlightSchedule(BigInteger flightno);
//	public Flight removeFlightSchedule(BigInteger flightno);
//	public Flight updateFlightSchedule(ScheduledFlight flight);
//	public List<ScheduledFlight> viewAllScheduledFlights();
	
//	@Query(value="select s.schedule from ScheduledFlight s Right join Schedule sp on s.scheduleId=sp.scheduleId where sp.airrivalTime IN (:arrivaldate)")
//	public Schedule viewByArrivalDate(LocalDateTime arrivaldate);
//	public List<ScheduledFlight> viewAllScheduledFlights(Date arrivaldate);
//	public List<ScheduledFlight> viewAllScheduledFlights(Date date1,Date date2);

}
