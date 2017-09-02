package com.write.models;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	Page<Category> findAllByOrderByNameAsc(Pageable pageable);
}
