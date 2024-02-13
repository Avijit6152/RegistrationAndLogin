package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
}


// MAIN CONTROLLER CLASS
//Learn Spring Security
//Some Problem like bydefault login page is openning
