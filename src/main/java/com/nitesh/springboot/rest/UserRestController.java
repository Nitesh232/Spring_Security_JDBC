package com.nitesh.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.springboot.entity.User;
import com.nitesh.springboot.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/hello")
	public String getGreet() {
		return "Hello, Welcome to Spring Security with Implementation of JDBC..";
	}
	
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getUser(){
		return service.getAllUser();
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		return service.deleteUser(id);
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "Contact us for future updates.";
	}
	

}
