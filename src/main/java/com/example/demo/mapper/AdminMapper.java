package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.form.CreateUserForm;

@Mapper
public interface AdminMapper {

	void insertOneUser(@Param("form") CreateUserForm form);

}
