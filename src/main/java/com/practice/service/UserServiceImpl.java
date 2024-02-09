package com.practice.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


	@Autowired
	private BCryptPasswordEncoder passwordEncoder;



	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		
		User user =new User(userRegistrationDto.getUname(), userRegistrationDto.getUemail(),passwordEncoder.encode( userRegistrationDto.getUpassword()), Arrays.asList(new Role("Role_User")));
		
		return userRepository.save(user);
	}





	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUemail(username);
		
		if(user == null) {
			
			throw new UsernameNotFoundException("Invalid UserName Or Password");
		}
		
		
		
		return new org.springframework.security.core.userdetails.User(user.getUemail(),user.getUpassword(), mapRolesToAuthorities(user.getRoles()));
	}


	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRname())).collect(Collectors.toList());
	}
}
