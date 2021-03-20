package com.cg.flightmgmt.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Schedule;
@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {

	
}
