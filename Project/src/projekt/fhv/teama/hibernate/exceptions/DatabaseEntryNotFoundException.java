/**
 * 
 */
package projekt.fhv.teama.hibernate.exceptions;

/**
 * @author mike
 *
 */
public class DatabaseEntryNotFoundException extends DatabaseException {
	
	public DatabaseEntryNotFoundException() {
		super("No results found!");
		
	}

	public DatabaseEntryNotFoundException(String message) {
		super();
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047874891804398773L;

}
