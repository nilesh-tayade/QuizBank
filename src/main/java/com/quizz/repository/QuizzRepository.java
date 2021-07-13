package com.quizz.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.entities.Category;
import com.quizz.entities.Quizz;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Integer> {
	public Set<Quizz> findByCategory(Category category);
	
	public Set<Quizz> findByActive(boolean b);
	public Set<Quizz> findByCategoryAndActive(Category category , boolean b);

}
