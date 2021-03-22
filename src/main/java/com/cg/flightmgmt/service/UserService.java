package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(user.getUserId());
		User userFromRepo = optionalUser.orElseThrow(() -> new UserNotFoundException("User Id Not Found."));
		userFromRepo.setEmail(user.getEmail());
		userFromRepo.setMobileNumber(user.getMobileNumber());
		userFromRepo.setPassword(user.getPassword());
		userFromRepo.setUserId(user.getUserId());
		userFromRepo.setUserName(user.getUserName());
		userFromRepo.setUserType(user.getUserType());
		return userRepository.save(userFromRepo);
	}

	@Override
	public void removeUser(BigInteger userId) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.orElseThrow(() -> new UserNotFoundException("User Id Not Found."));
		user.setBooking(null);
		userRepository.deleteById(userId);
	}

	@Override
	public User validateUser(User user) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());
		User userFromRepo = optionalUser.orElseThrow(() -> new UserNotFoundException("Please enter valid user id."));
		if(!user.getPassword().equals(userFromRepo.getPassword())) {
			throw new UserNotFoundException("Password does not match.");
		}
		return userFromRepo;
	}
}