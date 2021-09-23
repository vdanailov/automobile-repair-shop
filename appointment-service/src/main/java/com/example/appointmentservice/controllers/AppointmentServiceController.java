package com.example.appointmentservice.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointmentservice.models.Appointment;
import com.example.appointmentservice.services.AppointmentService;

@RestController
public class AppointmentServiceController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/add")
	public String addAppointment(@RequestBody Appointment appointment) {
		return appointmentService.addAppointment(appointment);
	}
	
	@PostMapping("/get/unresolved")
	public List<Appointment> getUnresolvedAppointments(@RequestBody Appointment appointment){
		return appointmentService.getUnresolvedAppointments(appointment.getGarage());
	}

	@PostMapping("/get/resolved")
	public List<Appointment> getResolvedAppointments(@RequestBody Appointment appointment){
		return appointmentService.getResolvedAppointments(appointment.getGarage());
	}
	
	@PostMapping("/resolve")
	public void resolveAppointment(@RequestBody Appointment appointment) {
		appointmentService.resolveAppointment(appointment.getId(), appointment.getPrice(), appointment.getWorker());
	}
	@PostMapping("/get/client")
	public List<Appointment> getClientAppointments(@RequestBody Appointment appointment) {
		return appointmentService.getClientAppointments(appointment.getWorker());
	}
}

