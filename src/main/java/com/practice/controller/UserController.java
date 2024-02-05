package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.dto.UserRegistrationDto;
import com.practice.service.UserServiceImpl;

@Controller
@RequestMapping("/reg")
public class UserController {

	
	private UserServiceImpl userServiceImpl;

	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}
	
	
	
	@GetMapping
	public String showRegistrationForm() {
		
		return "registration";
	}
	
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		
		userServiceImpl.save(userRegistrationDto);
		
		return "redirect:/registration?success";
	}
}
