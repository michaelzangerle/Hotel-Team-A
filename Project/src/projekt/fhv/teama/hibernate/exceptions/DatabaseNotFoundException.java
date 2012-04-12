/**
 * 
 */
package projekt.fhv.teama.hibernate.exceptions;

/**
 * @author mike
 *
 */
public class DatabaseNotFoundException extends DatabaseException {
	
	protected String message = "No results found!";

	public DatabaseNotFoundException() {
		super();
	}

	public DatabaseNotFoundException(String message) {
		super();
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047874891804398773L;

}
