package com.swiggy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Category;
import com.swiggy.repository.CategoryRepository;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category removeCategory(int categoryId) {
		Category category = categoryRepo.findById(categoryId).orElse(null);
		if(category != null) {
			categoryRepo.deleteById(categoryId);
		}
		return category;
	}

	@Override
	public Category searchCategoryById(int categoryId) {
		return categoryRepo.findById(categoryId).orElse(null);
	}

	@Override
	public List<Category> allCategories() {
		return categoryRepo.findAll(); 
	}

}
