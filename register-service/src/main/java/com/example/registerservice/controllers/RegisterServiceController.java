package com.example.registerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerservice.models.User;
import com.example.registerservice.services.UserService;

@RestController
public class RegisterServiceController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public String createUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/get/workers")
	public List<User> getAllWorkers(){
		return userService.getAllWorkers();
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody User worker) {
		userService.deleteWorker(worker);
	}
	
	@PostMapping("/get/worker/garage")
	public String getWorkerGarage(@RequestBody User worker) {
		return userService.getWorkerGarage(worker);
	}
}
