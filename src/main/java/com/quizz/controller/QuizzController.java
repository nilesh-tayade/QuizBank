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
import com.quizz.entities.Quizz;
import com.quizz.service.QuizzService;

@RestController
@RequestMapping("/quizz")
@CrossOrigin("*")
public class QuizzController {
	
	@Autowired
	private QuizzService quizzService;
	
	@GetMapping("/")
	public ResponseEntity<Set<Quizz>> getAllQuizz()
	{
		return ResponseEntity.ok(quizzService.getQuizzs());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quizz> getQuizzById(@PathVariable("id") int id )
	{
		return ResponseEntity.ok(quizzService.getQuizz(id));
	}
	
	@PostMapping("/")
	public ResponseEntity<Quizz> addQuizz(@RequestBody Quizz quizz)
	{
		return ResponseEntity.ok(quizzService.addQuizz(quizz));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Quizz> updateQuizz(@RequestBody Quizz quizz,@PathVariable("id") int id)
	{
		quizz.setQuizzId(id);
		return ResponseEntity.ok(quizzService.updateQuizz(quizz));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id )
	{
		System.out.println("In delete Quizz");
		 quizzService.deleteQuizz(id);
			System.out.println("In Quizz Deleted");
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<Set<Quizz>> getAllQuizzofCategory(@PathVariable("id") int id)
	{
		Category  category = new Category();
		category.setId(id);
		return ResponseEntity.ok(quizzService.getQuizzsofCategory(category));
	}

	
	@GetMapping("/active")
	public ResponseEntity<Set<Quizz>> getAllQuizzActive()
	{
		return ResponseEntity.ok(quizzService.getQuizzsByActive());
	}
	
	@GetMapping("/category/active/{id}")
	public ResponseEntity<Set<Quizz>> getAllQuizzofCategoryAndActivve(@PathVariable("id") int id)
	{
		Category  category = new Category();
		category.setId(id);
		return ResponseEntity.ok(quizzService.getQuizzsofCategoryAndActive(category));
	}

}
