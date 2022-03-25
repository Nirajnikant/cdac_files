package queue;

import custom_exceptions.QueueExceptions;
import custom_exceptions.SListExceptions;

public interface QueueIntf {
	public void AddQ(int element) throws QueueExceptions;
	public int DeleteQ() throws SListExceptions;
	public boolean IsEmpty();
	public boolean IsFull();
}
