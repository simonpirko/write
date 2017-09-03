package com.write.controllers;

import com.write.models.Article;
import com.write.models.Category;
import com.write.services.ArticleService;
import com.write.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping(path = "/admin")
public class AdminController {

	private CategoryService categoryService;
	private ArticleService articleService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping(path = "/admin")
	public ModelAndView adminPage(Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		Page<Category> categoryList = categoryService.findAllByNameAsc(pageable);
		Page<Article> articleList = articleService.findAllByDateDesc(pageable);
		mav.addObject("category", categoryList.getContent());
		mav.addObject("categoryTotal", categoryList.getTotalElements());
		mav.addObject("articleTotal", articleList.getTotalElements());
		mav.setViewName("admin");
		return mav;
	}

	@RequestMapping(path = "/admin/new/category")
	public String createCategory(Model model) {
//		ModelAndView mav = new ModelAndView();
		model.addAttribute("category", new Category());
//		mav.setViewName("admin");
		return "newcategory";
	}

	@RequestMapping(path = "/admin/new/save", method = RequestMethod.POST)
	public String saveCategory(Category category) {
//		ModelAndView mav = new ModelAndView();
		categoryService.saveCategory(category);
//		mav.setViewName("index");
		return "redirect:/admin";
	}

}
