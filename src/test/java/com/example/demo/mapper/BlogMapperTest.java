package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.form.BlogForm;

@SpringBootTest
public class BlogMapperTest {

	@Autowired
	private BlogMapper blogMapper;

	@Test
	void testCreateOneBlog() {
		BlogForm blogForm = new BlogForm();
		blogForm.setTitle("Test Title");
		blogForm.setContent("Test Content");
		blogForm.setAuthor("Test Author");

		blogMapper.createOneBlog(blogForm);
	}
}
