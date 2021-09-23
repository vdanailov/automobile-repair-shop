package com.example.loginservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginservice.models.Garage;
import com.example.loginservice.services.GarageService;

@RestController
public class GarageServiceConrtoller {
	
	@Autowired
	GarageService garageService;
	
	@PostMapping("/add")
	public String addGarage(@RequestBody Garage garage) {
		return garageService.addGarage(garage);
	}
	
	@GetMapping("/get")
	public List<Garage> getAllGarages() {
		return garageService.getAllGarages();
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody Garage garage) {
		return garageService.deleteGarage(garage.getId());
	}
	
}
