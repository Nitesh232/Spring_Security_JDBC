package com.nitesh.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nitesh.springboot.entity.User;
import com.nitesh.springboot.repo.UserDetailsRepo;

@Service
public class UserService {
	
	
	@Autowired
	private UserDetailsRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;

	
	public String addUser(User user) {
		Integer userId = user.getId();
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return "";
	}
	
	
	public String deleteUser(Integer id) {
		repo.deleteById(id);
		return "user deleted successfully.";
	}
	
	
	public List<User> getAllUser(){
		return repo.findAll();
	}
	
	
	
}
