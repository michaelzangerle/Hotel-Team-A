package projekt.fhv.teama.view;

public class NotEnoughRoomsException extends Exception {
	private String message;
	
	
	public NotEnoughRoomsException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
}
