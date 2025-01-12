package com.example.demo.model.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BlogEntity {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	private LocalDate createdAt;
	private LocalDate updatedAt;
}
