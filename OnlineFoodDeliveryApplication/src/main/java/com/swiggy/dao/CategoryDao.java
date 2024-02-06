package com.swiggy.dao;

import java.util.List;

import com.swiggy.dto.Category;

public interface CategoryDao {
	Category addCategory(Category category);
	Category updateCategory(Category category);
	Category removeCategory(int categoryId);
	Category searchCategoryById(int categoryId);
	List<Category> allCategories();
}
