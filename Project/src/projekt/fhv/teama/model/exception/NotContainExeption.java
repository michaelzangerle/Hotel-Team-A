package projekt.fhv.teama.model.exception;

public class NotContainExeption extends Exception {

	
	private String message;
	public NotContainExeption() {
		
	}
	
	public NotContainExeption(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
