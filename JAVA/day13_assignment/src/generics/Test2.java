package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import static utils.GenericUtils.copy;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<Worker> workers = new ArrayList<Worker>(
				Arrays.asList(new Worker(5000), new TempWorker(3000),new Worker(2000)));
		Vector<Emp> emps = new Vector<>();
		copy(workers, emps);// src ----> dest
		System.out.println(emps);

	}

}
