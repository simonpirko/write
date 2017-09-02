package com.write.services;

import com.write.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

	Page<Category> findAllByNameAsc(Pageable pageable);

	Category getCategoryById(Integer id);

	Category saveCategory(Category category);

	void deleteCategory(Integer id);
}
