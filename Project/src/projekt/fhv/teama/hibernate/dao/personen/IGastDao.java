package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface für die Klasse GastDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface IGastDao extends IGenericDao<IGast> {

	/**
	 * Sucht nach einem Gast mit der übergebenen Nummer
	 * @param gastnummer String
	 * @return IGast
	 * @throws DatabaseException
	 */
	public IGast getGastByNummer(String gastnummer) throws DatabaseException;

	/**
	 * Sucht nach einem Gast mit übergebenem Vor- und Nachname
	 * @param vorname String
	 * @param nachname String
	 * @return Set<IGast>
	 * @throws DatabaseException
	 */
	public Set<IGast> getGastByName(String vorname, String nachname) throws DatabaseException;

	/**
	 * Sucht nach einem Gast mit übergebenem Vor- oder Nachname
	 * @param name String
	 * @return Set<IGast>
	 * @throws DatabaseException
	 */
	public Set<IGast> getGastByName(String name) throws DatabaseException;
}
