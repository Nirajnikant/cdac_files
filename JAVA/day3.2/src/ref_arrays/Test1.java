package ref_arrays;

import java.util.Arrays;
import java.util.Scanner;

import com.cdac.core.Box;

//Add Box class into "com.cdac.core"
//Create a tester class  : TestBoxArray : "ref_arrays"
//
//Objective : Ask user(client) , how many boxes to make ?
//Accept Box dims for these boxes.
//Store these details suitably.
//
//1. Display using single for-each loop, box dims n volume

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("How many boxes?");
		Box[] boxes;//boxes : ref type var, on stack : bytes allocated as per JVM's specs.
		boxes = new Box[sc.nextInt()]; //ip as 4, class loaded : [Lcom.cdac.core.Box, obj : 1(array)
		//slots : CP --> [Lcom.cdac.core.Box, length=4, 4 more slots0...3 : null
		System.out.println("def contents of the array"+ Arrays.toString(boxes));
		System.out.println("class name "+boxes.getClass());
		
		//Accept Box dims for these boxes. Store these details suitably.
		for(int i = 0;i<boxes.length;i++) {
			System.out.println("Enter box dims w d h ");
			boxes[i]= new Box(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		}
		//how many objects in the heap, excluding scanner = 5(1: array, 4: BOX)
		
		for(Box b : boxes) { //b= boxes[0] --> 1sr box class instance,
			System.out.println(b.getBoxDetails());//1 itr :
			System.out.println("Vol="+b.getComputedVolume());
		}
		sc.close();
	}

}
