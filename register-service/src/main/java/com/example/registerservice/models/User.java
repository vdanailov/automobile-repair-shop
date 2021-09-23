package com.example.registerservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String username;
	private String password;
	private String role;
	private int garage;
	
	public User(String name, String username, String password, String role, int garage) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.garage=garage;
		this.name=name;
	}
	
	public User(Long id) {
		this.id=id;
	}
	
	protected User() {}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
		
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public int getGarage() {
		return garage;
	}

	public void setGarage(int garage) {
		this.garage = garage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
