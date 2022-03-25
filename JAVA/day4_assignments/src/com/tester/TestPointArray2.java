package com.tester;

import java.util.Scanner;

import com.app.geometry.Point2D;

public class TestPointArray2 {

	public static void main(String[] args) {
		int num1=0,num2=0,option,ex,count = 0;
		Scanner sc = new Scanner(System.in);
        System.out.println("How many points to be plotted?");
        Point2D[] points = new Point2D[sc.nextInt()];
        
		do {
            
            System.out.println("Enter your choice from the following menu:");
            System.out.printf("1.Plot a new point \n2. Display all points plotted so far. \n3. Test equality of 2 points \n4. Calculate distance \n5. Exit");
            option = sc.nextInt();
            //Point2D[] points;
            if(option==5) {
            	System.out.println("Exiting now");
            	break;
            }
//                System.out.println("How many points to be plotted?");
//                points = new Point2D[sc.nextInt()];
            	  
            
//            else
//            break;
            switch(option)
            {
                case 1:
                	if(count<points.length) {
	                	System.out.println("Enter x, y co-ordinates: ");
	                	points[count] = new Point2D(sc.nextDouble(),sc.nextDouble());
	                	count++;
	                	break;
                	}
                	else {
                		System.out.println("Points array is full");
                		break;
                	}
                case 2:
                	System.out.println("Points plotted so far are: ");
                	int i = 0;
                	for(Point2D p : points ) {
                		if(i<count) {
                			System.out.println(p.getDetails());
                			i++;
                		}
                		else break;
                	}
                	break;
                case 3:
                	System.out.println("Test Equality of two points");
                	System.out.println("Enter indices of the points to be tested");
                	int p1 = sc.nextInt();
                	int p2 = sc.nextInt();
                	if(!(boundryCheck(p1, p2,count,points.length))) {
                		break;
                	}
                	else {
                		System.out.println(points[p1].isEqual(points[p2])?"Points are Equal":"Points are not equal");
                		break;
                	}
                case 4: 
                	System.out.println("4. Calculate Distance");
                	System.out.println("Enter indices of the points to be tested");
                	int id1 = sc.nextInt();
                	int id2 = sc.nextInt();
                	if(!(boundryCheck(id1, id2,count,points.length))) {
                		break;
                	}
                	else {
                		System.out.println("Distance between Point 1 and Point 2 = "+points[id1].calculateDistance(points[id2]));
                	}
                	break;
                case 5: break;
                default: System.out.println("Invalid choice");
            }
//            System.out.println("Do you want to continue?1.Yes 2.No");
//            ex=sc.nextInt();
            
        }while(true);
		sc.close();
	}

	private static boolean boundryCheck(int p1, int p2, int count, int len) {
		if(p1>count || p2>count) {
			if(p1>len || p2>len) {
				System.out.println("invalid index --out of range");
				return false;
			}
			else {
				System.out.println("invalid index -- no point plotted here.");
				return false;
			}
		}
		else
			return true;
		
	}

}
//2.2 Add a menu , Run the application till user chooses option 5 (exit)
//
//1 Plot a new point
//I/P --index , x & y
//
//2 Display all points plotted so far. (Use for-each)
//
//
//3. Test equality of 2 points
//I/P : index1 , index 2
//
//4. Calculate distance
//I/P strt , end point indexes.
//
//
//5. Exit