package com.example.demo.service;

import java.util.List;

import com.example.demo.model.entity.BlogEntity;
import com.example.demo.model.form.BlogForm;

public interface BlogService {
	
	public void createBlog(BlogForm blogForm);

	public List<BlogEntity> getAllBlogs();

	public BlogEntity getBlogById(Long id);
}
