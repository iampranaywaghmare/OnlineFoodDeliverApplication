package com.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.dao.CategoryDaoImpl;
import com.swiggy.dto.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDaoImpl categoryDao;
	
	@Override
	public Category addCategory(Category category) {
		return categoryDao.addCategory(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryDao.updateCategory(category);
	}

	@Override
	public Category removeCategory(int categoryId) {
		return categoryDao.removeCategory(categoryId);
	}

	@Override
	public Category searchCategoryById(int categoryId) {
		return categoryDao.searchCategoryById(categoryId);
	}

	@Override
	public List<Category> allCategories() {
		return categoryDao.allCategories();
	}

}
