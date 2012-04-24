package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface f�r die Klasse VertragspartnerDao 
 * @author Team A
 * @version 1.2
 */
public interface IVertragspartnerDao extends IGenericDao<IVertragspartner> {
	
	/**
	 * Sucht nach einem Vertragspartner mit dem �bergebenen Namen
	 * @param name String
	 * @return IVertragspartner
	 * @throws DatabaseEntryNotFoundException
	 */
	public IVertragspartner getVertragspartnerByName(String name) throws DatabaseEntryNotFoundException;
}
