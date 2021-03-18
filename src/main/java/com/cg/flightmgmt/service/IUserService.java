package com.cg.flightmgmt.service;

import java.math.BigInteger;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

public interface IUserService {

	public User addUser(User user);
//	public User validateUser(User user) throws UserNotFoundException;
	public User updateUser(User user) throws UserNotFoundException;
	public User removeUser(BigInteger userId) throws UserNotFoundException;
	}
