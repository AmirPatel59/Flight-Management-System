package com.cg.flightmgmt.controller;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.IUserService;


@RestController

@RequestMapping("/fms/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
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
	public ResponseEntity<String> removeUser(@Valid @PathVariable BigInteger userId) throws UserNotFoundException{
		userService.removeUser(userId);
		String message = "User Successfully Removed";
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping("/validateUser")
	public ResponseEntity<User> validateUser(@RequestParam("userName") String userName, @RequestParam("password") String password) throws UserNotFoundException{
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		User userFromRepo = userService.validateUser(user);
		return new ResponseEntity<User>(userFromRepo, HttpStatus.OK);
	}

}