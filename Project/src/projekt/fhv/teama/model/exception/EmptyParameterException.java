package projekt.fhv.teama.model.exception;

/**
 * Exeption für eine leeren Parameter
 * @author Team-A
 * @version 1.5
 */
public class EmptyParameterException extends Exception {

	private String message;
	public EmptyParameterException() {
		
	}
	
	public EmptyParameterException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
