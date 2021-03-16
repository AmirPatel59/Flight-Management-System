package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

public interface IUserRepository {

	public User addUser(User user);
	public User validateUser(User user) throws UserNotFoundException;
	public User updateUser(User user) throws UserNotFoundException;
	public User removeUser(BigInteger userid) throws UserNotFoundException;
	}
