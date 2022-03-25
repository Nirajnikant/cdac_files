package SList;


import custom_exceptions.SListExceptions;
import custom_exceptions.StackException;
import stack.SListNode;

public class StackUsingList implements StackIntf{
	
	SList l;
	int count = 0;
	int size;
	public StackUsingList(int n) {
		l = new SList();
		size = n;
	}

	@Override
	public void Push(int element) throws StackException{
		if(IsFull())
			throw new StackException("Stack is Full");
		l.AddAtRear(element);
		count++;
	}

	@Override
	public int Pop() throws SListExceptions, StackException {
		if(IsEmpty())
			throw new StackException("Stack is EMpty");
		return l.DeleteLastNode();
	}

	@Override
	public boolean IsEmpty() {
		if(l.head==null)
			return true;
		return false;
	}

	@Override
	public boolean IsFull() {
		if(count<=size)
			return false;
		return true;
	}
	
}
