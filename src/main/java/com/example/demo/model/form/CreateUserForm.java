package com.example.demo.model.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateUserForm {
	
	@NotEmpty(message = "username is required.")
	private String username;
	@NotEmpty(message = "password is required.")
	private String password;
	@NotEmpty(message = "role is required.")
	private String role;

}
