package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface f�r die Klasse PersonDao
 * 
 * @author Team A
 * @version 1.2
 */
public interface IPersonDao extends IGenericDao<IPerson> {
	
	/**
	 * Sucht nach (einer) Person(en) mit �bergebenem Vor- oder Nachname
	 * @param name String
	 * @return Set<IPerson>
	 * @throws DatabaseException
	 */
	public Set<IPerson> getPersonByName(String name) throws DatabaseException;

	/**
	 * Sucht nach (einer) Person(en) mit �bergebenen Vor- und Nachnamen
	 * @param vorname String
	 * @param nachname String
	 * @return Set<IPerson>
	 * @throws DatabaseException
	 */
	public Set<IPerson> getPersonByName(String vorname, String nachname) throws DatabaseException;

	/**
	 * Sucht nach (einer) Person(en) mit �bergebener E-Mail-Adresse
	 * @param mail String
	 * @return Set<IPerson>
	 * @throws DatabaseException
	 */
	public Set<IPerson> getPersonByMail(String mail) throws DatabaseException;
}
