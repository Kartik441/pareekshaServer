package com.pareeksha.pareekshaServer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pareeksha.pareekshaServer.entity.exam.Category;
import com.pareeksha.pareekshaServer.entity.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	public List<Quiz> findByCategory(Category category);
	public List<Quiz> findByActive(boolean active);
	public List<Quiz> findByCategoryAndActive(Category category, boolean active);

}
