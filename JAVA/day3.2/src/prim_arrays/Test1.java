package prim_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// int count;
//		System.out.println(count); // error Method local variable are uninitilized
		Scanner sc = new Scanner(System.in); //sc class type of a ref which is refering to scanner class
		System.out.println("How many nos (double) you want to enter?");
		double[] data;  //data : ref type of a var, array type of reference, 
					    //--->4/8/16/ bytes allocated on the stack for storing the ref. 
						//this will refer to array object holding prims: double
		data = new double[sc.nextInt()];// 1. [D class will be loaded in Meth area, aaray obj in heap creating array type of object
		//dispaly array contents : def inited contents;
		//for-each 
		System.out.println("def contents of double[]");
		for(double d : data )//d=data[0],d=data[1]...d=data[data.length-1]
			System.out.println(d);
		//display the name of yhr loaded class for this double[]
		System.out.println("Name of the cis loaded "+data.getClass());//[D  compiler created class
		double[] data2 = new double[100];//no new class loading, new array obj --> data 2
		System.out.println("Name of the cis loaded "+data2.getClass());//[D
		double[][] data3 = new double[3][4];// new class loaded : [[D
		System.out.println("Name of the cis loaded "+data3.getClass());
		//Accept data from User(scanner) & store it in the array : for
		for(int i=0;i<data.length;i++) {
			System.out.println("Enter array data");
			data[i] = sc.nextDouble();
			
		}
		//display : for each
		System.out.println("contents of double[] after init");
		for(double d : data )//d=data[0],d=data[1]...d=data[data.length-1]
			System.out.println(d);
		
		System.out.println(Arrays.toString(data));
		sc.close();
	}

}
