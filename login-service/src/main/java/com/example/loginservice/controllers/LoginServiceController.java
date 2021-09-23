package com.example.loginservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginservice.models.User;
import com.example.loginservice.services.UserService;

@RestController
public class LoginServiceController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public User login(@RequestBody String username)	 {
		return userService.getUser(username);
	}
}
