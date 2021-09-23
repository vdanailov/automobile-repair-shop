package com.example.frontendapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.frontendapp.models.JwtKeychain;

@Controller
public class LogoutController {
	
	@Autowired
	JwtKeychain jwtKeychain;
	
	@GetMapping("/logout")
    public String getLogoutPage(HttpServletRequest request, HttpServletResponse response){

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            jwtKeychain.remove(authentication.getName());
        }
        return "redirect:/login";
    }
}
