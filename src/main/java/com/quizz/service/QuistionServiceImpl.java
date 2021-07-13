package com.quizz.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.entities.Question;
import com.quizz.entities.Quizz;
import com.quizz.repository.QuestionRepository;

@Service
public class QuistionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Override
	public Set<Question> getQuestions() {
		return new HashSet<Question>(questionRepository.findAll());
	}

	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question getQuestion(int id) {
		return questionRepository.findById(id).get();
	}

	@Override
	public void deleteQuestion(int id) {
		questionRepository.deleteById(id);
	}

	@Override
	public Set<Question> getQuestionOfQuizz(Quizz quizz) {

		return questionRepository.findByQuizz(quizz);
	}

}
