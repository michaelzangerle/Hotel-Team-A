package projekt.fhv.teama.controller.usecasecontroller.interfaces;

import java.util.List;


import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;

public interface IControllerCheckOut {

	/**
	 * Die Referenz auf den aktuellen Gast setzen
	 * @param gast
	 */
	public abstract void setGast(IAGast gast);

	/**
	 * Referenz des aktuellen Gastes erhalten
	 * @return
	 * @throws FokusException
	 */
	public abstract IAGast getGast() throws FokusException;

	/**
	 * Liste aller aktuellen Gaeste
	 * @return
	 * @throws DatabaseException
	 */
	public abstract List<IAGast> getGaesteVonAuftenhalten()
			throws DatabaseException;

	/**
	 * Referenz auf den akteullen Aufenthalt setzen
	 * @param aufenhalt
	 * @throws EmptyParameterException
	 */
	public abstract void setAufenthalt(IAAufenthalt aufenhalt)
			throws EmptyParameterException;

	/**
	 * Referenz des aktellen Aufenthaltes erhalten
	 * @return
	 * @throws FokusException
	 */
	public abstract IAAufenthalt getAufenthalt() throws FokusException;

	/**
	 * Liste aller Aufenthalte
	 * @return
	 * @throws DatabaseException
	 */
	public abstract List<IAAufenthalt> getAufenthalte() throws DatabaseException;

	/**
	 * Liste der Zimmer eines Gastes 
	 * @return
	 * @throws FokusException
	 * @throws DatabaseException
	 */
	public abstract List<IAZimmer> getZimmerVonGast() throws FokusException,
			DatabaseException;

	/**
	 * Sind alle Rechnungspositionen beglichen
	 * @return
	 * @throws FokusException 
	 * @throws DatabaseException 
	 */
	public abstract boolean offeneRechnungspositionenVorhanden() throws DatabaseException, FokusException;

	/**
	 * speichern
	 * @throws DatabaseException 
	 * @throws FokusException 
	 */
	public abstract void save() throws FokusException, DatabaseException;
	
	

}