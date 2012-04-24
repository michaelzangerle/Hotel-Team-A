package projekt.fhv.teama.hibernate.exceptions;

/**
 * DatabaseRemoveEntry-Exception wird geworfen wenn ein Eintrag in der Datenbank nicht gelöscht werden kann
 * @author Team A
 * @version 1.9
 */
public class DatabaseRemoveEntryException extends DatabaseException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5867437040821519506L;

	public DatabaseRemoveEntryException() {
		super("Can not delete this entry because of database-connections!");
		
	}

	public DatabaseRemoveEntryException(String message) {
		super();
		this.message = message;
	}

}
