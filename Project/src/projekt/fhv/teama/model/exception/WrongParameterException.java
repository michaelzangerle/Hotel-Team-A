package projekt.fhv.teama.model.exception;


/**
 * Exeption für eine falschen Parameter
 * @author Team-A
 * @version 1.5
 */
public class WrongParameterException extends Exception {

	private static final long serialVersionUID = -4895711707477000347L;
	
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
