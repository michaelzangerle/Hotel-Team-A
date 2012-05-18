/**
 * 
 */
package projekt.fhv.teama.model.integration;

import java.util.List;

import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IALeistung;

/**
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public interface IAModelArtikel {

	/**
	 * @return
	 * @throws DatabaseException 
	 */
	List<IALeistung> getAArtikel() throws DatabaseException;

}
