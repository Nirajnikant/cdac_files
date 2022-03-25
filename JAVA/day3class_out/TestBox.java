import java.util.*;
class TestBox {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Box dims : w d h");
		Box b1;// ref type var : class type of ref.,local variable:memory allocated in stack : 4/8/16  bytes as per JVM's specification no object of type Box created so far.
		Box b1;
		b1=new Box(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		//print the address :hashcode
		System.out.println("b1's hashCode"+b1.hashCode());
		System.out.println();
		System.out.println();
		sc.close();
	}
}