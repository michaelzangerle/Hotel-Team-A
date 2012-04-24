package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse ReservierungDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface IReservierungDao extends IGenericDao<IReservierung> {

	/**
	 * Sucht nach Reservierungen anhand von Vor- und Nachname einer Person
	 * @param vorname String
	 * @param nachname String
	 * @return Set<IReservierung>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IReservierung> getReservierungByPerson(String vorname, String nachname)
			throws DatabaseEntryNotFoundException;

	/**
	 * Sucht nach einer Reservierung anhand von dem Vor- oder Nachnamen einer Person
	 * @param name String
	 * @return Set<IReservierung>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IReservierung> getReservierungByVP(String name) throws DatabaseEntryNotFoundException;

}
