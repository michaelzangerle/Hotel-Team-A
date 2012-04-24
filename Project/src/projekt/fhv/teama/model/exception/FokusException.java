package projekt.fhv.teama.model.exception;

/**
 * Exeption wenn kein Fokus gesetzt wurde
 * @author Team-A
 * @version 1.5
 */

public class FokusException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 730512056946573604L;
	
	private String message;
	public FokusException() {
		
	}
	
	public FokusException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
