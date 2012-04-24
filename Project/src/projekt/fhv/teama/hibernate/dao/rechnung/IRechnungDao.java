package projekt.fhv.teama.hibernate.dao.rechnung;

import java.util.Set;

import projekt.fhv.teama.classes.rechnung.IRechnung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse RechnungDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface IRechnungDao extends IGenericDao<IRechnung> {

	/**
	 * Sucht nach Rechnungen die von einem Mitarbeiter mit dem übergebenen Vor- und Nachnamen bearbeitet wurden
	 * @param vorname String 
	 * @param nachname String
	 * @return Set<IRechnung>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IRechnung> getRechnungByMitarbeiter(String vorname, String nachname)
			throws DatabaseEntryNotFoundException;

	/**
	 * Sucht nach Rechnungen die von jemandem mit übergebenen Vor- und Nachnamen bezahlt wurden
	 * @param vorname String
	 * @param nachname String
	 * @return Set<IRechnung>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IRechnung> getRechnungByBezahler(String vorname, String nachname) throws DatabaseEntryNotFoundException;
}
