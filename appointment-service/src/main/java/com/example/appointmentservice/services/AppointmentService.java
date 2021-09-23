package com.example.appointmentservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointmentservice.models.Appointment;
import com.example.appointmentservice.repositories.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	public String addAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
		return "success";
	}

	public List<Appointment> getUnresolvedAppointments(String garage) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointmentRepository.findAllByResolvedAndGarage("0", garage).forEach(appointment->appointments.add(appointment));
		return appointments;
	}

	public List<Appointment> getResolvedAppointments(String garage) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointmentRepository.findAllByResolvedAndGarage("1", garage).forEach(appointment->appointments.add(appointment));
		System.out.println("worker");
		return appointments;
	}

	public void resolveAppointment(Long id, String price, String worker) {
		 Appointment appointment = appointmentRepository.findById(id).orElseThrow();
		 appointment.setPrice(price);
		 appointment.setResolved("1");
		 appointment.setWorker(worker);
		 appointmentRepository.save(appointment);
	}

	public List<Appointment> getClientAppointments(String worker) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointmentRepository.findAllByClient(worker).forEach(appointment->appointments.add(appointment));
		return appointments;
	}

}
