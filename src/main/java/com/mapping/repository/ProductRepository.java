package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

}
