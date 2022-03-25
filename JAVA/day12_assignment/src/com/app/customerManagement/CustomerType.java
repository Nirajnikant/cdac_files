package com.app.customerManagement;

public enum CustomerType {
	SILVER(500), GOLD(1000), DIAMOND(1500),PLATINUM(2000);
	
	private double regAmount;

	CustomerType(double regAmount) {
		//super(name(),ordinal());
		this.regAmount = regAmount;
	}
	
	@Override
	public String toString() {
		return name()+" @ "+regAmount;
	}
	
	public double getRegAmount() {
		return regAmount;
	}
}
