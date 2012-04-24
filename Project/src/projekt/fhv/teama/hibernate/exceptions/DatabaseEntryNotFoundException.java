/**
 * 
 */
package projekt.fhv.teama.hibernate.exceptions;

/**
 * Wird geworfen wenn kein Datensatz mit den entsprechenden Parametern gefudnen wurde
 * @author Team A
 * @version 1.0
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
