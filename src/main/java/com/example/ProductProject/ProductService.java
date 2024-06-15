package com.example.ProductProject;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private Map<Integer, Product> productRepository = new HashMap<>();
	private int currentId = 1;
	
	// function to save a product
	public Product createProduct(Product product) {
		product.setId(currentId++);
		productRepository.put(product.getId(), product);
		return product;
	}
	
	// function to retrieve all products
	public Map<Integer, Product> getAllProducts(){
		return productRepository;
	}
	
	// function to retrieve product by id
	public Product getProductById(int id) {
		return productRepository.get(id);
	}
	
	// update a product by id
	public Product updateProductById(int id, Product product) {
		product.setId(id);
		productRepository.put(id, product);
		return product;
	}
	
	// delete product by id
	public void deleteProductById(int id) {
		productRepository.remove(id);
	}
	
}
