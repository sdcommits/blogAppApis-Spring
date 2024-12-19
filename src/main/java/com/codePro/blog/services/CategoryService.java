package com.codePro.blog.services;

import java.util.*;

import com.codePro.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	//delete
	void deleteCategory(Integer categoryId);
	
	
	//get
	CategoryDto  getCategory(Integer categoryDto);
	
	
	//getAll
	List<CategoryDto> getCategories();
	

}
