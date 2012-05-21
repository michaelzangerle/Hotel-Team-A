package projekt.fhv.teama.model.integration;

import java.sql.Date;
import java.util.List;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IAPfandtyp;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;

public interface IAModelAufenthalt {


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

	public void checkOut(IAAufenthalt auf, boolean b, String string);
}
