package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

@Repository
public interface IUserRepository extends JpaRepository<User, BigInteger>{

//	public User addUser(User user);
//	public User validateUser(User user) throws UserNotFoundException;
//	public User updateUser(User user) throws UserNotFoundException;
//	public User removeUser(BigInteger userid) throws UserNotFoundException;
	}
