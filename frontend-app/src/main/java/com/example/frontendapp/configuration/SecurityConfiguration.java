package com.example.frontendapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
    @Override
    protected void configure(HttpSecurity security) throws Exception{
    	
     security.
	     httpBasic().disable().
	     formLogin().disable().
	     authorizeRequests().
		     antMatchers("/add-garage").hasRole("ADMIN").
		     antMatchers("/add-worker").hasRole("ADMIN").
		     antMatchers("/delete-garage").hasRole("ADMIN").
		     antMatchers("/delete-worker").hasRole("ADMIN").
		     antMatchers("/resolve-appointments").hasRole("WORKER").
		     antMatchers("/resolved-appoimtnets").hasRole("WORKER").
		     antMatchers("/add-appointment").hasRole("USER").
		     antMatchers("/all-appointments").hasRole("USER");
    }
}
