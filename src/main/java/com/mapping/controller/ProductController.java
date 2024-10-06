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

import com.mapping.model.Category;
import com.mapping.model.Product;
import com.mapping.service.CategroyService;
import com.mapping.service.ProductService;

@Controller
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategroyService categroyService;

	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product>  listOfProduct =  productService.getAllProduct();
		if(listOfProduct.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(listOfProduct,HttpStatus.OK);
		
}
	
	@PostMapping
	public ResponseEntity<?>  addProduct(@RequestBody Product product){
		
		
		Category category = categroyService.getCategoryById(product.getCategory().getId());
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setCategory(category);
		Product product1 = productService.addProduct(product);
		
		if(product1==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>( product1,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id)
	{
		
		if(id==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Product product=productService.getProductById(id);
		
		return new ResponseEntity<>(product,HttpStatus.OK);
	
	}

}
