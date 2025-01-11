package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.HomeTodoDto;
import com.example.demo.model.form.CreateTodoForm;
import com.example.demo.model.form.TodoForm;


public interface TodoService {

	public List<HomeTodoDto> getTodos();

	public TodoForm getOneTodo(Long id);

	public void updateTodo(TodoForm todoForm);

	public void deleteTodo(Long id);

	public void insertTodo(CreateTodoForm form);

	public List<HomeTodoDto> getAllTodos();

	public List<HomeTodoDto> searchTodos(String query);
}
