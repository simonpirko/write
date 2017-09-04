package com.write.services;

import com.write.models.Category;
import com.write.models.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepository;

	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAllByNameAsc() {
		return categoryRepository.findAllByOrderByNameAsc();
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Category saveCategory(Category category) {
		category.setName(category.getName().toLowerCase());
		category.setUrl("/" + category.getName());
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryRepository.delete(id);
	}
}
