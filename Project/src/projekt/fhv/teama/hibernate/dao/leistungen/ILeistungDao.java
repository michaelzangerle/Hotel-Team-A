package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.Set;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse LeistungDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface ILeistungDao extends IGenericDao<ILeistung> {
	
	/**
	 * Sucht nach einer Leistung mit übergebener Bezeichnung
	 * @param bezeichnung String
	 * @return Set<ILeistung>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<ILeistung> getLeistung(String bezeichnung) throws DatabaseEntryNotFoundException;
}
