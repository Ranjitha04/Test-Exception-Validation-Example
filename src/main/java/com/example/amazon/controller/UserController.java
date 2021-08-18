package com.example.amazon.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.amazon.dto.Credentials;
import com.example.amazon.dto.UserRequestDto;
import com.example.amazon.exception.InvalidCredentialsException;
import com.example.amazon.service.UserService;
import com.sun.istack.NotNull;

/**
 * @author ranjitha-r
 *
 */
@Validated
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public String register(@RequestBody UserRequestDto userRequestDto) {	
         ///....
		boolean isSaved = userService.saveUserDetails(userRequestDto);
        if(isSaved) return "Registration Successful";
		return "Registration failed";
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<String> login(@Valid @RequestBody Credentials credentials) 
			throws InvalidCredentialsException {
		return userService.authenticate(credentials.getUsername(), credentials.getPassword());	
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<String> getUserById(@NotNull @Min(2) @PathVariable Integer userId) {
		return new ResponseEntity<String>("users data " + userId, HttpStatus.OK);	
	}
}
