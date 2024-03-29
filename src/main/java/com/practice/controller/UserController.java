package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.dto.UserRegistrationDto;
import com.practice.service.UserService;
import com.practice.service.UserServiceImpl;

@Controller
@RequestMapping("/registration")
public class UserController {

	
	private UserService userService;

	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userService = userServiceImpl;
	}
	
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	
	
	@GetMapping
	public String showRegistrationForm() {
		
		return "registration";
	}
	
//	@GetMapping
//	public String showRegistrationForm(Model model) {
//		model.addAttribute("user", new UserRegistrationDto());
//		return "registration";
//	}
	
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		
		userService.save(userRegistrationDto);
		
		return "redirect:/registration?success";
	}
}



//Registration and login