package projekt.fhv.teama.hibernate.dao.leistungen;

import projekt.fhv.teama.classes.leistungen.IWarengruppe;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse WarengruppeDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface IWarengruppeDao extends IGenericDao<IWarengruppe> {
	
	/**
	 * Sucht nach einer Warengruppe mittels übergebener Bezeichnung
	 * @param bez String
	 * @return IWarengruppe
	 * @throws DatabaseEntryNotFoundException
	 */
	public IWarengruppe getWarengruppeByBezeichnung(String bez) throws DatabaseEntryNotFoundException;
}
