package queue;
import custom_exceptions.QueueExceptions;
import custom_exceptions.SListExceptions;
import custom_exceptions.StackException;

public interface StackIntf {
	public void Push(int element) throws StackException, QueueExceptions, SListExceptions;
	public int Pop() throws StackException, SListExceptions;
	public boolean IsEmpty();
	public boolean IsFull();
}
