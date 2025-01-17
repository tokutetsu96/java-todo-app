package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.TodoMapper;
import com.example.demo.model.dto.HomeTodoDto;
import com.example.demo.model.form.CreateTodoForm;
import com.example.demo.model.form.TodoForm;
import com.example.demo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoMapper todoMapper;

  @Override
  public List<HomeTodoDto> getTodos() {

    List<HomeTodoDto> todos = todoMapper.getTodos();
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

  @Override
  public List<HomeTodoDto> getAllTodos() {

    List<HomeTodoDto> allTodos = todoMapper.getAllTodos();
    return allTodos;
  }

  @Override
  public List<HomeTodoDto> searchTodos(String query) {
    List<HomeTodoDto> todos = todoMapper.searchTodos(query);
    return todos;
  }

  @Override
  public void updateCompleteTodoById(Long id) {
    todoMapper.updateCompleteTodoById(id);
  };
}
