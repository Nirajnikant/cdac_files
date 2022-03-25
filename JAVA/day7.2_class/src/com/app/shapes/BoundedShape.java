package com.app.shapes;

public abstract class BoundedShape implements Computable{
	private int x, y;
	
	public BoundedShape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//toString
	@Override
	public String toString() {
		return "x = "+x+" y = "+y;
	}
//	//area : abstract				 | not rew. as we are already implementing 
//	public abstract double area();   | abstract method from interface Computable
	
}