package com.nitesh.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.springboot.entity.User;

public interface UserDetailsRepo extends JpaRepository<User, Integer>{

	Optional<User> findByName(String username);

}
