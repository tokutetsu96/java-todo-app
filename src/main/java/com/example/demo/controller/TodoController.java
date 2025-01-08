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

import com.example.demo.model.entity.TodoEntity;
import com.example.demo.model.form.CreateTodoForm;
import com.example.demo.model.form.TodoForm;
import com.example.demo.service.TodoService;

/**
 * Todoに関連する操作を管理するコントローラークラス。
 * 
 */
@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	/**
	 * Todoの一覧ページを表示します。
	 * 
	 * @param model
	 * @return todo.html
	 */
	@GetMapping
	public String showTodoPage(Model model) {
		List<TodoEntity> todoList = todoService.getTodos();
		model.addAttribute("todos", todoList);
		return "todo/todo";
	}

	/**
	 * 指定されたIDのTodo編集ページを表示します。
	 * 
	 * @param id
	 * @param model
	 * @return editTodo.html
	 */
	@GetMapping("/edit/{id}")
	public String showTodoEditPage(@PathVariable Long id, Model model) {
		TodoForm todo = todoService.getOneTodo(id);
		model.addAttribute("todo", todo);
		return "todo/editTodo";
	}
	
	/**
	 * 指定されたIDのTodoを削除します。
	 * 
	 * @param id
	 * @return todo.html
	 */
	@PostMapping("/delete/{id}")
	public String deleteTodo(@PathVariable Long id) {
		todoService.deleteTodo(id);
		return "redirect:/todo";
	}

	/**
	 * 指定されたTodoを更新します。
	 * 
	 * @param todoForm 
	 * @return todo.htmlへのリダイレクト
	 */
	@PostMapping("/update")
	public String updateTodo(@ModelAttribute TodoForm todoForm) {
		todoService.updateTodo(todoForm);
		return "redirect:/todo";
	}
	
	/**
	 * Todo作成ページを表示します。
	 * 
	 * @return createTodo.html
	 */
	@GetMapping("/create")
	public String createTodoPage() {
		return "/todo/createTodo";
	}
	
	/**
	 * TodoをDBに登録します。
	 * 
	 * @param CareateTodoForm
	 * 
	 * @return todo.html
	 */
	@PostMapping("/create")
	public String createTodo(@ModelAttribute CreateTodoForm form) {
		
		todoService.insertTodo(form);
		
		return "redirect:/todo";
	}
	
	@GetMapping("/allTodo")
	public String showAllTodoPage() {
		return "/todo/allTodo";
	}
}
