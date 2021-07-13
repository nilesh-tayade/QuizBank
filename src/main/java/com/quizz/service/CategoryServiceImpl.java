package com.quizz.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.entities.Category;
import com.quizz.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	

	@Override
	public Set<Category> getCategories() {
		 return new HashSet<Category>(categoryRepository.findAll());
	}
	

	@Override
	public Category updateCategory(Category category) {
			return categoryRepository.save(category);
	}

	@Override
	public Category getCategory(int id) {
		return categoryRepository.findById(id).get();
	}

	
	@Override
	public void deleteCategory(int id) {

		categoryRepository.deleteById(id);
	}

}
