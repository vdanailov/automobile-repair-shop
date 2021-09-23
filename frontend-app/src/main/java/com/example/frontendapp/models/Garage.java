package com.example.frontendapp.models;

public class Garage {
	private String name;
	private String address;
	private String brands;
	private Long id;
	
	public Garage(String name, String address, String brands, Long id) {
		this.name = name;
		this.address = address;
		this.brands = brands;
		this.id=id;
	}
	
	public Garage(String name, String address, String brands) {
		this.name = name;
		this.address = address;
		this.brands = brands;
	}
	
	public Garage(Long id) {
		this.id=id;
	}
	
	public Garage() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
