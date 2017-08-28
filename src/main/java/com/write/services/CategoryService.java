package com.write.services;

import com.write.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

	Page<Category> findAllByCategoryAsc(Pageable pageable);

	Category getCategoryById(int id);

	Category saveCategory(Category category);

	void deleteCategory(int id);
}
