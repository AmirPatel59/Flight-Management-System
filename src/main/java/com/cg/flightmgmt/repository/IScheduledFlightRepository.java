package com.cg.flightmgmt.repository;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
@Repository
public interface IScheduledFlightRepository extends JpaRepository<ScheduledFlight, Serializable>{
	
	
//	public Flight addFlightSchedule(Flight flight);
//	public Flight viewFlightSchedule(BigInteger flightno);
//	public Flight removeFlightSchedule(BigInteger flightno);
//	public Flight updateFlightSchedule(ScheduledFlight flight);
//	public List<ScheduledFlight> viewAllScheduledFlights();
//	@Query(value="select s from Schedule s where s.airrivalTime IN (:arrivaldate) ")
//	public List<Schedule> viewByArrivalDate(LocalDateTime arrivaldate);
	@Query(value="select s from ScheduledFlight s where s.schedule.scheduleId IN (select ap.scheduleId from Schedule ap where ap.airrivalTime in (:arrivaldate))")
	public List<ScheduledFlight> findAllBySchedule(LocalDateTime arrivaldate);
//	
//	@Query(value="select s from ScheduledFlight s where s.schedule.scheduleId IN (select ap.scheduleId from Schedule ap where ap.airrivalTime between (:date1) and (:date2))")
//	public List<ScheduledFlight> findAllByScheduled(LocalDateTime date1, LocalDateTime date2);

}
