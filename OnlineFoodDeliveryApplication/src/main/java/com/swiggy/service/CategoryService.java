package com.swiggy.service;

import java.util.List;

import com.swiggy.dto.Category;

public interface CategoryService {
	Category addCategory(Category category);
	Category updateCategory(Category category);
	Category removeCategory(int categoryId);
	Category searchCategoryById(int categoryId);
	List<Category> allCategories();
}
