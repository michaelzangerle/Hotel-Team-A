/**
 * 
 */
package projekt.fhv.teama.model.integration;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IALeistung;
import projekt.fhv.teama.model.exception.WrongParameterException;

/**
 * Beschreibt  das Interface für den Adapter ModelAufenthalt
 * @author Team A
 * @version 1.2
 */
public interface IAModelAufenthaltLeistung {

	/**
	 * Zum Speichern einer Leistung in verbindung zu einem Aufenthalt
	 * @param leistung
	 * @param aufenthalt
	 * @param anzahl
	 * @param datum
	 */
	void save(IALeistung leistung, IAAufenthalt aufenthalt, int anzahl, Date datum) throws WrongParameterException, DatabaseException;

	/**
	 * Um die Leistungen zu einem Aufenhalt zu holen
	 * @param auf
	 * @return
	 */
	List<LeistungAnzahl> getLeistungenByAufenhalt(IAAufenthalt auf) throws DatabaseException ;

}
