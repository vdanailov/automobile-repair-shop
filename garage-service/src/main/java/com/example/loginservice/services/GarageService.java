package com.example.loginservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginservice.models.Garage;
import com.example.loginservice.repositories.GarageRepository;

@Service
public class GarageService {

	@Autowired
	GarageRepository garageRepository;
	
	public String addGarage(Garage garage) {
		garageRepository.save(garage);
		return "success";
	}

	public List<Garage> getAllGarages() {
		List<Garage> garages = new ArrayList<Garage>();
		garageRepository.findAll().forEach(garage->garages.add(garage));
		return garages;
	}
	
	public String deleteGarage(Long id) {
		garageRepository.deleteById(id);
		return "success";
	}
}
