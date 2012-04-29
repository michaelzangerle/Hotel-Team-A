package projekt.fhv.teama.view;

/**
 * Wird geworfen wenn nicht genügend freie Zimmer vorhanden sind.
 * @author Team A
 * @version 1.0
 */
@SuppressWarnings("serial")
public class NotEnoughRoomsException extends Exception {
	private String message;
	
	
	public NotEnoughRoomsException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
}
