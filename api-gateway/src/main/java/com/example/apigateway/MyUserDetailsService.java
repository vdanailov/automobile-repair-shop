package com.example.apigateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	RestTemplate restTemplate;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	HttpEntity<String> request = new HttpEntity<String>(username);
    	com.example.apigateway.models.User user = restTemplate.postForObject("http://localhost:8080/login", request, com.example.apigateway.models.User.class);
    
    	if(username.equals(user.getUsername())){
	    	List<GrantedAuthority> authorityList = new ArrayList<>();
		    authorityList.add(new SimpleGrantedAuthority(user.getRole()));
	    	User userPrincipal = new User(user.getUsername(), user.getPassword(), authorityList);
	    	return userPrincipal;
	   } else return null;
    }
}
   

