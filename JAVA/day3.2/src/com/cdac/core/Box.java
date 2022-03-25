package com.cdac.core;
public class Box 
{
  //state : DATA : non static data members : mem allocated in heap : after instance creation --instance variables
  //tight encapsulation : data hiding : private
   private double width,depth,height;
   //parameterized ctor to init complete state of the Box
   public Box(double w,double d,double height)
   {
	   width=w;
	   depth=d;
	   this.height=height;
   }
   //add another overloaded  ctor to init state of a cube
   Box(double side)
   {
	   //implicit keyowrd : this
	//   width=depth=height=side;
	 this(side,side,side);
	   
   }
   //add another ctor : to init state =-1
   Box()
   {
	    //width=depth=height=-1;
		this(-1);
		
   }
   //Actions : 1. To return Box details in String form (dimensions of Box)
   //implicit arg passed ": "this=b1"
  public String getBoxDetails()
   {//adding this keyowrd here : optional , only added for understanding purpose.
    //print the address : hashCode 
	   System.out.println("this's hashCode"+this.hashCode());	
	   return "Box dims "+this.width+" "+this.depth+" "+this.height;
   } 
   //2. To return computed volume of the box.
   public double getComputedVolume()
   {
	   //this keyword is optional .
	    //print the address : hashCode 
	   System.out.println("this's hashCode"+this.hashCode());	
	   return width*depth*height;
   }
}