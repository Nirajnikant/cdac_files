package custom_exceptions;

@SuppressWarnings("serial")
public class StackException extends Exception {
	public StackException(String message) {
		super(message);
	}
}