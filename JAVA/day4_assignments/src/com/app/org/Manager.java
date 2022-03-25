package com.app.org;

public class Manager extends Emp{
	private int performanceBonus;
	
	public Manager(String name, String deptId, double basic, int perBonus){
		super(name,deptId, basic);
		performanceBonus = perBonus;
	}
	
	public String toString() {
		return "Manager " + super.toString() +" "+performanceBonus;
	}
	
	public String gerPerBonus() {
		return "Performance Bonus: "+ performanceBonus;
	}
}
