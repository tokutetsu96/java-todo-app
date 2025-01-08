package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String showIndexPage() {
		return "/index";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {

		return "/login";
	}

}
