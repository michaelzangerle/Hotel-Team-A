/**
 * 
 */
package projekt.fhv.teama.model.integration;

import java.util.List;

import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IALeistung;

/**
 * Klasse um die Zusatzleistungen zu erhalten
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public interface IAModelZusatzleistung {

	/**
	 * Holt alle Zusatzleistungen aus der Datenbank
	 * @return List<IALeistung>
	 * @throws DatabaseException 
	 */
	List<IALeistung> getAZusatzleistungen() throws DatabaseException;


}
