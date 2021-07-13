package com.quizz.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

import com.quizz.entities.Question;
import com.quizz.entities.Quizz;
import com.quizz.service.QuestionService;
import com.quizz.service.QuizzService;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizzService quizzService;
	
	@GetMapping("/")
	public ResponseEntity<Set<Question>> getAllQuestions()
	{
		return ResponseEntity.ok(questionService.getQuestions());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") int id )
	{
		return ResponseEntity.ok(questionService.getQuestion(id));
	}
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question )
	{
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question ,@PathVariable("id") int id)
	{
		question.setQuistionId(id);
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}

	@DeleteMapping("/{id}")
	public void deleteQuestion(@PathVariable("id") int id )
	{
		questionService.deleteQuestion(id);
	}
	
	@GetMapping("/quizz/{id}")
	public ResponseEntity<List<Question>> getQuestionsByQuizz(@PathVariable("id") int id )
	{
	Quizz quizz=	quizzService.getQuizz(id);
	Set<Question> questions=  quizz.getQuestions();
	
	List<Question> list = new ArrayList<Question>(questions);
	if(list.size()> Integer.parseInt(quizz.getNumberOfQuestions()))
	{
		list = list.subList(0,Integer.parseInt(quizz.getNumberOfQuestions()+1));
	}
	
	Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
}
