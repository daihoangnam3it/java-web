package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	@Autowired
	public ProductRepository productRepository;
	
	@GetMapping(value = "/products")
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	@PostMapping(value = "/product/create")
	public String createProduct(@RequestBody Product product) {
		Product insertedProduct = productRepository.insert(product);
		return "OK";
	}
	@PutMapping(value = "/product/update")
	public String updateProduct(@RequestBody Product product) {
		Product updatedProduct = productRepository.save(product);
		return "OK";
	}
	@GetMapping(value = "/product/{id}")
	public Optional<Product> detail_product(@PathVariable("id") String id) {
		return productRepository.findById(id);
	}
	
	@DeleteMapping(value = "/product/delete/{id}")
	public void deleteProduct(@PathVariable("id") String id) {
		productRepository.deleteById(id);
		
	}
}
