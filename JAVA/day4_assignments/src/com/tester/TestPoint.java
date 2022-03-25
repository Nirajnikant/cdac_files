package com.tester;

import java.util.Scanner;
import com.app.geometry.*;
public class TestPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter point 1 coordinates (x,y) : ");
		double x1 = scan.nextDouble();
		double y1 = scan.nextDouble();
		System.out.println("Enter point 2 coordinates (x,y) : ");
		double x2 = scan.nextDouble();
		double y2 = scan.nextDouble();
		Point2D point1 = new Point2D(x1,y1); 
		Point2D point2 = new Point2D(x2,y2);
		String point1Info = point1.getDetails();
		String point2Info = point2.getDetails();
		System.out.println(point1Info);
		System.out.println(point2Info);
		if(point1.isEqual(point2)) {
			System.out.println("Points at the same position");
		}
		else {
			//System.out.println("Point 1 and Point 2 have different coordinates");
			double dist = point1.calculateDistance(point2);
			System.out.println("Distance between Point 1 and Point 2 = "+dist);
		}
		scan.close();
	}

}
