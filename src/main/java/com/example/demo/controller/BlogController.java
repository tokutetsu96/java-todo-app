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

	@Autowired
	private BlogService blogService;

	@GetMapping("/home")
	public String showBlogPage(Model model) {
		try {
			// ブログデータを取得
			List<BlogEntity> blogs = blogService.getAllBlogs();

			// モデルにブログデータを追加
			model.addAttribute("blogs", blogs);
		} catch (Exception e) {
			// エラーハンドリング（例: ログ出力やエラーページへのリダイレクト）
			e.printStackTrace();
			return "error"; // エラーページへの遷移（必要に応じて変更）
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
				// ファイル名を取得
				String fileName = imageFile.getOriginalFilename();

				// アップロード先ディレクトリを設定
				Path uploadPath = Paths.get("src/main/resources/static/img/");
				Files.createDirectories(uploadPath); // ディレクトリが存在しない場合は作成

				// ファイルを保存
				Path filePath = uploadPath.resolve(fileName);
				imageFile.transferTo(filePath);

				// `imagePath` を `BlogForm` に設定
				blogForm.setImagePath("/img/" + fileName);

			} catch (IOException e) {
				e.printStackTrace(); // エラーログを出力
			}
		}

		// BlogService で保存処理を実行
		blogService.createBlog(blogForm);

		return "redirect:/blog/home";
	}
	
	@GetMapping("{id}")
	public String getBlogDetail(@PathVariable Long id, Model model) {
	    BlogEntity blog = blogService.getBlogById(id); // サービスからブログを取得
	    model.addAttribute("blog", blog); // モデルにブログを追加
	    return "blog/blog-detail"; // 詳細ページのHTMLファイル名
	}

}
