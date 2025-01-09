package com.example.demo.model.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateUserForm {
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String role;

}
