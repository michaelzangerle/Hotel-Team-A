package projekt.fhv.teama.model.exception;

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
