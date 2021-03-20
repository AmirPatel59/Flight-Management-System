package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		
		User userData = userRepository.save(user);
		return userData;
	}

	
	
	
	@Override
	public User updateUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}
	
	@Override
	public User removeUser(BigInteger userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElse(null);
		user.setBooking(null);
		userRepository.deleteById(userId);
		return null;
	}

	@Override
	public User validateUser(User user) throws UserNotFoundException {
	Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
		if(!userOptional.isPresent()){
			 throw new UserNotFoundException("User not found for email " );
		}
		return user;
	}

//
//	@Override
//	public User validateUser(User user) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		List<User> list=userRepository.findAll();
//		if(!list.contains(user)) {
//			return null;
//		}
//		return user;
//	}
//	
}
