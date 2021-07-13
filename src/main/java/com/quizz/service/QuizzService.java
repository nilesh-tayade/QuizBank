package com.quizz.service;

import java.util.Set;

import com.quizz.entities.Category;
import com.quizz.entities.Quizz;

public interface QuizzService {
	
	public Set<Quizz> getQuizzs();
	public Quizz   addQuizz(Quizz quizz);
	public Quizz   updateQuizz(Quizz quizz);
	public Quizz   getQuizz(int id);
	public void   deleteQuizz(int id);
	public Set<Quizz> getQuizzsofCategory(Category category);

	public Set<Quizz> getQuizzsByActive();

	public Set<Quizz> getQuizzsofCategoryAndActive(Category category);

	

}
