/**
 * 
 */
package projekt.fhv.teama.hibernate.exceptions;

/**
 * @author mike
 *
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
