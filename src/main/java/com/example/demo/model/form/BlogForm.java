package com.example.demo.model.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BlogForm {

	private String title;
	private String content;
	private String author;
	
	private MultipartFile image;
	private String imagePath;
}
