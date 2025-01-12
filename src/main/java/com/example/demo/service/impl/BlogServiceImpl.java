package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.model.form.BlogForm;
import com.example.demo.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	public void createBlog(BlogForm blogForm) {
		blogMapper.createOneBlog(blogForm);
	}

}
