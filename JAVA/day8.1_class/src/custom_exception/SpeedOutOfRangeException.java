package custom_exception;

@SuppressWarnings("serial")
public class SpeedOutOfRangeException extends RuntimeException{
	public SpeedOutOfRangeException(String errMesg) {
		super(errMesg);//Initializes error messages
	}
}