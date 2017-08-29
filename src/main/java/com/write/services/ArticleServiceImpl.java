package com.write.services;

import com.write.models.Article;
import com.write.models.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
	private ArticleRepository articleRepository;

	@Autowired
	public void setArticleRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public Page<Article> findAllByDateDesc(Pageable pageable) {
		return articleRepository.findAllByOrderByDateDesc(pageable);
	}

	@Override
	public Article getArticleById(Long id) {
		return articleRepository.findOne(id);
	}

	@Override
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void deleteArticle(Long id) {
		articleRepository.delete(id);
	}
}
