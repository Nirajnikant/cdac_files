package com.app.core;

public class Emp {
	private int id, salary;
	private String name;
	public Emp(String name, int id, int salary) {
		this.name = name;
		this.id= id;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}
	
}
