package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.entity.TodoEntity;
import com.example.demo.repository.form.TodoForm;
import com.example.demo.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public String showTodoPage(Model model) {

		List<TodoEntity> todoList = todoService.getTodos();
		model.addAttribute("todos", todoList);

		return "todo/todo";
	}

	@GetMapping("/edit/{id}")
	public String showTodoEditPage(@PathVariable Long id, Model model) {

		TodoForm todo = todoService.getOneTodo(id);
		model.addAttribute("todo", todo);

		return "todo/editTodo";
	}

	@PostMapping("/update")
	public String updateTodo(@ModelAttribute TodoForm todoForm) {
		todoService.updateTodo(todoForm);

		return "redirect:/todo";

	}
}
