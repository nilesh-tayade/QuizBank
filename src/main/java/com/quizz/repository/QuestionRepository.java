package com.quizz.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.entities.Question;
import com.quizz.entities.Quizz;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	public Set<Question> findByQuizz(Quizz quizz);
}
