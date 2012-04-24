package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface für die Klasse PersonDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface IPersonDao extends IGenericDao<IPerson> {
	
	/**
	 * Sucht nach (einer) Person(en) mit übergebenem Vor- oder Nachname
	 * @param name String
	 * @return Set<IPerson>
	 * @throws DatabaseException
	 */
	public Set<IPerson> getPersonByName(String name) throws DatabaseException;

	/**
	 * Sucht nach (einer) Person(en) mit übergebenen Vor- und Nachnamen
	 * @param vorname String
	 * @param nachname String
	 * @return Set<IPerson>
	 * @throws DatabaseException
	 */
	public Set<IPerson> getPersonByName(String vorname, String nachname) throws DatabaseException;

	/**
	 * Sucht nach (einer) Person(en) mit übergebener E-Mail-Adresse
	 * @param mail String
	 * @return Set<IPerson>
	 * @throws DatabaseException
	 */
	public Set<IPerson> getPersonByMail(String mail) throws DatabaseException;
}
