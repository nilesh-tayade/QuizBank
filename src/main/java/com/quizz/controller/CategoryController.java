package com.quizz.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizz.entities.Category;
import com.quizz.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<Set<Category>> getCategories()
	{
		return   ResponseEntity.ok( categoryService.getCategories());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable("id") int id )
	{
		return   ResponseEntity.ok( categoryService.getCategory(id));
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		return   ResponseEntity.ok( categoryService.addCategory(category));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category,@PathVariable("id") int id)
	{
		category.setId(id);
		return   ResponseEntity.ok( categoryService.updateCategory(category));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") int id )
	{
		categoryService.deleteCategory(id);
		return   ResponseEntity.ok("Deleted Successfully");
	}
			
}
