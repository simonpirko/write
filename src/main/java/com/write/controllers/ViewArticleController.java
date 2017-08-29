package com.write.controllers;

import com.write.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/article")
public class ViewArticleController {

	private ArticleService articleService;

	@Autowired
	public void setArticleService(ArticleService articleService){
		this.articleService = articleService;
	}

	@RequestMapping(path = "/{id}")
	public String showArticle(@PathVariable Long id, Model model){
		model.addAttribute("article", articleService.getArticleById(id));
		return "viewarticle";
	}
}
