package projekt.fhv.teama.hibernate.dao.zimmer;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IReservierungsOption;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse ReservierungsOptionDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface IReservierungsOptionDao extends IGenericDao<IReservierungsOption> {
	
	/**
	 * Sucht nach Reservierungsoptionen anhand eines Datums
	 * @param zeitpunkt java.sql.Date
	 * @return Set<IReservierungsOption>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IReservierungsOption> getOptionen(Date zeitpunkt) throws DatabaseEntryNotFoundException;
}
