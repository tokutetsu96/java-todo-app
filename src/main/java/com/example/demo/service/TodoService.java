package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.entity.TodoEntity;
import com.example.demo.repository.form.TodoForm;

public interface TodoService {

	public List<TodoEntity> getTodos();

	public TodoForm getOneTodo(Long id);

	public void updateTodo(TodoForm todoForm);
}
