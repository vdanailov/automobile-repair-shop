package com.example.frontendapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.frontendapp.models.Appointment;
import com.example.frontendapp.models.JwtKeychain;
import com.example.frontendapp.models.User;

@Service
public class AppointmentService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	JwtKeychain jwtKeychain;
	
	@Autowired
	String api;
	
	public String authUser(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public Appointment[] getUnresolvedAppointments() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
		
		User user = new User(authUser());
		HttpEntity<User> userEntity = new HttpEntity<User>(user, headers);
		ResponseEntity<String> userResponse = null;
		
		try {
			userResponse = restTemplate.exchange(
					api + "/register/get/worker/garage", HttpMethod.POST, userEntity, String.class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
		
		String garage = userResponse.getBody();
		Appointment appointment = new Appointment(authUser(), garage);
		HttpEntity<Appointment> entity = new HttpEntity<Appointment>(appointment, headers);
		ResponseEntity<Appointment[]> response = null;
		
		try {
			response = restTemplate.exchange(
					api + "/appointment/get/unresolved", HttpMethod.POST, entity, Appointment[].class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
		
		return response.getBody();
	}

	public String resolveAppointment(HttpServletRequest requests) {
		Appointment appointment=new Appointment(Long.valueOf(requests.getParameter("id")), requests.getParameter("price"), authUser());
	
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
		HttpEntity<Appointment> entity = new HttpEntity<Appointment>(appointment, headers);
		ResponseEntity<String> response = null;
		
		try {
			response = restTemplate.exchange(
					api + "/appointment/resolve", HttpMethod.POST, entity, String.class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
		return response.getBody();
	}

	public Appointment[] getResolvedAppointments() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
		
		User user = new User(authUser());
		HttpEntity<User> userEntity = new HttpEntity<User>(user, headers);
		ResponseEntity<String> userResponse = null;
		
		try {
			userResponse = restTemplate.exchange(
					api + "/register/get/worker/garage", HttpMethod.POST, userEntity, String.class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
		
		String garage = userResponse.getBody();
		Appointment appointment = new Appointment(authUser(),garage);
		HttpEntity<Appointment> entity = new HttpEntity<Appointment>(appointment, headers);
		ResponseEntity<Appointment[]> response = null;
		
		try {
			response = restTemplate.exchange(
					api + "/appointment/get/resolved", HttpMethod.POST, entity, Appointment[].class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
		
		return response.getBody();
	}
	
	public Appointment[] getClientAppointments() {
		Appointment appointment = new Appointment(authUser());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
		
		HttpEntity<Appointment> entity = new HttpEntity<Appointment>(appointment, headers);
		ResponseEntity<Appointment[]> response = null;
		
		try {
			response = restTemplate.exchange(
					api + "/appointment/get/client", HttpMethod.POST, entity, Appointment[].class);
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return response.getBody();
		
	}
	public String addAppointment(HttpServletRequest request) {
		String garage = request.getParameter("garage");
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String number = request.getParameter("number");
		String problem = request.getParameter("problem");
		String dateTime=request.getParameter("datetime");
		
		Date date = new Date();
		
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(dateTime);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Appointment appointment = new Appointment(garage, brand, model, year, number, problem, authUser(), "0", date);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
				
		HttpEntity<Appointment> entity = new HttpEntity<Appointment>(appointment, headers);
		ResponseEntity<String> response = null;
				
		try {
			response = restTemplate.exchange(
					api + "/appointment/add", HttpMethod.POST, entity, String.class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
				
		return response.getBody();
	}
}
