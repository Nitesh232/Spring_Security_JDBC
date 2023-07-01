package com.nitesh.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nitesh.springboot.entity.User;
import com.nitesh.springboot.repo.UserDetailsRepo;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userInfo = repo.findByName(username);
		
		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user "+username+" not found."));
	}

}
