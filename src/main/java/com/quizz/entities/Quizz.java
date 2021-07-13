package com.quizz.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Quizz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizzId;
	private String title;
	private String description;
	private String maxMarks;
	
	
	private String numberOfQuestions;
	private boolean active=false;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	@OneToMany(mappedBy = "quizz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();
	
	
	
}
