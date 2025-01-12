package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.form.BlogForm;
import com.example.demo.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@GetMapping("/home")
	public String showBlogPage() {
		return "/blog/blog";
	}

	@GetMapping("/create-blog")
	public String showCreateBlogPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		BlogForm blogForm = new BlogForm();
		blogForm.setAuthor(username);

		model.addAttribute("blogForm", blogForm);
		return "/blog/create-blog";
	}

	@PostMapping("/create")
	public String createBlog(@ModelAttribute BlogForm blogForm) {

		blogService.createBlog(blogForm);

		return "redirect:/blog/home";
	}
}
