package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IStatusentwicklung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse StatusentwicklungenDao 
 * @author Team A
 * @version 1.2
 */
public interface IStatusentwicklungDao extends IGenericDao<IStatusentwicklung> {
	
	/**
	 * Sucht nach Statusentwicklungen eines Zimmers via Zimmernummer
	 * @param nummer String
	 * @return Set<IStatusentwicklung>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IStatusentwicklung> getStatusentwicklungByZimmernummer(String nummer)throws DatabaseEntryNotFoundException;
}
