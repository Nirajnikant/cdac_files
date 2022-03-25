class Box {
	//state : DATA : non static data members :memory allocated in heap after instance/object is creation --alos called as instance variables
	
	//tight encapsulation : data hiding : private
	
	private double width, depth, height;
	
	//parameterized constructor to initilize complete state of the Box
	Box(double w, double d, double height) {
		width = w;
//^instance variable   ^mlv
		depth = d;
//^instance variable   ^mlv		
	//	height = height; 
//       ^mlv     ^mlv
		this.height = height;
//^instance variable   ^mlv	

// *** this is non mandatory if the name of instance variable is different than mlv(method local variable) like in case of width and depth 
// but if the instance variable name is same as that of the mlv then ****this must be used with instqance variable	
	}
	//add another overloaded to  init state of a cube
	Box(double side) {
		//implicity keyword : this
		//width = depth = height = side;  repetative code
		//^it works
		this(side,side,side);//single argument constructr calls default constructor using this.
	}
	//add another constructor : to init state = -1
	Box() {
		//width = depth = height = -1;
		// this(-1,-1,-1);
		this(-1);
	}
	//Actions : 1. to return Box details in String form (dimensions of Box)
	String getBoxDetails() {
		//adding ***this keyword here :  optional, only for understanding purpose.
		return "Box dimensions " + this.width + " " + this.depth + " " + this.height;
	}
	
	//Action : 2. To return computed volume of the Box.
	double getComputedVolume() {
		//adding ***this keyword here :  optional
		return width*depth*height;	
	}

	//Assignment
	boolean isEqual(Box anotherBox) {
			//this = box1  anotherBox =box2
    		return this.width == anotherBox.width && this.depth == anotherBox.depth && this.height == anotherBox.height;
    	}

	Box createNewBox(double wOffset,double dOffset,double hOffset) {
		// width += wOffset;
		// depth += dOffset;
		// height += hOffset;
		this(width += wOffset, depth += dOffset, height += hOffset); 
	}
		
}