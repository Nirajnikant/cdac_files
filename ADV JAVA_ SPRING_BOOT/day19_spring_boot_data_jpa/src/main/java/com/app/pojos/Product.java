package com.app.pojos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	private Integer pid;
	private String name;
	private double price;
	private LocalDate expDate;

}
