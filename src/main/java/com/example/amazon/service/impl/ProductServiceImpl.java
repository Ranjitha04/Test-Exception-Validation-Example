package com.example.amazon.service.impl;

import org.springframework.stereotype.Service;

import com.example.amazon.exception.ProductNotFoundException;
import com.example.amazon.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Override
	public String getProducts() {
		// TODO Auto-generated method stub
		throw new ProductNotFoundException("Products Not Found");
	}

}
