package generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Emp> empList = new ArrayList<>();
		ArrayList<Mgr> mgrList = new ArrayList<Mgr>();
//		empList = mgrList; //ArrayList<Emp> is not a super typr ofArrayList<Mgr>
		ArrayList<Object> objs = new ArrayList<Object>();
//		objs = emps;//javac err
//		objs = mgrs;//javac err
		// ? : wild card in generics, unbounded wild card, can be replaced by Any type
		ArrayList<?> anyList = empList;
		anyList = mgrList;
		anyList = objs;
//		ArrayList<E> anyList2;
		List<?> anylist2 = new Vector<String>();
		anylist2 = new LinkedList<Mgr>();
		

	}

}
