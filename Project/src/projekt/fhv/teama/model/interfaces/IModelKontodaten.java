package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;

/**
 * Interface Kontodaten Model beschreibt die wichtigsten Methoden für das Kontodaten Model
 * @author Team-A
 * @version 1.5
 */
public interface IModelKontodaten {

	/**
	 * Um Kontodaten in der Datenbank abzuspeichern
	 * @param kontodaten IKontodaten
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	void save(IKontodaten kontodaten) throws DatabaseException, EmptyParameterException;

}
