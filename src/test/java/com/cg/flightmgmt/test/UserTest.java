
package com.cg.flightmgmt.test;

import java.math.BigInteger;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;
import com.cg.flightmgmt.service.IUserService;

@SpringBootTest
public class UserTest {

	@Autowired
	private IUserService userService;
	@MockBean
	IUserRepository userRepository;

	// Checking for successfully adding of user into database
	@Test
	public void addUserValidTest() {
		User user = new User();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assertions.assertEquals(user, userService.addUser(user));
	}

	// Checking if data of specified user is updated successfully
	@Test
	public void updateUserValidTest() throws UserNotFoundException {
		User updateUser = new User();
		updateUser.setUserId(BigInteger.valueOf(100));
		Mockito.when(userRepository.findById(BigInteger.valueOf(100))).thenReturn(Optional.of(updateUser));
		Mockito.when(userRepository.save(updateUser)).thenReturn(updateUser);
		Assertions.assertDoesNotThrow(() -> userService.updateUser(updateUser));
	}

	// Checking for "User Id not found" exception
	@Test
	public void updateUserInvalidTest() throws UserNotFoundException {
		User updateUser = new User();
		updateUser.setUserId(BigInteger.valueOf(100));
		Mockito.when(userRepository.findById(BigInteger.valueOf(100))).thenReturn(Optional.empty());
		UserNotFoundException uNFE = Assertions.assertThrows(UserNotFoundException.class,() -> userService.updateUser(updateUser));
		Assertions.assertEquals("User Id Not Found.", uNFE.getMessage());
	}

	@Test
	public void removeUserValidTest() {
		User user = new User();
		user.setUserId(BigInteger.valueOf(100));
		Mockito.when(userRepository.findById(BigInteger.valueOf(100))).thenReturn(Optional.of(user));
		Assertions.assertDoesNotThrow(() -> userService.removeUser(BigInteger.valueOf(100)));
	}
	
	@Test
	public void removeUserInvalidTest() {
		User user = new User();
		user.setUserId(BigInteger.valueOf(100));
		Mockito.when(userRepository.findById(BigInteger.valueOf(100))).thenReturn(Optional.empty());
		UserNotFoundException uNFE = Assertions.assertThrows(UserNotFoundException.class,() -> userService.removeUser(BigInteger.valueOf(100)));
		Assertions.assertEquals("User Id Not Found.", uNFE.getMessage());
	}

	@Test
	public void validateUserValidTest() {
		User user = new User();
		user.setUserId(BigInteger.valueOf(100));
		user.setUserName("sruthi");
		user.setPassword("rakshitha");
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(Optional.of(user));
		Assertions.assertDoesNotThrow(() -> userService.validateUser(user));
	}
	
	@Test
	public void validateUserInvalidTest() {
		User user = new User();
		user.setUserId(BigInteger.valueOf(100));
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(Optional.empty());
		UserNotFoundException uNFE = Assertions.assertThrows(UserNotFoundException.class,() -> userService.validateUser(user));
		Assertions.assertEquals("Please enter valid user id.", uNFE.getMessage());
	}
}