package com.pareeksha.pareekshaServer.service;

import java.util.Set;

import com.pareeksha.pareekshaServer.entity.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategoryById(Long categoryId);
	public void deleteCategoryById(Long categoryId);

}
