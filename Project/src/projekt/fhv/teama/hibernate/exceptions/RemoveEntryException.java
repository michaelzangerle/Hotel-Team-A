/**
 * 
 */
package projekt.fhv.teama.hibernate.exceptions;

/**
 * @author mike
 *
 */
public class RemoveEntryException extends DatabaseException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5867437040821519506L;

	public RemoveEntryException() {
		super("Can not delete this entry because of database-connections!");
		
	}

	public RemoveEntryException(String message) {
		super();
		this.message = message;
	}

}
