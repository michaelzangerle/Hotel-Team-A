package projekt.fhv.teama.model.interfaces;

import java.sql.Date;
import java.util.List;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.ITeilreservierung;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.WrongParameterException;


/**
 * Interface für das Reservierungs Model 
 * @author Team-A
 * @version 1.5
 */
public interface IModelReservierung {

	/**
	 * Um alle Reservierungen abzurufen
	 * @return List<IReservierung>
	 * @throws DatabaseException
	 */
	List<IReservierung> getAllReservierungen() throws DatabaseException;

	/**
	 * Um die ausgewählte Reservierung im Controller zu setzen
	 * @param reservierung IReservierung
	 */
	void setAktuelleReservierung(IReservierung reservierung);

	/**
	 * Um die ausgewählte Reservierung abzurufen
	 * @return IReservierung
	 * @throws FokusException
	 */
	IReservierung getAktuelleReservierung() throws FokusException;

	/**
	 * Um alle Teilreservierungen zu der ausgewählten Reservierung abzurufen
	 * @return List<ITeilreservierung>
	 * @throws FokusException
	 */
	List<ITeilreservierung> getTeilreservierungen() throws FokusException;

	/**
	 * Um das Anreise Datum zu setzen
	 * @param date Date
	 */
	void setVon(Date date);

	/**
	 * Um das Abreise Datum zu setzen
	 * @param date Date
	 */
	void setBis(Date date);

	/**
	 * Liste von Gästen zur dieser Reservierung
	 * @return List<IGast>
	 * @throws FokusException
	 */
	List<IGast> getGaeste() throws FokusException;
	
	/**
	 * Ob Gast in der Reservierung enthalten ist
	 * @param gast IGast
	 * @return boolean
	 */
	boolean containsGast(IGast gast);

	/**
	 * Methode um Reservierung in der Datenbank zu speichern
	 * @param r IReservierung
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	void save(IReservierung r) throws DatabaseException, EmptyParameterException ;

	/**
	 * Um die Reservierunge die am heutigen Tag eine Check In absolvieren abrufen
	 * @param date
	 * @return List<IReservierung>
	 * @throws DatabaseException
	 */
	List<IReservierung> getCheckInReservierungen(Date date) throws DatabaseException;

	/**
	 * Um die Reservierung als bearbeitet zu markieren
	 * @param b
	 * @throws WrongParameterException
	 */
	void setBearbeitet(boolean b) throws WrongParameterException;

}
