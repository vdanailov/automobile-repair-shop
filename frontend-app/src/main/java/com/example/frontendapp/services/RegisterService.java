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

import com.example.frontendapp.models.JwtKeychain;
import com.example.frontendapp.models.User;

@Service
public class RegisterService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	JwtKeychain jwtKeychain;
	
	@Autowired
	String api;
	
	public String authUser(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public String registerUser(HttpServletRequest requests, String role, int garage) {
		String username = requests.getParameter("username");
		String password = requests.getParameter("password");
		String name = requests.getParameter("name");
		
		User user = new User(name, username, password, role, garage);
		return restTemplate.postForObject(api + "/register", user, String.class);
	}
	
	public User[] getWorkers() {
		User[] workers = null;
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
		
		HttpEntity<User[]> entity = new HttpEntity<User[]>(workers, headers);
		ResponseEntity<User[]> response = null;
		
		try {
			response = restTemplate.exchange(
					api + "/register/get/workers", HttpMethod.GET, entity, User[].class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
	
		return response.getBody();
	}
	
	public String deleteWorker(long id) {
		User worker = new User(id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwtKeychain.getToken(authUser()));
		
		HttpEntity<User> entity = new HttpEntity<User>(worker, headers);
		ResponseEntity<String> response = null;
		
		try {
			response = restTemplate.exchange(
					api + "/register/delete", HttpMethod.DELETE, entity, String.class);
		} catch(Exception e) {
				System.out.println("Exception: "+e.getMessage());
		}
		
		return response.getBody();
	}
}
