package custom_exception;

@SuppressWarnings("serial")
public class VehicleValidateException extends Exception {
	public VehicleValidateException(String message) {
		super(message);
	}
}
