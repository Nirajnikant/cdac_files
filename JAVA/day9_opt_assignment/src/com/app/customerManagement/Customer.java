package com.app.customerManagement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
//	Customer : name(string),email(string),password(string),registrationAmount(double),dob(Date),type (CustomerType : enum)
//	CustomerType : SILVER,GOLD,DIAMOND,PLATINUM
//	Unique ID(Primary Key ) : email  (2 customers are SAME iff their email ids are same)
	private String name, email, password;
	private double registrationAmount;
	private Date dateOfBirth;
	private CustomerType type;
	
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	
	public Customer(String name, String email, String password, double registrationAmount, Date dateOfBirth, CustomerType type1) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dateOfBirth =dateOfBirth;
		this.type = type1;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", password=" + password + ", registrationAmount="
				+ registrationAmount + ", dateOfBirth=" + dateOfBirth + ", type=" + type + "]";
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("in vehicle's equals");
		if(o instanceof Customer) 
			return this.email == ((Customer)o).email;
		return false;
	}
	

}
