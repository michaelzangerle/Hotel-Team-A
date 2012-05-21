package projekt.fhv.teama.model.interfaces;

import java.sql.Date;
import java.util.List;

import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IAPfandtyp;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.integration.IAModelAufenthalt;

/**
 * Interface des Aufenthalts Model, beschreibt die wichtigsten Methden um mit einem Model arbeiten zu können
 * @author Team-A
 * @version 1.5
 */
public interface IModelAufenthalt extends IAModelAufenthalt {

	/**
	 * Um einen Aufenthalt zu erzeugen und in in der Datenbank abzuspeichern
	 * @param preis
	 * @param von
	 * @param bis
	 * @param schluessel
	 * @param gast
	 * @param zimmer
	 * @param pfand
	 * @param pfandNr
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	public void create(float preis, Date von, Date bis, boolean schluessel, IAGast gast, IAZimmer zimmer,IAPfandtyp pfand,String pfandNr) throws DatabaseException, EmptyParameterException;

	/**
	 * Um alle Aufenthalt die zu einem angegebenen Zeitpunkt vorhanden sind abzurufen
	 * @param date
	 * @return List<IAufenthalt>
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	public List<IAAufenthalt> getAufenthalte(Date date) throws DatabaseException;

	/**
	 * Methode um den Fokus auf einen Aufenhalt zu legen
	 * @param aufenhalt
	 * @throws EmptyParameterException
	 */
	public void setAufenthalt(IAAufenthalt aufenhalt) throws EmptyParameterException;

	/**
	 * Methode um den Momentanten Aufenhalt der verwendet wird zu bekommen
	 * @return IAufenthalt
	 * @throws FokusException
	 */
	public IAAufenthalt getAufenthalt() throws FokusException;
	/**
	 * Liefert eine Liste von Gaesten des Ausgewählten aufenthaltes
	 * @return List<IGast>
	 * @throws FokusException
	 */
	public List<IAGast> getGaesteZumAufenhalt() throws FokusException;
	
}
