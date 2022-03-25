package com.app.shapes;

public class Circle extends BoundedShape {
	private double radius;
	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	//implement /  override inherited abstract method
	@Override
	public double area() {
		return PI*radius*radius;  //PI taking value from interface || hover mous on PI
	}
	// can circle override toString further?
	@Override
	public String toString() {
		return "Circle "+super.toString()+" radius = "+radius;
	}
	@Override
	public double perimeter() {
		return 2*PI*radius;
	}
	
}