package com.quizz.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	
	


}
