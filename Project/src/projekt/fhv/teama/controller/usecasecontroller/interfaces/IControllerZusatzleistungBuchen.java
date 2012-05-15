package projekt.fhv.teama.controller.usecasecontroller.interfaces;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;


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
	
	
	/**
	 * Methode um die eine Liste von Zimmern zu erhalten die auf diesen Gast Laufen
	 * @return List<IZimmer>
	 * @throws FokusException
	 * @throws DatabaseException
	 */
	public List<IZimmer> getZimmerVonGast() throws FokusException, DatabaseException;
	
	/**
	 * Methode um den Gast anhand seiner Nummer zu erhalten
	 * @param nummer
	 * @return IGast
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 * @throws NotContainExeption
	 */
	public IGast getGastByNummer(String nummer) throws DatabaseException, EmptyParameterException, NotContainExeption;

	/**
	 * Methode um die Artikel und die Zusatzleistungen zu holen
	 * @return	List<ILeistung>
	 * @throws DatabaseException
	 */
	public List<ILeistung> getArtikelundZusatzleistungen() throws DatabaseException;
	
	
	/**
	 * Methode um das aktuell bearbeitete Zimmer zu setzen
	 * @param zimmer
	 * @throws EmptyParameterException
	 */
	public void setAktuellesZimmer(IZimmer zimmer) throws EmptyParameterException;
	
	/**
	 * Methode um das aktuell bearbeitete Zimmer zu erhalten
	 * @return IZimmer
	 * @throws FokusException
	 */
	public IZimmer getAktuellesZimmer() throws FokusException;
	
	/**
	 * Methode um eine Leistung auf ein Zimme zu schreiben
	 * @param leistung ILeistung
	 * @throws FokusException
	 * @throws EmptyParameterException
	 */
	public void addLeistung(ILeistung leistung,int anzahl) throws FokusException, EmptyParameterException;
	
	/**
	 * Gibt eine Hashmap von gebuchten Leistungen inklusive Anzahl zu einem Zimmer
	 * @return HashMap<IZimmer, List<LeistungAnzahl>>
	 */
	public HashMap<IZimmer, List<LeistungAnzahl>> getGebuchteLeistungen();
	
	/**
	 * Methode um eine Leistung anhand der Bezeichnung zu erhalten
	 * @param bez
	 * @return ILeistung
	 * @throws DatabaseException
	 * @throws NotContainExeption
	 */
	public ILeistung getLeistungByBezeichnung(String bez) throws DatabaseException, NotContainExeption;
	
	/**
	 * Methode um die gebuchten Leistungen in die Datebank zu speichern
	 * @throws FokusException
	 * @throws WrongParameterException
	 * @throws DatabaseException
	 * @throws NotContainExeption
	 */
	public void saveLeistungen() throws FokusException, WrongParameterException, DatabaseException, NotContainExeption;
	

}
