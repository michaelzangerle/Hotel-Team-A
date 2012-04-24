package projekt.fhv.teama.hibernate.dao.zimmer;

import projekt.fhv.teama.classes.zimmer.ISaison;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface für die Klasse SaisonDao
 * @author Team A
 * @version 1.2
 */
public interface ISaisonDao extends IGenericDao<ISaison> {
	
	/**
	 * Sucht nach einer Saison anhand der Bezeichnung
	 * @param saison String 
	 * @return ISaison
	 * @throws DatabaseEntryNotFoundException
	 */
	public ISaison getSaison(String saison)throws DatabaseEntryNotFoundException;
}
