package com.example.demo.model.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TodoEntity {

	private Long id;
	private String title;
	private String description;
	private Boolean isCompleted;
	private LocalDate createdAt;
	private LocalDate updatedAt;
}
