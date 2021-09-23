package com.example.frontendapp.models;

import java.util.Date;

public class Appointment {
	private Long id;
	
	private String number;
	private String brand;
	private String model;
	private String year;
	private String price;
	private String problem;
	private Date dateTime;
	
	private String client;
	private String garage;
	private String worker;
	private String resolved;
	
	public Appointment(String number, String brand, String model, String year, String price, String problem, String client,
			String garage, String worker, String resolved, Date dateTime) {
		this.number = number;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.problem = problem;
		this.garage = garage;
		this.worker = worker;
		this.resolved = resolved;
		this.client=client;
		this.dateTime=dateTime;
	}
	
	
	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	public Appointment(String worker) {
		this.worker=worker;
	}

	public Appointment(String worker, String garage) {
		this.worker = worker;
		this.garage = garage;
	}
	
	public Appointment(Long id, String price, String worker) {
		this.id=id;
		this.price=price;
		this.worker=worker;
	}
	
	public Appointment(String garage, String brand, String model, String year, String number, String problem, String client, String resolved, Date dateTime) {
		this.garage=garage;
		this.brand=brand;
		this.model=model;
		this.year=year;
		this.number=number;
		this.problem=problem;
		this.client=client;
		this.resolved=resolved;
		this.dateTime=dateTime;
	}
	
	public Appointment() {}
	
	
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
}