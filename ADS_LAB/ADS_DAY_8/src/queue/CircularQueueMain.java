package queue;

import java.util.Arrays;

public class CircularQueueMain {

	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(5);
		System.out.println("size = "+cq.size);
		cq.AddQ(3);
//		cq.display();
		cq.AddQ(4);
		cq.AddQ(12);
		cq.AddQ(32);
		cq.AddQ(54);
		cq.display();
		System.out.println(cq.DeleteQ());
		System.out.println(cq.DeleteQ());
		System.out.println(cq.DeleteQ());
		System.out.println(cq.DeleteQ());
		System.out.println(cq.DeleteQ());
		cq.display();
	}

}
