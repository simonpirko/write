package com.write.controllers;

import com.write.components.PageWrapper;
import com.write.models.Article;
import com.write.models.Category;
import com.write.services.ArticleService;
import com.write.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class IndexController {

	private ArticleService articleService;
	private CategoryService categoryService;

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(path = "/")
	public ModelAndView index(Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		Page<Article> articles = articleService.findAllByDateDesc(pageable);
		List<Category> categories = categoryService.findAllByNameAsc();
		PageWrapper<Article> page = new PageWrapper<>(articles, "");
		mav.addObject("article", articles.getContent());
		mav.addObject("category", categories.toArray());
		mav.addObject("page", page);
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(path = "/{category}")
	public ModelAndView showCategory(@PathVariable String category, Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		Page<Article> articles = articleService.findAllByCategoryOrderByDateDesc(category, pageable);
		List<Category> categories = categoryService.findAllByNameAsc();
		PageWrapper<Article> page = new PageWrapper<>(articles, "");
		mav.addObject("article", articles.getContent());
		mav.addObject("category", categories.toArray());
		mav.addObject("page", page);
		mav.setViewName("index");
		return mav;
	}
}
