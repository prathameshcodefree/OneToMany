package com.mapping.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.model.Category;
import com.mapping.repository.CategoryRepository;


@Service
public class CategroyService {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	
	public String deleteById(Integer id) {
		categoryRepository.deleteById(id);
		return "Succesfully deleted";
	}

}
