package com.pareeksha.pareekshaServer.service;

import java.util.List;
import java.util.Set;

import com.pareeksha.pareekshaServer.entity.exam.Category;
import com.pareeksha.pareekshaServer.entity.exam.Quiz;

public interface QuizService {
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzes();
	public Quiz getQuizById(Long quizId);
	public void deleteQuizById(Long quizId);
	public List<Quiz> getQuizzesByCategoryId(Long categoryId);
	public List<Quiz> getActiveQuizzes();
	public List<Quiz> getActiveQuizzesOfCategory(Category category);
	

}
