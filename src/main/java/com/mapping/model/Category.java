package com.mapping.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="category")

public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer id;
	@Column(name="category_name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
	private List<Product> product;

	
	
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Category(Integer id, String name, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}

	
	

}
