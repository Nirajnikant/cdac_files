package com.app.org;

public class Mgr extends Emp{
	private double performanceBonus;
	public Mgr(String name, String deptId, double basic, double performanceBonus) {
		super(name, deptId, basic);
		this.performanceBonus = performanceBonus;
	}
	@Override
	public String toString() {
		return "Manager " + super.toString() +" "+ performanceBonus;
	}
	@Override
	public double netSalary() {
		return (performanceBonus+getBasic()); 
	}
	public String getPerformanceBonus() {
		return "Performance Bonus = "+performanceBonus;
	}
}
