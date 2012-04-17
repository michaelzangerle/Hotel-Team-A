/**
 * 
 */
package projekt.fhv.teama.hibernate.exceptions;

/**
 * @author mike
 *
 */
public class NoDatabaseEntryFoundException extends DatabaseException {
	
	public NoDatabaseEntryFoundException() {
		super("No results found!");
		
	}

	public NoDatabaseEntryFoundException(String message) {
		super();
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047874891804398773L;

}
