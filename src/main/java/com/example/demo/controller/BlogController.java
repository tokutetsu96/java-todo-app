package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.model.entity.BlogEntity;
import com.example.demo.model.form.BlogForm;
import com.example.demo.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

  /* ブログ用サービス */
  @Autowired
  private BlogService blogService;

  private static final String NO_IMAGE_PATH = "/img/noimage.jpeg";

  @GetMapping("/home")
  public String showBlogPage(Model model) {
    try {

      List<BlogEntity> blogs = blogService.getAllBlogs();

      model.addAttribute("blogs", blogs);
    } catch (Exception e) {

      e.printStackTrace();
      return "error";
    }

    // ブログページを表示
    return "/blog/blog";
  }

  @GetMapping("/create-blog")
  public String showCreateBlogPage(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();

    BlogForm blogForm = new BlogForm();
    blogForm.setAuthor(username);

    model.addAttribute("blogForm", blogForm);
    return "/blog/create-blog";
  }

  @PostMapping("/create")
  public String createBlog(@ModelAttribute BlogForm blogForm) {

    MultipartFile imageFile = blogForm.getImage();

    if (!imageFile.isEmpty()) {
      try {
        String fileName = imageFile.getOriginalFilename();
        Path uploadPath = Paths.get("src/main/resources/static/img/");
        Files.createDirectories(uploadPath);

        Path filePath = uploadPath.resolve(fileName);
        imageFile.transferTo(filePath);

        blogForm.setImagePath("/img/" + fileName);
      } catch (IOException e) {
        e.printStackTrace();
        return "redirect:/blog/home";
      }
    }

    if (!StringUtils.hasLength(blogForm.getImagePath())) {
      blogForm.setImagePath(NO_IMAGE_PATH);
    }

    try {
      blogService.createBlog(blogForm);
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "redirect:/blog/home";
  }

  @GetMapping("{id}")
  public String getBlogDetail(@PathVariable Long id, Model model) {
    BlogEntity blog = blogService.getBlogById(id);
    model.addAttribute("blog", blog);
    return "blog/blog-detail";
  }

  @PostMapping("/delete/{id}")
  public String deleteBlog(@PathVariable Long id) {
    blogService.deleteBlogById(id);
    return "redirect:/blog/home";
  }

}
