package projekt.fhv.teama.model.exception;

public class EmptyParameterException extends Exception {

	private String message;
	public EmptyParameterException() {
		// TODO Auto-generated constructor stub
	}
	
	public EmptyParameterException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
