package com.example.demo.model.entity;

import lombok.Data;

@Data
public class UserEntity {

	private Long id;
	private String username;
	private String password;
	private String role;

}
