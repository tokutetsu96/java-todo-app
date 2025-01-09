package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.model.form.CreateUserForm;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public void createUser(CreateUserForm form) {
		form.setPassword(passwordEncoder.encode(form.getPassword()));
		adminMapper.insertOneUser(form);
	}

}
