package com.quizz.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.entities.Category;
import com.quizz.entities.Quizz;
import com.quizz.repository.QuizzRepository;

@Service
public class QuizzServiceImpl implements QuizzService  {

	@Autowired
	private QuizzRepository quizzRepository;
	
	@Override
	public Set<Quizz> getQuizzs() {
		return new HashSet<>(quizzRepository.findAll());
	}

	@Override
	public Quizz addQuizz(Quizz quizz) {
		return quizzRepository.save(quizz);
	}

	@Override
	public Quizz updateQuizz(Quizz quizz) {
		return quizzRepository.save(quizz);
	}

	@Override
	public Quizz getQuizz(int id) {	
		return quizzRepository.findById(id).get();
	}

	
	@Override
	public void deleteQuizz(int id) {
		System.out.println("delete quizz Service "+id);
	Quizz quizz=	this.getQuizz(id);
		 quizzRepository.delete(quizz);;
	}

	@Override
	public Set<Quizz> getQuizzsofCategory(Category  category) {
		return quizzRepository.findByCategory(category);
	}

	@Override
	public Set<Quizz> getQuizzsByActive() {
		
		return quizzRepository.findByActive(true);
	}

	@Override
	public Set<Quizz> getQuizzsofCategoryAndActive(Category category) {
		
		return quizzRepository.findByCategoryAndActive(category, true);
	}

}
