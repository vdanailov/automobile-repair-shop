package com.example.appointmentservice.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.appointmentservice.models.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	List<Appointment> findAllByResolvedAndGarage(String resolved, String garage);
	List<Appointment> findAllByClient(String client);
}
