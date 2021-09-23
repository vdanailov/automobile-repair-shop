package com.example.frontendapp.models;

public class User {
	
	private Long id;
	private String name;
	private String username;
	private String password;
	private String role;
	private int garage;
	private String jwt;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String name, String username, String password, String role, int garage) {
		this.name=name;
		this.username=username;
		this.password=password;
		this.role=role;
		this.garage=garage;
	}
	
	public User(Long id) {
		this.id=id;
	}
	
	public User(String username) {
		this.username=username;
	}
	
	public User() {}
	
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
	
	public void setJwt(String jwt) {
		this.jwt=jwt;
	}
	
	public String getJwt() {
		return this.jwt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
