package projekt.fhv.teama.hibernate.dao.leistungen;

import java.util.Set;

import projekt.fhv.teama.classes.leistungen.IZusatzleistung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse ZusatzleistungDao 
 * @author Team A
 * @version 1.2
 */
public interface IZusatzleistungDao extends IGenericDao<IZusatzleistung> {
	
	/**
	 * Sucht nach einer Zusatzleistung mit der übergebenen Bezeichnung
	 * @param bezeichnung String
	 * @return Set<IZusatzleistung>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IZusatzleistung> getZusatzleistung(String bezeichnung) throws DatabaseEntryNotFoundException;
}
