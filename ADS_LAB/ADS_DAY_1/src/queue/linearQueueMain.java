package queue;

import java.util.Arrays;

public class linearQueueMain {

	public static void main(String[] args) {
		LinearQueue lq = new LinearQueue(5);
		System.out.println("size = "+lq.size);
		lq.AddQ(3);
//		lq.display();
		lq.AddQ(4);
		lq.AddQ(12);
		lq.AddQ(32);
		lq.AddQ(54);
		lq.display();
		System.out.println(lq.DeleteQ());
		System.out.println(lq.DeleteQ());
		System.out.println(lq.DeleteQ());
		System.out.println(lq.DeleteQ());
		System.out.println(lq.DeleteQ());
		lq.display();
	}

}
