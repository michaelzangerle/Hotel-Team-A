package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IBerechtigung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface für die Klasse BrechtigungDao 
 * @author Team A
 * @version 1.2
 */
public interface IBerechtigungDao extends IGenericDao<IBerechtigung> {
	
	/**
	 * @param bezeichnung
	 * @return IBerechtigung
	 * @throws DatabaseException
	 */
	public IBerechtigung getBerechtigungByBezeichnung(String bezeichnung) throws DatabaseException;
}
