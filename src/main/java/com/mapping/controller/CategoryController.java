package com.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.model.Category;
import com.mapping.model.Product;
import com.mapping.service.CategroyService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategroyService categroyservice;

	@GetMapping

	public ResponseEntity<List<Category>> getallCategory() {

		List<Category> ls = categroyservice.getAllCategory();
		if (ls.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(ls,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		try {
			Category category1 = categroyservice.addCategory(category);
			return new ResponseEntity<>(category1, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id)
	{
		
		if(id==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Category category=categroyservice.getCategoryById(id);
		
		return new ResponseEntity<>(category,HttpStatus.OK);
	
	}
	
}
