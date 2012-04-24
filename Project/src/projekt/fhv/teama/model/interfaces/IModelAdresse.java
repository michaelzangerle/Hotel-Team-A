package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

/**
 * Interface des Adress Models beschreibt die wichtigsten Methden um mit einer Adresse arbeiten zu können
 * @author Team-A
 * @version 1.5
 */
public interface IModelAdresse {

	/**
	 * Um eine Adresse zu speichern
	 * @param adr IAdresse
	 * @throws DatabaseException
	 */
	void save(IAdresse adr) throws DatabaseException;

}
