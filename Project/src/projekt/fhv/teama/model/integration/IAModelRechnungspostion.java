package projekt.fhv.teama.model.integration;

import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAGast;

/**
 * 
 * Integrations Klasse f�r die Adapterklasse f�r die Rechnungsposition 
 * @author Team-A
 * @version 1.5
 */
public interface IAModelRechnungspostion {

	/**
	 * Methode ob noch offene Rechnungspostionen in der Datenbank sind
	 * @param gast
	 * @return boolean
	 * @throws DatabaseException
	 */
	boolean sindNochPostionenoffen(IAGast gast) throws DatabaseException;

}
