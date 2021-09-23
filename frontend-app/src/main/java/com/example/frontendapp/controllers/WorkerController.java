package com.example.frontendapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.frontendapp.models.Garage;
import com.example.frontendapp.models.User;
import com.example.frontendapp.services.GarageService;
import com.example.frontendapp.services.RegisterService;

@Controller
public class WorkerController {
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	GarageService garageService;
	
	@GetMapping("/add-worker")
	public String getWorker(Model model) {
		Garage[] garages = garageService.getGarages();
		model.addAttribute("garages", garages);
		return "views/add-worker";
	}
	
	@PostMapping("/add-worker")
	public String postRegister(HttpServletRequest requests, Model model) {
		String response = registerService.registerUser(requests, "ROLE_WORKER", Integer.parseInt(requests.getParameter("garage")));
		model.addAttribute("response", response);
		return "redirect:/delete-worker";
	}
	
	@GetMapping("/delete-worker")
	public String getDeleteWorker(Model model) {
		User[] workers = registerService.getWorkers();
		model.addAttribute("workers", workers);
		return "views/delete-worker";
	}
	
	@GetMapping("/delete-worker/{id}")
	public String deleteWorker(@PathVariable(value="id") long id) {
		registerService.deleteWorker(id);
		return "redirect:/delete-worker";
	}
	
	
}
