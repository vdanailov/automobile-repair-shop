package com.example.frontendapp.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.frontendapp.models.Garage;
import com.example.frontendapp.models.JwtKeychain;

@Service
public class GarageService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	JwtKeychain jwtKeychain;
	
	@Autowired
	String api;

	public String authUser(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public String addGarage(HttpServletRequest requests) {
		String name = requests.getParameter("name");
		String address = requests.getParameter("address");
		String brand = requests.getParameter("brand");
		Garage garage = new Garage(name, address, brand);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
				
		HttpEntity<Garage> entity = new HttpEntity<Garage>(garage, headers);
		ResponseEntity<String> response = null;
				
		try {
			response = restTemplate.exchange(
				    api + "/garage/add", HttpMethod.POST, entity, String.class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
				
		return response.getBody();
	}
	
	public Garage[] getGarages() {
		Garage[] garages = restTemplate.getForObject(api + "/garage/get", Garage[].class);
		return garages;
	}
	
	public String deleteGarage(long id) {
		Garage garage = new Garage(id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
		
		HttpEntity<Garage> entity = new HttpEntity<Garage>(garage, headers);
		ResponseEntity<String> response = null;
		
		try {
			response = restTemplate.exchange(
					api + "/garage/delete", HttpMethod.DELETE, entity, String.class);
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return response.getBody();
	}
}
