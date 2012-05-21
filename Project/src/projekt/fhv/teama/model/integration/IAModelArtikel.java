/**
 * 
 */
package projekt.fhv.teama.model.integration;

import java.util.List;

import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IALeistung;

/**
 * Beschreibt das Interface für die Adapterklasse für das ModelArtikel
 * @author Team A
 * @version 1.2
 */
public interface IAModelArtikel {

	/**
	 * Gibt eine Liste der Artikel zurück die in der Datenbank sind
	 * @return IALeistung
	 * @throws DatabaseException 
	 */
	List<IALeistung> getAArtikel() throws DatabaseException;

}
