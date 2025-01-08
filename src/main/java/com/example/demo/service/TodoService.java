package com.example.demo.service;

import java.util.List;

import com.example.demo.model.entity.TodoEntity;
import com.example.demo.model.form.CreateTodoForm;
import com.example.demo.model.form.TodoForm;


public interface TodoService {

	public List<TodoEntity> getTodos();

	public TodoForm getOneTodo(Long id);

	public void updateTodo(TodoForm todoForm);

	public void deleteTodo(Long id);

	public void insertTodo(CreateTodoForm form);
}
