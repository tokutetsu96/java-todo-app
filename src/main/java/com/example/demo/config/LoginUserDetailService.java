package com.example.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.entity.UserEntity;

public class LoginUserDetailService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> loginUser = userMapper.findByUsername(username);
		return loginUser.map(user -> new LoginUserDetails(user))
				.orElseThrow(() -> new UsernameNotFoundException("not found user=" + loginUser));
	}
}
