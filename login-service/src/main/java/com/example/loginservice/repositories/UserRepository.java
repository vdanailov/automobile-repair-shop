package com.example.loginservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.loginservice.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findUserByUsername(String username);
}
