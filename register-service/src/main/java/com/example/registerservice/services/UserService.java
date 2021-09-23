package com.example.registerservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.registerservice.models.User;
import com.example.registerservice.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String addUser(User user) {
		if(!userExists(user.getUsername())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return "Success";
		} else {
			return "Fail";
		}
	}
	
	public boolean userExists(String username) {
		if(userRepository.findUserByUsername(username) != null) {
			return true;
		} else return false;
	}
	
	public List<User> getAllWorkers() {
		List<User> workers = new ArrayList<User>();
		userRepository.findAllByRole("ROLE_WORKER").forEach(worker->workers.add(worker));
		return workers;
	}
	
	public void deleteWorker(User worker) {
		System.out.println(worker.getId());
		userRepository.deleteById(worker.getId());
	
	}
	
	public String getWorkerGarage(User worker) {
		return String.valueOf(userRepository.findUserByUsername(worker.getUsername()).getGarage());
	}
}
