package com.example.frontendapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.frontendapp.models.JwtKeychain;
import com.example.frontendapp.models.User;
import com.example.frontendapp.services.LoginService;

@Controller
public class LoginController {
	@Autowired
	JwtKeychain jwtKeychain;
	
	@Autowired
	LoginService loginService;
	
	
	public boolean isAuthenticated(){
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
	}
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		if(!isAuthenticated()) {
			return "views/login";
		} else return "redirect:/";
	}
	
	@PostMapping("/login")
	public String postLogin(HttpServletRequest params, Model model) {
		User user = loginService.login(params);
		model.addAttribute("jwt", jwtKeychain.getToken(user.getUsername()));
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("role", user.getRole());
		
		return "redirect:/";
	}
}
