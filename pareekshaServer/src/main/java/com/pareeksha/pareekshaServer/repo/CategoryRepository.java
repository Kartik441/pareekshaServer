package com.pareeksha.pareekshaServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pareeksha.pareekshaServer.entity.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
