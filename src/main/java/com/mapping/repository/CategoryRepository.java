package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
