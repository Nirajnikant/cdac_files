import custom_exception.StackException;

public interface StackIntf {
	public void Push(int element) throws StackException;
	public int Pop() throws StackException;
	public boolean IsEmpty();
	public boolean IsFull();
}
