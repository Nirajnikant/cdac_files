package queue;

import java.util.Arrays;

import SList.SList;
import custom_exceptions.QueueExceptions;
import custom_exceptions.SListExceptions;

public class QueueUsingSLL implements QueueIntf {
	SList l;
	int count = 0;
	int size, rear, front;

	public QueueUsingSLL(int n) {
		l = new SList();
		size = n;
		front = rear = -1;
	}

	@Override
	public void AddQ(int element) throws QueueExceptions {
		// TODO Auto-generated method stub
		if (IsFull())
			throw new QueueExceptions("Queue is Full");
		else {
			if(front==-1)
				front = 0;
			l.AddAtRear(element);
			rear++;
			count++;
//			System.out.println(element + " Added successfully");
		}
	}

	@Override
	public int DeleteQ() throws SListExceptions {
		if (IsEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
//		System.out.println(l.DeleteFirstNode());
		--rear;
		
		return 0;
	}

	@Override
	public boolean IsEmpty() {
		if (front == -1 || front > rear)
			return true;
		return false;
	}

	@Override
	public boolean IsFull() {
		if (rear == size - 1)
			return true;
		return false;
	}
	
	public void Display() throws SListExceptions {
		if(IsEmpty()) {
			System.out.println("Empty");
		}
		else {
				System.out.println(Arrays.toString(l.getElements()));
		}
	}
	
	public int size() {
		return l.getCount();
	}
	

}