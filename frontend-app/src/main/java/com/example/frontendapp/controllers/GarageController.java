package com.example.frontendapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.frontendapp.models.Garage;
import com.example.frontendapp.services.GarageService;

@Controller
public class GarageController {

	@Autowired
	GarageService garageService;
	
	@GetMapping("/add-garage")
	public String getGarage(Model model) {
		return "views/add-garage";
	}
	
	@PostMapping("/add-garage")
	public String postGarage(HttpServletRequest requests, Model model) {
		String response = garageService.addGarage(requests);
		model.addAttribute("response", response);
		return "redirect:/delete-garage";
	}
	
	@GetMapping("/delete-garage")
	public String getDeleteGarage(Model model) {
		Garage[] garages = garageService.getGarages();
		model.addAttribute("garages", garages);
		return "views/delete-garage";
	}
	
	@GetMapping("/delete-garage/{id}")
	public String postDeleteGarage(@PathVariable(value="id") long id) {
		garageService.deleteGarage(id);
		return "redirect:/delete-garage";
	}
	
}
