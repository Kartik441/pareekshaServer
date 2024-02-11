package com.pareeksha.pareekshaServer.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

import com.pareeksha.pareekshaServer.entity.exam.Question;
import com.pareeksha.pareekshaServer.entity.exam.Quiz;
import com.pareeksha.pareekshaServer.service.QuestionService;
import com.pareeksha.pareekshaServer.service.QuizService;


@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	
	// add quiz service
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQuiz(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(this.questionService.getQuestions());
	}
	
	// Get all questions of any quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId){
//		Quiz quiz = new Quiz();
//		quiz.setQuizId(quizId);
//		return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));
		Quiz quiz = this.quizService.getQuizById(quizId);
		List<Question> allQuestions = new ArrayList<>(quiz.getQuestions());
		int noOfQuestions = quiz.getNumberOfQuestions();
		if(allQuestions.size() >= noOfQuestions) {
			allQuestions = allQuestions.subList(0, noOfQuestions+1);
		}
		Collections.shuffle(allQuestions);
		
		allQuestions.forEach(q->{
			q.setAnswer("");
		});
		
		return  ResponseEntity.ok(allQuestions);
		
		
	}
	
	// Get all questions of any quiz
		@GetMapping("/quiz/all/{quizId}")
		public ResponseEntity<?> getAllQuestionsOfQuizAdmin(@PathVariable("quizId") Long quizId){
			Quiz quiz = new Quiz();
			quiz.setQuizId(quizId);
			return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));
		}
	
	@GetMapping("/{questionId}")
	public ResponseEntity<?> getQuizById(@PathVariable("questionId") Long questionId){
		return ResponseEntity.ok(this.questionService.getQuestionById(questionId));
	}
	
	@DeleteMapping("/{questionId}")
	public void deleteQuizById(@PathVariable("questionId") Long questionId){
		this.questionService.deleteQuestionById(questionId);
	}
	
	
	//evaluate quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evaulateQuiz(@RequestBody List<Question> questions){
		//System.out.println(questions);
		double marksGot = 0;
		int correctAnswers = 0;
		int attempted = 0;
		
		for(Question q:questions){
			Question question = this.questionService.getQuestionById(q.getQuestionId());
			
			if(q.getSelectedAnswer() == null){
				continue;
			}
			attempted++;
			
			if(question.getAnswer().trim().equals(q.getSelectedAnswer().trim())) {
				// answer is correct
				correctAnswers++;
				
				double marksPerQuestion = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks());
				marksGot += marksPerQuestion;
			}
			
			
		}
		
		Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswers",correctAnswers, "attempted",attempted);
		
		return ResponseEntity.ok(map);
	}

}
