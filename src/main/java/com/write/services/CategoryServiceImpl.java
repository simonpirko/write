package com.write.services;

import com.write.models.Category;
import com.write.models.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepository;

	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Page<Category> findAllByNameAsc(Pageable pageable) {
		return categoryRepository.findAllByOrderByNameAsc(pageable);
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Category saveCategory(Category category) {
		category.setLabel(category.getName().toLowerCase());
		category.setUrl("/" + category.getName().toLowerCase());
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryRepository.delete(id);
	}
}
