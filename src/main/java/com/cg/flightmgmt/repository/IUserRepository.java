package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.User;

@Repository
public interface IUserRepository extends JpaRepository<User, BigInteger>  {
	Optional<User> findByUserName(String userName);
}
