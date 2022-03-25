import custom_exception.*;
public class StackUsingArray implements StackIntf {
	int top;
	int[] stack;
	int n;

	public StackUsingArray(int n) {
		this.n = n;
		stack = new int [n];
		top = -1;
	}

	@Override
	public void Push(int element) throws StackException{
		// TODO: What is stack is full?
		if(IsFull())
			throw new StackException("STACK IS FULL!!!!!!!");
		++top;
		stack[top] = element;
	}

	@Override
	public int Pop() throws StackException{
		// TODO: What is stack is empty?
		if(IsEmpty())
			throw new StackException("STACK IS EMPTY!!!!!!!");
		int element = stack[top];
		--top;
		return element;
	}

	@Override
	public boolean IsEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	@Override
	public boolean IsFull() {
		if (top == n - 1)
			return true;
		return false;
	}

}
