package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.form.CreateUserForm;
import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/create-user")
	public String showCreateUserPage(Model model, @ModelAttribute CreateUserForm form) {
		model.addAttribute("createUserForm", new CreateUserForm());
		return "/admin/create-user";
	}
	
	@PostMapping("create-user")
	public String createUser(@ModelAttribute CreateUserForm form) {

		adminService.createUser(form);
		return "redirect:/todo";
	}

}
