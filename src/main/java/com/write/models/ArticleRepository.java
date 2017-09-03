package com.write.models;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
	Page<Article> findAllByOrderByDateDesc(Pageable pageable);
	Page<Article> findAllByCategory(String category, Pageable pageable);
}
