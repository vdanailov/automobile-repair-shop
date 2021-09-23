package com.example.frontendapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.frontendapp.models.JwtKeychain;
import com.example.frontendapp.utils.JwtUtil;

@SpringBootApplication
public class FrontendAppApplication {

	@Bean
	public String api(@Value("${api.gateway.location}") String api) {
		return api;
	}
	
	@Bean
	public JwtKeychain jwtKeychain() {
		return JwtKeychain.getInstance();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public JwtUtil jwtUtil() {
		return new JwtUtil();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FrontendAppApplication.class, args);
	}

	
}
