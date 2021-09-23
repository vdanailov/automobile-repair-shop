package com.example.frontendapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.frontendapp.models.Appointment;
import com.example.frontendapp.models.Garage;
import com.example.frontendapp.services.AppointmentService;
import com.example.frontendapp.services.GarageService;

@Controller
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	GarageService garageService;
	
	@GetMapping("/resolve-appointments")
	public String getResolveAppointments(Model model) {
		Appointment[] appointments = appointmentService.getUnresolvedAppointments();
		model.addAttribute("appointments", appointments);
		return "views/resolve-appointments";
	}
	
	@PostMapping("/resolve-appointments")
	public String postResolveAppointments(HttpServletRequest requests) {
		String response = appointmentService.resolveAppointment(requests);
		return "redirect:/resolve-appointments";
	}
	
	@GetMapping("/resolved-appointments")
	public String getResolvedAppointments(Model model) {
		Appointment[] appointments = appointmentService.getResolvedAppointments();
		model.addAttribute("appointments", appointments);
		return "views/resolved-appointments";
	}
	
	@GetMapping("/add-appointment")
	public String getUser(Model model) {
		Garage[] garages = garageService.getGarages();
		model.addAttribute("garages", garages);
		return "views/add-appointment";
	}
	
	@PostMapping("/add-appointment")
	public String addAppointment(HttpServletRequest request) {
		String response = appointmentService.addAppointment(request);
		return "redirect:/all-appointments";
	}
	
	@GetMapping("/all-appointments")
	public String viewAllAppointments(Model model) {
		Appointment[] appointments = appointmentService.getClientAppointments();
		model.addAttribute("appointments", appointments);
		System.out.println(appointments);
		return "views/all-appointments";
	}
}

