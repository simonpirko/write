package com.write.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	List<Category> findAllByOrderByNameAsc();
}
