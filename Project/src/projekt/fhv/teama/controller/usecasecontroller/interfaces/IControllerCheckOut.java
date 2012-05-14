package projekt.fhv.teama.controller.usecasecontroller.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;

public interface IControllerCheckOut {

	/**
	 * Die Referenz auf den aktuellen Gast setzen
	 * @param gast
	 */
	public abstract void setGast(IGast gast);

	/**
	 * Referenz des aktuellen Gastes erhalten
	 * @return
	 * @throws FokusException
	 */
	public abstract IGast getGast() throws FokusException;

	/**
	 * Liste aller aktuellen Gaeste
	 * @return
	 * @throws DatabaseException
	 */
	public abstract List<IGast> getGaesteVonAuftenhalten()
			throws DatabaseException;

	/**
	 * Referenz auf den akteullen Aufenthalt setzen
	 * @param aufenhalt
	 * @throws EmptyParameterException
	 */
	public abstract void setAufenthalt(IAufenthalt aufenhalt)
			throws EmptyParameterException;

	/**
	 * Referenz des aktellen Aufenthaltes erhalten
	 * @return
	 * @throws FokusException
	 */
	public abstract IAufenthalt getAufenthalt() throws FokusException;

	/**
	 * Liste aller Aufenthalte
	 * @return
	 * @throws DatabaseException
	 */
	public abstract List<IAufenthalt> getAufenthalte() throws DatabaseException;

	/**
	 * Liste der Zimmer eines Gastes 
	 * @return
	 * @throws FokusException
	 * @throws DatabaseException
	 */
	public abstract List<IZimmer> getZimmerVonGast() throws FokusException,
			DatabaseException;

	/**
	 * Sind alle Rechnungspositionen beglichen
	 * @return
	 */
	public abstract boolean offeneRechnungspositionenVorhanden();

	/**
	 * speichern
	 */
	public abstract void save();

}