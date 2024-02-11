package com.pareeksha.pareekshaServer.controller;

import java.util.List;

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

import com.pareeksha.pareekshaServer.entity.exam.Category;
import com.pareeksha.pareekshaServer.entity.exam.Quiz;
import com.pareeksha.pareekshaServer.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	
	// add quiz service
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<?> getQuizById(@PathVariable("quizId") Long quizId){
		return ResponseEntity.ok(this.quizService.getQuizById(quizId));
	}
	
	@DeleteMapping("/{quizId}")
	public void deleteQuizById(@PathVariable("quizId") Long quizId){
		this.quizService.deleteQuizById(quizId);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<?> getQuizzesOfCategory(@PathVariable("categoryId") Long categoryId){
		Category category = new Category();
		category.setCategoryId(categoryId);
		return ResponseEntity.ok(this.quizService.getQuizzesByCategoryId(categoryId));
	}
	
	
	// get active quizzes
	
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes(){
		return this.quizService.getActiveQuizzes();
	}
	
	@GetMapping("category/active/categoryId")
	public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("categoryId") Long categoryId){
		Category category = new Category();
		category.setCategoryId(categoryId);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}

}
