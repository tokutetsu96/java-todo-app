package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.repository.entity.TodoEntity;
import com.example.demo.repository.form.TodoForm;

@Mapper
public interface TodoMapper {

	public List<TodoEntity> getTodos();

	public TodoForm getEditTodo(Long id);

	public void updateOneTodo(@Param("todo") TodoForm todoForm);

}
