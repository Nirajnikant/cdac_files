package queue;

import java.util.Arrays;

public class CircularQueue implements QueueIntf {
	int front, rear, size;
	int [] queue;
	
	public CircularQueue(int n) {
		this.size = n;
		queue = new int[size];
		front = rear = -1;
	}

	@Override
	public void AddQ(int element) {
		if(IsFull())
			System.out.println("Stack is Full");
		else if(front == -1 && rear == -1) {
			front=rear=0;
			queue[rear] = element;
			System.out.println(element+" Added successfully");
		}
		else {
			rear = (rear+1)%size;
			queue[rear] = element;
			System.out.println(element+" Added successfully");
		}
	}

	@Override
	public int DeleteQ() {
		int temp;
		 
	    if(front == -1) {
	        System.out.print("Queue is Empty ");
	        return 0;
	    }
	 
	    temp = queue[front];
	 
	    if(IsEmpty()) {
	        front = -1;
	        rear = -1;
	    }
	    else {
	        front = (front + 1)%size;
	    }
		return temp;
	}

	@Override
	public boolean IsEmpty() {
		if(front == rear)
			return true;
		return false;
	}

	@Override
	public boolean IsFull() {
		if((rear+1)%size == front)
			return true;
		return false;
	}
	
	public void display() {
		if(IsEmpty()) {
			System.out.println("Empty");
		}
		else {
			int i = front;
			System.out.print("[");
			while(i!=rear) {
				System.out.print(queue[i]+" ");
				i = (i+1)%size;
			}
			System.out.println(rear+"]");
		}
	}

}
