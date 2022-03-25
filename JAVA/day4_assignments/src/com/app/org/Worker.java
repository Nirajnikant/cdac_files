package com.app.org;

public class Worker extends Emp{
	private int hoursWorked, hourlyRate;
	
	public Worker(String name, String deptId, double basic,int hrsWorked, int hourlyRate) {
		super(name, deptId, basic);
		this.hoursWorked = hrsWorked;
		this.hourlyRate = hourlyRate;
	}
	

	public String toString() {
		return "Worker "+super.toString()+" "+hoursWorked+" "+hourlyRate; 
	}
	
	public String getHrRate() {
		return "Hourly Rate: "+this.hourlyRate;
	}
}
