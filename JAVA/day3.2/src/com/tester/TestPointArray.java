package com.tester;

import java.util.Arrays;
import java.util.Scanner;

import com.app.geometry.Point2D;
import com.cdac.core.Box;

public class TestPointArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("How many points to plot?");
		Point2D[] points = new Point2D[sc.nextInt()];
		System.out.println("def contents of the array"+ Arrays.toString(points));
		System.out.println("class name "+points.getClass());
		
		//Accept points coordinates for these points. Store these details suitably.
		for(int i = 0;i<points.length;i++) {
			System.out.println("Enter x, y co-ordinates: ");
			points[i]= new Point2D(sc.nextDouble(),sc.nextDouble());
		}
		
		//Display x,y co-ordinates of all the points plotted so far.
		//for-each : getDetails
		for(Point2D p : points) { //p= points[0] --> 1sr point class instance,
			System.out.println(p.getDetails());//1 itr :
		}
		sc.close();
	}

}
