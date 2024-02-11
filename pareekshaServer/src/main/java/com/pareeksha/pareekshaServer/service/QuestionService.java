package com.pareeksha.pareekshaServer.service;

import java.util.Set;

import com.pareeksha.pareekshaServer.entity.exam.Question;
import com.pareeksha.pareekshaServer.entity.exam.Quiz;


public interface QuestionService {
	
	public Question addQuestion(Question question);
	public Question updateQuestion(Question quiz);
	public Set<Question> getQuestions();
	public Question getQuestionById(Long questionId);
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	public void deleteQuestionById(Long questionId);

}
