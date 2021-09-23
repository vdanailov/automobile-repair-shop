package com.example.loginservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.loginservice.models.Garage;

public interface GarageRepository extends CrudRepository<Garage, Long>{
	
}
