/*
Create another class : TestBox --for UI.
ADD psvmain(..){...}
Use scanner --to accept box dims from user,  create box instance.
Dispaly its details & volume.
*/
import java.util.*;
class TestBox{
	//uses-a relationship
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Box dimensions : w d h");
		 
		// ref type variable : class type of the reference , mlv : mem allocated on -- stack : 4/8/16 bytes as per jvm specifications :: no objects of type Box created so far
		
		//System.out.println(b1);//javac err
		
		Box b1=new Box(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		//display dims n volume
		System.out.println(b1.getBoxDetails());
		System.out.println(b1.getComputedVolume());
		System.out.println("Enter side of a cube");
		Box cube = new Box(sc.nextDouble());//calls single argument constructor
		//display dims n volume
		System.out.println(cube.getBoxDetails());
		System.out.println(cube.getComputedVolume());
		Box emptyBox = new Box() ;
		//display dims n volume
		System.out.println(emptyBox.getBoxDetails());
		System.out.println(emptyBox.getComputedVolume());

		// // ASSIGNMENT
		Box box1=new Box(10,20,30,"red");
		Box box2=new Box(10,10,31,"green");
		if(box1.isEqual(box2))
		 	System.out.println("equal");
		else 
		 	System.out.println("different");

		//offset
		Box newBox = box1.createNewBox(3, -4, -2);
		System.out.println("New "+newBox.getBoxDetails());
		System.out.println("New "+newBox.getComputedVolume());
		if(box1.getComputedVolume()>box2.getComputedVolume()) {
			System.out.println(box1.getColor());
		}
		else {
			System.out.println(box2.getColor());
		}
		sc.close(); 
	}
}