package com.mapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mapping.model.Product;


import com.mapping.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product getProductById(Integer id) {

		return productRepository.findById(id).orElse(null);
	}

	public Product addProduct(Product product) {
		return  productRepository.save(product);
	}

	public String deleteProductById(Integer id) {
		productRepository.deleteById(id);
		return "Succesfully deleted";
	}

}
