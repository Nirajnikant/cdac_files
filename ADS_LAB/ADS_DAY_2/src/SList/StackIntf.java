package SList;

import custom_exceptions.SListExceptions;
import custom_exceptions.StackException;

public interface StackIntf {
	public void Push(int element) throws StackException;
	public int Pop() throws SListExceptions, StackException;
	public boolean IsEmpty();
	public boolean IsFull();
}
