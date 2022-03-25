package SList;
import java.util.Arrays;

public class mainProg {
	public static void main(String[] args) {
		try {
			SList l1 = new SList();
	
			l1.AddAtFront(5);
			l1.AddAtRear(10);
			l1.AddAtFront(1);
			l1.AddAtRear(20);
			System.out.println(Arrays.toString(l1.getElements()));
			System.out.println(l1.DeleteFirstNode());
			System.out.println(Arrays.toString(l1.getElements()));
			System.out.println(l1.DeleteLastNode());
			System.out.println(Arrays.toString(l1.getElements()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
