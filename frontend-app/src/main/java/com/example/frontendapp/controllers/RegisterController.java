package com.example.frontendapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.frontendapp.models.User;
import com.example.frontendapp.services.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("user", new User());
		return "views/register";
	}
	

	@PostMapping("/register")
	public String postRegister(HttpServletRequest requests, Model model) {
		String response = registerService.registerUser(requests, "ROLE_USER", 0);
		model.addAttribute("response", response);
		
		return "index";
	}
}
