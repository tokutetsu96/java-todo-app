package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.model.entity.BlogEntity;
import com.example.demo.model.form.BlogForm;
import com.example.demo.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

  @Autowired
  private BlogMapper blogMapper;

  @Override
  public List<BlogEntity> getAllBlogs() {
    List<BlogEntity> allBlogs = blogMapper.getAllBlogs();
    return allBlogs;
  };

  @Override
  public void createBlog(BlogForm blogForm) {
    blogMapper.createOneBlog(blogForm);
  }

  @Override
  public BlogEntity getBlogById(Long id) {
    BlogEntity blog = blogMapper.getBlogById(id);
    return blog;
  };

  @Override
  public List<BlogEntity> searchBlogs(String query) {
    List<BlogEntity> blogs = blogMapper.searchBlogs(query);
    return blogs;
  };

}
