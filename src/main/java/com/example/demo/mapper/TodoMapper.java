package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.dto.HomeTodoDto;
import com.example.demo.model.form.CreateTodoForm;
import com.example.demo.model.form.TodoForm;


@Mapper
public interface TodoMapper {

	public List<HomeTodoDto> getTodos();

	public TodoForm getEditTodo(Long id);

	public void updateOneTodo(@Param("todo") TodoForm todoForm);

	public void deleteOneTodo(Long id);

	public void insertOneTodo(@Param("createTodo") CreateTodoForm form);

	public List<HomeTodoDto> getAllTodos();

	public List<HomeTodoDto> searchTodos(String query);

}
