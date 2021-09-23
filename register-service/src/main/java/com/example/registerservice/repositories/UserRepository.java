package com.example.registerservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.registerservice.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findUserByUsername(String username);
	List<User> findAllByRole(String role);
}
