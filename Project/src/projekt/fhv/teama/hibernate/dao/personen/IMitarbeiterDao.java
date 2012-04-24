package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface für die Klasse MitarbeiterDao 
 * @author Team A
 * @version 1.2
 */
public interface IMitarbeiterDao extends IGenericDao<IMitarbeiter>  {
	
	/**
	 * Sucht nach (einem) Mitarbeiter mit übergebenem Vor- und Nachname
	 * @param firstname String
	 * @param lastname String
	 * @return Set<IMitarbeiter>
	 * @throws DatabaseException
	 */
	public Set<IMitarbeiter> getMitarbeiterByName(String firstname, String lastname) throws DatabaseException;
	
	/**
	 * Sucht nach (einem) Mitarbeiter mit übergebenem Vor- oder Nachnamen
	 * @param name String
	 * @return Set<IMitarbeiter>
	 * @throws DatabaseException
	 */
	public Set<IMitarbeiter> getMitarbeiterByName(String name) throws DatabaseException;
	
	/**
	 * Sucht nach einem Mitarbeiter mit übergebener Nummer
	 * @param nummer String
	 * @return Set<IMitarbeiter>
	 * @throws DatabaseException
	 */
	public Set<IMitarbeiter> getMitarbeiterByNummer(String nummer) throws DatabaseException;
	
}
