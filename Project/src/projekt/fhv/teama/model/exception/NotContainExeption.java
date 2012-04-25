package projekt.fhv.teama.model.exception;

/**
 * Exeption f�r leere R�ckgaben
 * @author Team-A
 * @version 1.5
 */
public class NotContainExeption extends Exception {

	private static final long serialVersionUID = 9094704683771274091L;
	
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
