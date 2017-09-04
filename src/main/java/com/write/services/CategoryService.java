package com.write.services;

import com.write.models.Category;

import java.util.List;

public interface CategoryService {

	List<Category> findAllByNameAsc();

	Category getCategoryById(Integer id);

	Category saveCategory(Category category);

	void deleteCategory(Integer id);
}
