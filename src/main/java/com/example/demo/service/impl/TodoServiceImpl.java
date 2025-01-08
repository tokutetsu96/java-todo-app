package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.TodoMapper;
import com.example.demo.model.entity.TodoEntity;
import com.example.demo.model.form.CreateTodoForm;
import com.example.demo.model.form.TodoForm;
import com.example.demo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoMapper todoMapper;

	@Override
	public List<TodoEntity> getTodos() {

		List<TodoEntity> todos = todoMapper.getTodos();
		return todos;
	}

	@Override
	public TodoForm getOneTodo(Long id) {

		TodoForm todo = todoMapper.getEditTodo(id);
		return todo;
	}
	
	@Override
	public void deleteTodo(Long id) {
		
		todoMapper.deleteOneTodo(id);
	}

	@Override
	public void updateTodo(TodoForm todoForm) {

		todoMapper.updateOneTodo(todoForm);
	}
	
	@Override
	public void insertTodo(CreateTodoForm form) {
		
		todoMapper.insertOneTodo(form);
	}
}
