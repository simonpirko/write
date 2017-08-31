package com.write.services;

import com.write.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

	Page<Article> findAllByDateDesc(Pageable pageable);

	Article getArticleById(Integer id);

	Article saveArticle(Article article);

	void deleteArticle(Integer id);
}
