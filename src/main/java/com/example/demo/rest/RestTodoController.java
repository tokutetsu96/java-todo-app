package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.HomeTodoDto;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class RestTodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/search")
    public List<HomeTodoDto> searchTodos(@RequestParam String query) {
        return todoService.searchTodos(query);
    }

}
