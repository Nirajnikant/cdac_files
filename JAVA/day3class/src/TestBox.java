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
		
		// print the address : hashcode
		System.out.println("b1's hashCode"+b1.hashCode());
		
		//display dims n volume
 		System.out.println(b1.getBoxDetails());
		System.out.println(b1.getComputedVolume());
		sc.close(); 
	}
}