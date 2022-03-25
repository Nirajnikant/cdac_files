package com.app.org;

public abstract class Emp {
	
	private String deptId, name;
	private int id;
	private double basic;
	private static int idGenerator;
	public static int offset;
	static {
		offset = 100;
		idGenerator = offset;
	}
	
	public Emp(String name, String deptId, double basic) {
		this.name = name;
		this.deptId = deptId;
		this.basic = basic;
		this.id = idGenerator++;
	}
	@Override
	public String toString() {
		return name+" "+id+" "+deptId+" "+basic;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public abstract double netSalary();
}