package com.quizz.service;

import java.util.Set;

import com.quizz.entities.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Set<Category> getCategories();
	public Category updateCategory(Category category);
	public Category getCategory(int id);
	public void deleteCategory(int id);

}
