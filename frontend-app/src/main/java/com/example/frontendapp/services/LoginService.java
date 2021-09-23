package com.example.frontendapp.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.frontendapp.models.AuthenticationResponse;
import com.example.frontendapp.models.JwtKeychain;
import com.example.frontendapp.models.User;
import com.example.frontendapp.utils.JwtUtil;

@Service
public class LoginService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	JwtKeychain jwtKeychain;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	String api;
	
	public User login(HttpServletRequest requests) {
		AuthenticationResponse authResponse = restTemplate.postForObject(api+"/authenticate", 
				new User(requests.getParameter("username"), requests.getParameter("password")), AuthenticationResponse.class);
		
		User user = new User();
		user.setUsername(jwtUtil.extractUsername(authResponse.getJwt()));
		user.setRole(jwtUtil.extractRole(authResponse.getJwt()));
		
		jwtKeychain.add(user.getUsername(), authResponse.getJwt());
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), null,  AuthorityUtils.createAuthorityList(user.getRole()));
	    SecurityContextHolder.getContext().setAuthentication(auth);
	    return user;
	}
}
