package com.practice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.UserRegistrationDto;
import com.practice.entity.Role;
import com.practice.entity.User;
import com.practice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	private UserRepository userRepository;
     
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}





	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		
		User user =new User(userRegistrationDto.getUname(), userRegistrationDto.getUemail(), userRegistrationDto.getUpassword(), Arrays.asList(new Role("Role_User")));
		
		return userRepository.save(user);
	}

}
