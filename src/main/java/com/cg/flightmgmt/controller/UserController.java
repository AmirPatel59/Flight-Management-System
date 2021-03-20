package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;
import com.cg.flightmgmt.service.IUserService;


@RestController

@RequestMapping("/fms/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
    private IUserRepository userRepository;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		User userData = userService.addUser(user);
		return new ResponseEntity<User>(userData,HttpStatus.OK);
	}
	
	

	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws UserNotFoundException{
		User userData = userService.updateUser(user);
		if(userData==null) {
			throw new UserNotFoundException("Enter valid user id");
		}
		return new ResponseEntity<User>(userData,HttpStatus.OK);
	}
	
	@DeleteMapping("/removeUser/{userId}")
	public ResponseEntity<User> removeUser(@Valid @PathVariable BigInteger userId) throws UserNotFoundException{
		User userData = userService.removeUser(userId);
		if(userData==null) {
			throw new UserNotFoundException("Enter Valid User Id");
		}
		userData=null;
		return new ResponseEntity<User>(userData,HttpStatus.OK);
	}
	
	
	@PutMapping("/validateUser")
	Optional<User> validateUser(@RequestParam("email") String email, @RequestParam("password") String password) throws UserNotFoundException{
		Optional<User> foundUser=userRepository.findByEmail(email);
		 if(!foundUser.isPresent()){
	            throw new UserNotFoundException("Email not found: "+email);
	        }
		 
		return foundUser;
		
	}

	

}
