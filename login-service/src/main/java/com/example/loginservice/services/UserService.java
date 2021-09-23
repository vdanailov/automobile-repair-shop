package com.example.loginservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginservice.models.User;
import com.example.loginservice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User getUser(String username) {
		return userRepository.findUserByUsername(username);
	}
}
