package projekt.fhv.teama.hibernate.dao.zimmer;

import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse ZimemrStatusDao 
 * @author Team A
 * @version 1.2
 */
public interface IZimmerStatusDao extends IGenericDao<IZimmerstatus> {
	
	/**
	 * Sucht nach einem Zimmerstatus mittels der Bezeichnung
	 * @param statusname String
	 * @return IZimmerstatus
	 * @throws DatabaseEntryNotFoundException
	 */
	public IZimmerstatus getZimmerstatus(String statusname) throws DatabaseEntryNotFoundException;
}
