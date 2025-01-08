package com.example.demo.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.entity.UserEntity;



@Mapper
public interface UserMapper {
	
	Optional<UserEntity> findByUsername(String username);
}
