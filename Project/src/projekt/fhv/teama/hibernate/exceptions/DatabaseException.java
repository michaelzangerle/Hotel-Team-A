/**
 * 
 */
package projekt.fhv.teama.hibernate.exceptions;

/**
 * Ist die Überklasse für alle Datenbank nahe Exceptions 
 * @author Team A
 * @version 1.0
 */
public class DatabaseException extends Exception {
	
	protected String message = "Error while checking for Name!";

	@Override
	public  String getMessage() {
		return message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1053085940271322473L;

	public DatabaseException() {
		super();
	}

	public DatabaseException(String message) {
		super();
		this.message = message;
	}

	
	
}
