package com.pareeksha.pareekshaServer.controller;

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
import com.pareeksha.pareekshaServer.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		this.categoryService.addCategory(category);
		return ResponseEntity.ok(category);
	}
	
	
	// Get category By id
	@GetMapping("/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") Long categoryId ) {
		return this.categoryService.getCategoryById(categoryId);
	}
	
	
	// Get all Categories 
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.updateCategory(category);
	}
	
	//delete category
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		this.categoryService.deleteCategoryById(categoryId);
	}
	
	
	
	
	
	
	

}
