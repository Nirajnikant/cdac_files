package queue;

public class linearQueueMain {

	public static void main(String[] args) {
		QueueUsingSLL lq = new QueueUsingSLL(5);
		System.out.println("size = "+lq.size);
		try {
			lq.AddQ(3);
	//		lq.display();
			lq.AddQ(4);
			lq.AddQ(12);
			lq.AddQ(32);
			lq.AddQ(54);
			lq.Display();

			System.out.println(lq.DeleteQ());
			lq.Display();
			System.out.println(lq.DeleteQ());
			lq.Display();
			System.out.println(lq.DeleteQ());
			lq.Display();
			System.out.println(lq.DeleteQ());
			lq.Display();
			System.out.println(lq.DeleteQ());
			lq.Display();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
