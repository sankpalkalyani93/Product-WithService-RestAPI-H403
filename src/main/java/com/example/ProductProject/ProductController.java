package com.example.ProductProject;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping
	public Map<Integer, Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		return productService.updateProductById(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable int id) {
		productService.deleteProductById(id);
	}
}
