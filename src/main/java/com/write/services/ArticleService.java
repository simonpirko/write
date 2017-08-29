package com.write.services;

import com.write.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

	Page<Article> findAllByDateDesc(Pageable pageable);

	Article getArticleById(Long id);

	Article saveArticle(Article article);

	void deleteArticle(Long id);
}
