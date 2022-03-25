package com.app.vehicles;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehicle {
//	chasisNo : int , color : String , price : double, manufactureDate : 
//		chasisNo  MUST be unique (non duplicate) for any vehicle (primary Key : unique chasisNo)
	private int chasisNo;
	private String color;
	private double price;
	private Date manufactureDate;
//	method area 
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	public Vehicle(int chasisNo, String color, double price,Date manufactureDate) {
		this.chasisNo = chasisNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
	}
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ",color="+color+",price="+price+",manufactureDate="+sdf.format(manufactureDate)+"]";
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("in vehicle's equals");
		if(o instanceof Vehicle)
			return this.chasisNo == ((Vehicle)o).chasisNo;
		return false;
	}

}
