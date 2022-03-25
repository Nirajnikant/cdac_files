package queue;

import java.util.Iterator;

import SList.SList;
import custom_exceptions.QueueExceptions;
import custom_exceptions.SListExceptions;
import custom_exceptions.StackException;

public class StackUsingQueue implements StackIntf {
	int top1, top2;
	int size;
	QueueUsingSLL l1, l2;
	int count = 0;

	public StackUsingQueue(int n) {
		l1 = new QueueUsingSLL(n);
		l2 = new QueueUsingSLL(n);
		size = n;
		top1 = -1;
		top2 = -1;
	}

	@Override
	public void Push(int element) throws StackException, QueueExceptions, SListExceptions {
		if (IsFull())
			throw new StackException("Stack is full");
		if (l1.IsEmpty())
			l1.AddQ(element);
		else {
			for (int i = 0; i < l1.size(); i++) {
				int x = l1.DeleteQ();
				l2.AddQ(x);
			}
			l1.AddQ(element);
			for (int i = 0; i < l2.size(); i++) {
				l1.AddQ(l2.DeleteQ());
			}
		}
		++top1;

	}

	@Override
	public int Pop() throws StackException, SListExceptions {
		if(IsEmpty())
			throw new StackException("List is Empty");
		return l1.DeleteQ();
	}

	@Override
	public boolean IsEmpty() {
		if (top1 == -1)
			return true;
		return false;
	}

	@Override
	public boolean IsFull() {
		if (top1 == size - 1)
			return true;
		return false;
	}
	
	public void Display() throws SListExceptions {
		l1.Display();		
	}

}