package com.example.demo.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.entity.UserEntity;

public class LoginUserDetails implements UserDetails {

	private final String password;
	private final String username;
	private final Collection<? extends GrantedAuthority> authorities;

	public LoginUserDetails(UserEntity user) {
		this.password = user.getPassword();
		this.username = user.getUsername();
		this.authorities = Arrays.stream(user.getRole().split(","))
				.map(role -> new SimpleGrantedAuthority(role.trim()))
				.toList();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
