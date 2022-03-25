package com.app.service;

import static java.time.LocalDate.of;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojos.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return Arrays.asList(new Product(101, "Bread", 50, of(2022, 2, 20)),
				new Product(10, "Chips", 150, of(2022, 3, 20)), 
				new Product(200, "Oil", 250, of(2022, 10, 20)));
	}

}
