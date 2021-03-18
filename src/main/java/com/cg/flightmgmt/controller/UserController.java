package com.cg.flightmgmt.controller;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return new ResponseEntity<User>(userData,HttpStatus.OK);
	}
	

	@PutMapping("/removeUser{userid}")
	public ResponseEntity<User> removeUser(@Valid @PathVariable BigInteger userId) throws UserNotFoundException{
		User userData = userService.removeUser(userId);
		return new ResponseEntity<User>(userData,HttpStatus.OK);
	}

}
