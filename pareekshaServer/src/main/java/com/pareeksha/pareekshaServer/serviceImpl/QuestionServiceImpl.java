package com.pareeksha.pareekshaServer.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.pareeksha.pareekshaServer.entity.exam.Question;
import com.pareeksha.pareekshaServer.entity.exam.Quiz;
import com.pareeksha.pareekshaServer.repo.QuestionRepository;
import com.pareeksha.pareekshaServer.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	private QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestionById(Long questionId) {
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestionById(Long questionId) {
		this.questionRepository.deleteById(questionId);
		
	}

}
