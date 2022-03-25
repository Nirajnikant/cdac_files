package com.app.geometry;

import java.lang.Math;

public class Point2D {
	private double x ;
	private double y ; 
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String getDetails() {
		return "X-coordinate = "+this.x+" Y-coordinate = "+this.y; 
	}
	
	public boolean isEqual(Point2D anotherPoint) {
		if(this.x==anotherPoint.x && this.y==anotherPoint.y) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double calculateDistance(Point2D anotherPoint)
	{
		double calDist = Math.sqrt(Math.pow((this.x-anotherPoint.x),2)+Math.pow((this.y-anotherPoint.y), 2)) ;
		return calDist;
	}
}
