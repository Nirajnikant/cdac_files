package com.app.org;

import java.util.concurrent.atomic.AtomicInteger;

public class Emp {
	private String name, deptId;
	private int id;
	private double basic;
	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	public Emp(String name, String deptId, double basic) {
		
		this.name = name;
		this.deptId =  deptId;
		this.id = atomicInteger.incrementAndGet();
		this.basic = basic;
	}
	
	public String toString() {
		return name+" "+deptId+" "+id+" "+basic;
	}
}
