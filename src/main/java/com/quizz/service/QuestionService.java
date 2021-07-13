package com.quizz.service;

import java.util.Set;

import com.quizz.entities.Question;
import com.quizz.entities.Quizz;

public interface QuestionService {

	public Set<Question> getQuestions();
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Question getQuestion(int id);
	public void deleteQuestion(int id);
	public Set<Question> getQuestionOfQuizz(Quizz quizz);


}
