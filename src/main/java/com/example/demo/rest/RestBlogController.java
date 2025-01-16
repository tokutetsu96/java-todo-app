package com.example.demo.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.entity.BlogEntity;
import com.example.demo.service.BlogService;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController {

  @Autowired
  private BlogService blogService;

  @GetMapping("/search")
  public List<BlogEntity> searchTodos(@RequestParam String query) {
    return blogService.searchBlogs(query);
  }

}
