package custom_exception;

@SuppressWarnings("serial")
public class QueueExceptions extends Exception {
	public QueueExceptions(String message) {
		super(message);
	}
}