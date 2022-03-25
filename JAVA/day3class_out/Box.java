class Box 
{
  //state : DATA : non static data members : mem allocated in heap : after instance creation --instance variables
  //tight encapsulation : data hiding : private
   private double width,depth,height;
   //parameterized ctor to init complete state of the Box
   Box(double w,double d,double height)
   {
	   width=w;
	   depth=d;
	   this.height=height;
   }
   
   Box(double side) {
	   //implicit keyword : this
		//width=depth=height=side;
		this(side,side,side);
   }
   
   //Actions : 1. To return Box details in String form (dimensions of Box)
   String getBoxDetails()
   {//adding this keyowrd here : optional , only added for understanding purpose.
   
		//print the address :hashcode
		System.out.println("b1's hashCode"+this.hashCode());
	   return "Box dims "+this.width+" "+this.depth+" "+this.height;
   }
   //add another overloaded constructor to init state of a cube
   
   //2. To return computed volume of the box.
   double getComputedVolume()
   {
	   //this keyword is optional .
	   return width*depth*height;
   }
}