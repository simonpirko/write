package com.write.controllers;

import com.write.models.Article;
import com.write.models.Category;
import com.write.services.ArticleService;
import com.write.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/article")
public class ArticleController {
	private ArticleService articleService;
	private CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService){
		this.categoryService = categoryService;
	}

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping(path = "/{id}")
	public String viewArticle(@PathVariable Integer id, Model model) {
		model.addAttribute("article", articleService.getArticleById(id));
		return "viewarticle";
	}

	@RequestMapping(path = "/edit/{id}")
	public String editArticle(@PathVariable Integer id, Model model) {
		model.addAttribute("article", articleService.getArticleById(id));
		return "editarticle";
	}

	@RequestMapping(path = "/new")
	public String newArticle(Model model, Pageable pageable) {
//		ModelAndView mav = new ModelAndView();
		model.addAttribute("article", new Article());
		List<Category> categories = categoryService.findAllByNameAsc();
		model.addAttribute("category", categories.toArray());
		return "newarticle";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String saveArticle(Article article) {
//		ModelAndView mav = new ModelAndView();
		articleService.saveArticle(article);
		return "redirect:/article/" + article.getId();
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteArticle(@PathVariable Integer id) {
		articleService.deleteArticle(id);
		return "redirect:/";
	}
}
