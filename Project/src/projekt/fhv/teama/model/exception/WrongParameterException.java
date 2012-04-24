package projekt.fhv.teama.model.exception;


/**
 * Exeption f�r eine falschen Parameter
 * @author Team-A
 * @version 1.5
 */
public class WrongParameterException extends Exception {
	private String message;
	public WrongParameterException() {
		
	}
	
	public WrongParameterException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
