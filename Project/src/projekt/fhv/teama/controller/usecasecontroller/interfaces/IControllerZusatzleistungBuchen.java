package projekt.fhv.teama.controller.usecasecontroller.interfaces;
import java.util.List;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;


public interface IControllerZusatzleistungBuchen {

	/**
	 * Methode um alle Aufenthalte welche zurzeit stattfinden zu holen
	 * @return List<IAufenthalt>
	 * @throws DatabaseException
	 */
	public List<IAufenthalt> getAufenthalte() throws DatabaseException;
	
	/**
	 * Methode um alle Gaeste die zurzeit im Hotel sind zu erhalten
	 * @return List<IGast>
	 * @throws DatabaseException
	 */
	public List<IGast> getGaesteVonAuftenhalten() throws DatabaseException;

	/**
	 * Methode um die Gäste zum Ausgewählten Aufenthalt zu erhalten
	 * @return List<IGast>
	 * @throws FokusException
	 */
	public List<IGast> getGaesteZumAufenhalt() throws FokusException;
	
	/**
	 * Methode um den Fokus auf einen Aufenthalt zu legen
	 * @param aufenhalt
	 * @throws EmptyParameterException
	 */
	public void setAufenthalt(IAufenthalt aufenhalt) throws EmptyParameterException;
	
	/**
	 * Methode um den Aufenhalt der derzeitig bearbeitete wird zu erhalten
	 * @return IAufenhalt
	 * @throws FokusException
	 */
	public IAufenthalt getAufenthalt() throws FokusException;
	
	/**
	 * Die Referenz auf den aktuellen Gast setzen
	 * 
	 * @param IGast
	 */
	public void setGast(IGast gast);
	
	/**
	 * Die Referenz des aktuellen Gast zu erhalten
	 * @throws FokusException 
	 * 
	 */
	public IGast getGast() throws FokusException;
}
