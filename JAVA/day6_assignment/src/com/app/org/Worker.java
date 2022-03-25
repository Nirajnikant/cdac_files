package com.app.org;

public class Worker extends Emp{
	private int hoursWorked;
	private double hourlyRate;
	public Worker(String name, String deptId, double basic, int hrsWorked, double hourlyRate) {
		super(name,deptId,basic);
		this.hoursWorked = hrsWorked;
		this.hourlyRate = hourlyRate;
	}
	@Override
	public String toString() {
		return super.toString()+" "+hoursWorked+" "+hourlyRate;
	}
	@Override
	public double netSalary() {
		return getBasic()+(hoursWorked*hourlyRate); 
	}
	public String getHourlyRate() {
		return "Hourly Rate "+hourlyRate;
	}
}