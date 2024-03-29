package com.pareeksha.pareekshaServer.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pareeksha.pareekshaServer.entity.exam.Question;
import com.pareeksha.pareekshaServer.entity.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	Set<Question> findByQuiz(Quiz quiz);

}
