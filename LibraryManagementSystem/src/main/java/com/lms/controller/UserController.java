package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.exception.UserException;
import com.lms.model.User;
import com.lms.service.UserService;

@RestController
@RequestMapping("/lms")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws UserException{
		
		return new ResponseEntity<User>(us.addUser(user), HttpStatus.CREATED);
		
	}
	
}
