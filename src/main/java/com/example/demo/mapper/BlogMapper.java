package com.example.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.model.entity.BlogEntity;
import com.example.demo.model.form.BlogForm;

@Mapper
public interface BlogMapper {

  public void createOneBlog(BlogForm blogForm);

  public List<BlogEntity> getAllBlogs();

  public BlogEntity getBlogById(Long id);

  public List<BlogEntity> searchBlogs(String query);

  public void deleteBlogByid(Long id);
}
