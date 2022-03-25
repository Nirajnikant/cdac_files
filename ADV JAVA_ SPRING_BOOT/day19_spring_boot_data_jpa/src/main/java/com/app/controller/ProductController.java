package com.app.controller;

import static java.time.LocalDate.of;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pojos.*;
import com.app.service.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	// dependency
	@Autowired
	private IProductService productService;

	public ProductController() {
		System.out.println("in ctor of " + getClass());
	}

	// add a method to send list of all products
	@GetMapping
	public @ResponseBody List<Product> fetchAllProducts() {
		System.out.println("in get all products");
		return productService.getAllProducts();
	}

	// add a method to return product details specified by product id
	@GetMapping("/{productId}")
	public @ResponseBody Product getProductDetails(@PathVariable int productId) {
		// returning dummy product details
		return new Product(10, "Wheat", 100, of(2020,1,1));
	}

}
