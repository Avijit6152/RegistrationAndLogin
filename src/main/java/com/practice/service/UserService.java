package com.practice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.practice.dto.UserRegistrationDto;
import com.practice.entity.User;

public interface UserService extends UserDetailsService {

	
	
	public User save(UserRegistrationDto userRegistrationDto);
}
