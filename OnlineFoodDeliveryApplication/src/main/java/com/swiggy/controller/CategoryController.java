package com.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.dto.Category;
import com.swiggy.service.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryServiceImpl categoryService;
	
	@PostMapping("/add")
	Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	@PutMapping("/update")
	Category updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	Category removeCategory(@PathVariable("categoryId") int categoryId) {
		return categoryService.removeCategory(categoryId);
	}
	
	@GetMapping("/find/{categoryId}")
	Category searchCategoryById(@PathVariable("categoryId") int categoryId) {
		return categoryService.searchCategoryById(categoryId);
	}
	
	@GetMapping("/all")
	List<Category> allCategories(){
		return categoryService.allCategories();
	}
	
}
