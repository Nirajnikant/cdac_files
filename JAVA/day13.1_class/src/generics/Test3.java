package generics;
import static utils.GenericUtils.printList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Test3 {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,8));
		printList(list1);
		LinkedList<Mgr> list2 = new LinkedList<>(Arrays.asList(new Mgr(), new Mgr(), new Mgr());
	}

}
