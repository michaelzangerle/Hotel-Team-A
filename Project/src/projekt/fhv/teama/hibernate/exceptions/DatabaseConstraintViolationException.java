/**
 * 
 */
package projekt.fhv.teama.hibernate.exceptions;

/**
 * Diese Exception wird geworfen wenn eine Verletzung von Datenbank-Constrains vorliegt! 
 * @author Team A
 * @version 1.0
 */
public class DatabaseConstraintViolationException extends DatabaseException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5867437040821519506L;

	public DatabaseConstraintViolationException() {
		super("Can not delete this entry because of database-connections!");
		
	}

	public DatabaseConstraintViolationException(String message) {
		super();
		this.message = message;
	}

}
