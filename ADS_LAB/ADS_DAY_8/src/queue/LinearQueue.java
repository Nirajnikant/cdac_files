package queue;

import java.util.Arrays;

public class LinearQueue implements QueueIntf{
	int front;
	int rear;
	int[] queue;
	int size;
	
	public LinearQueue(int n) {
		this.size = n;
		queue = new int[size];
		front = rear = 0;
	}

	@Override
	public void AddQ(int element) {
		if(IsFull())
			System.out.println("Queue is Full");
		else {
//			if(front==-1)
//				front = 0;
			queue[rear++] = element;
			System.out.println(element+" Added successfully");
		}
	}

	@Override
	public int DeleteQ() {
		if(IsEmpty()) {
			System.out.println("Queue is Empty");
			return queue[front];
		}
		else {
			return queue[front++];
		}
	}

	@Override
	public boolean IsEmpty() {
		if(front==rear)
			return true;
		return false;
	}

	@Override
	public boolean IsFull() {
		// TODO Auto-generated method stub
		if(rear==size)
			return true;
//		System.out.println("Not full");
		return false;
	}
	
	public void display() {
		if(IsEmpty()) {
			System.out.println("Empty");
		}
		else {
				System.out.println(Arrays.toString(queue));
		}
	}

}
