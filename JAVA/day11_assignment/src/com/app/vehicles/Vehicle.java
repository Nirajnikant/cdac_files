package com.app.vehicles;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Create a class Vehicle , under the package : com.app.vehicles , to represent any vehicle. 
Supply tight encapsulation.
state(data members)  : chasisNo : int , color : String , price : double, manufactureDate : Date
chasisNo  MUST be unique (non duplicate) for any vehicle (primary Key : unique chasisNo)
Get  complete state : toString
 */
public class Vehicle {
	private int chasisNo;
	private String color;
	private double price;
	private Date manufactureDate;
	//vehicle HAS-A category
	private Category1 category;
	// Establish one(vehicle) to one(Address) association between 2 entities
	private DeliveryAddress address;
	// method area
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	

	public Vehicle(int chasisNo, String color, double price, Date manufactureDate,Category1 category) {
		super();
		this.chasisNo = chasisNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.category=category;
	}
	//add overloaded ctor : to wrap PK details
	public Vehicle(int chasisNo) {
		super();
		this.chasisNo = chasisNo;
	}

	public Vehicle(int chasisNo2, String color2, double price2, Date d1, java.util.Locale.Category validatedCategory) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		String message = address==null?" Address not yet linked":address.toString();
		return "Vehicle chasisNo=" + chasisNo + ", color=" + color + ", price=" + price + ", manufactureDate="
				+ sdf.format(manufactureDate) + " category "+category +message;
	}

	
	// overrding form of equals
	// Object class API : public boolean equals(Object o) : true / false => ref eq
	// (rets true : ref1==ref2)
	@Override
	public boolean equals(Object o) {
		System.out.println("in vehicle's equals");
		if (o instanceof Vehicle)
			return chasisNo == ((Vehicle) o).chasisNo;
		return false;
		
	}
//	add a method to link delivery address to a vehicle.
	public void assignDeliveryAddress(String city, String state, String country, String zpiCode) {
		this.address = new DeliveryAddress(city, state, country, zpiCode);
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Category1 getCategory() {
		return category;
	}
	public void setCategory(Category1 category) {
		this.category = category;
	}
	//add a getter to return delivery address
	public DeliveryAddress getAddress() {
		return address;
	}
//	non static nested class
	public class DeliveryAddress {
		private String city, state, country, zipCode;
		
		public DeliveryAddress(String city, String state, String country, String zipCode) {
			this.city = city;
			this.state = state;
			this.country = country;
			this.zipCode = zipCode;
		}

		@Override
		public String toString() {
			return " DeliveryAddress [city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode
					+ "]";
		}
		
		public String getCity() {
			return this.city;
		}
	}//inner class over
	
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
	public double getChasisNo() {
		return this.chasisNo;
	}
	
}//outer class over
