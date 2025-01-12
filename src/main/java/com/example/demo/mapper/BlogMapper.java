package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.form.BlogForm;

@Mapper
public interface BlogMapper {
	
	public void createOneBlog(BlogForm blogForm);
}
