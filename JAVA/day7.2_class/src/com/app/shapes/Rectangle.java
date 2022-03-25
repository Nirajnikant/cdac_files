package com.app.shapes;

public class Rectangle extends BoundedShape {
	private double length, breadth;
	public Rectangle(int x, int y, double length, double breadth) {
		super(x, y);
		this.length = length;
		this.breadth = breadth;
	}
	
	@Override
	public double area() {
		return length*breadth;
	}
	
	@Override
	public String toString() {
		return "Rectangle "+super.toString()+" lenght = "+length+" breadth = "+breadth;
	}

	@Override
	public double perimeter() {
		return 2*(length + breadth);
	}

}