package com.example.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amazon.exception.InvalidCredentialsException;
import com.example.amazon.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public String someMethod() throws InvalidCredentialsException {
		return productService.getProducts();
	}

}
