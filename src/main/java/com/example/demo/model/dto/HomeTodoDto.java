package com.example.demo.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class HomeTodoDto {
	
	private Long id;
	private String title;
	private Boolean isCompleted;
	private LocalDate createdAt;
	private LocalDate updatedAt;

}
