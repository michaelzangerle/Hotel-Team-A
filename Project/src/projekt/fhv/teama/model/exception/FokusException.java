package projekt.fhv.teama.model.exception;

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
