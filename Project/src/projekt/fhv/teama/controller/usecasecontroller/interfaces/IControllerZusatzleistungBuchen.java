package projekt.fhv.teama.controller.usecasecontroller.interfaces;
import java.util.HashMap;
import java.util.List;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.LeistungAnzahl;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IALeistung;
import projekt.fhv.teama.integrate.IAZimmer;
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
	public List<IAAufenthalt> getAufenthalte() throws DatabaseException;
	
	/**
	 * Methode um alle Gaeste die zurzeit im Hotel sind zu erhalten
	 * @return List<IGast>
	 * @throws DatabaseException
	 */
	public List<IAGast> getGaesteVonAuftenhalten() throws DatabaseException;

	/**
	 * Methode um die Gäste zum Ausgewählten Aufenthalt zu erhalten
	 * @return List<IGast>
	 * @throws FokusException
	 */
	public List<IAGast> getGaesteZumAufenhalt() throws FokusException;
	
	/**
	 * Methode um den Fokus auf einen Aufenthalt zu legen
	 * @param aufenhalt
	 * @throws EmptyParameterException
	 */
	public void setAufenthalt(IAAufenthalt aufenhalt) throws EmptyParameterException;
	
	/**
	 * Methode um den Aufenhalt der derzeitig bearbeitete wird zu erhalten
	 * @return IAufenhalt
	 * @throws FokusException
	 */
	public IAAufenthalt getAufenthalt() throws FokusException;
	
	/**
	 * Die Referenz auf den aktuellen Gast setzen
	 * 
	 * @param IGast
	 */
	public void setGast(IAGast gast);
	
	/**
	 * Die Referenz des aktuellen Gast zu erhalten
	 * @throws FokusException 
	 * 
	 */
	public IAGast getGast() throws FokusException;
	
	
	/**
	 * Methode um die eine Liste von Zimmern zu erhalten die auf diesen Gast Laufen
	 * @return List<IZimmer>
	 * @throws FokusException
	 * @throws DatabaseException
	 */
	public List<IAZimmer> getZimmerVonGast() throws FokusException, DatabaseException;
	
	/**
	 * Methode um den Gast anhand seiner Nummer zu erhalten
	 * @param nummer
	 * @return IGast
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 * @throws NotContainExeption
	 */
	public IAGast getGastByNummer(String nummer) throws DatabaseException, EmptyParameterException, NotContainExeption;

	/**
	 * Methode um die Artikel und die Zusatzleistungen zu holen
	 * @return	List<ILeistung>
	 * @throws DatabaseException
	 */
	public List<IALeistung> getArtikelundZusatzleistungen() throws DatabaseException;
	
	
	/**
	 * Methode um das aktuell bearbeitete Zimmer zu setzen
	 * @param zimmer
	 * @throws EmptyParameterException
	 */
	public void setAktuellesZimmer(IAZimmer zimmer) throws EmptyParameterException;
	
	/**
	 * Methode um das aktuell bearbeitete Zimmer zu erhalten
	 * @return IZimmer
	 * @throws FokusException
	 */
	public IAZimmer getAktuellesZimmer() throws FokusException;
	
	/**
	 * Methode um eine Leistung auf ein Zimme zu schreiben
	 * @param leistung ILeistung
	 * @throws FokusException
	 * @throws EmptyParameterException
	 */
	public void addLeistung(IALeistung leistung,int anzahl) throws FokusException, EmptyParameterException;
	
	/**
	 * Gibt eine Hashmap von gebuchten Leistungen inklusive Anzahl zu einem Zimmer
	 * @return HashMap<IZimmer, List<LeistungAnzahl>>
	 */
	public HashMap<IAZimmer, List<LeistungAnzahl>> getGebuchteLeistungen();
	
	/**
	 * Methode um eine Leistung anhand der Bezeichnung zu erhalten
	 * @param bez
	 * @return ILeistung
	 * @throws DatabaseException
	 * @throws NotContainExeption
	 */
	public IALeistung getLeistungByBezeichnung(String bez) throws DatabaseException, NotContainExeption;
	
	/**
	 * Methode um die gebuchten Leistungen in die Datebank zu speichern
	 * @throws FokusException
	 * @throws WrongParameterException
	 * @throws DatabaseException
	 * @throws NotContainExeption
	 */
	public void saveLeistungen() throws FokusException, WrongParameterException, DatabaseException, NotContainExeption;
	
	/**
	 * Methode um die Bereits gebuchten Leistungen für diesne Aufenhalt zu bekommen
	 * @return List<LeistungAnzahl>
	 * @throws DatabaseException
	 * @throws FokusException
	 */
	public List<LeistungAnzahl> bereitsgebuchtLeistungenFuerGast() throws DatabaseException, FokusException;
}
