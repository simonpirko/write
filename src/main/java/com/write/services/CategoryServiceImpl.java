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
	public Page<Category> findAllByCategoryAsc(Pageable pageable) {
		return categoryRepository.findAllByOrderByCategoryAsc(pageable);
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int id) {
		categoryRepository.delete(id);
	}
}
