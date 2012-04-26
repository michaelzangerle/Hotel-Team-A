package projekt.fhv.teama.controller.usecasecontroller.interfaces;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerpreis;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;

/**
 * Interface Check in Controller, beinhaltet alle Wichtigen Methoden für den
 * Check In Controller
 * 
 * @author Team-A
 * @version 1.5
 */
public interface IControllerCheckIn {

	/**
	 * Methode um alle Reservierungen zu holen
	 * 
	 * @return List<IReservierung>
	 * @throws DatabaseException
	 */
	public List<IReservierung> getAllReservierungen() throws DatabaseException;

	/**
	 * Methode um dem Controller mitzuteilen welche Reservierung behandelt wird
	 * 
	 * @param reservierung
	 */
	public void setAktuelleReservierung(IReservierung reservierung);
	
	/**
	 * Um alle Reservierungen abzurufen die heute einchecken
	 * @return
	 * @throws DatabaseException
	 */
	
	/**
	 * Die Referenz der aktuellen reservierung zu erhalten
	 * 
	 * @return IReservierung
	 * @throws FokusException 
	 */
	public IReservierung getAktuelleReservierung() throws FokusException;
	
	
	public List<IReservierung> getCheckInReservierungen() throws DatabaseException;
	
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
	 * Vorname des Gastes ändern
	 * 
	 * @param vorname
	 * @throws FokusException 
	 * @throws EmptyParameterException 
	 */
	public void setVorname(String vorname) throws EmptyParameterException, FokusException;
	
	
	
	/**
	 * Nachname des Gastes ändern
	 * 
	 * @param nachname
	 * @throws EmptyParameterException 
	 * @throws FokusException 
	 */
	public void setNachname(String nachname) throws FokusException, EmptyParameterException;

	/**
	 * Geschlecht des Gastes ändern
	 * 
	 * @param geschlecht
	 */
	public void setGeschlecht(char geschlecht);

	/**
	 * Geburtsdatum des Gastes ändern
	 * 
	 * @param geburtsdatum
	 */
	public void setGeburtsdatum(Date geburtsdatum);

	/**
	 * Email des Gastes ändern
	 * 
	 * @param email
	 * @throws EmptyParameterException 
	 * @throws FokusException 
	 */
	public void setEmail(String email) throws FokusException, EmptyParameterException;

	/**
	 * Kontodaten des Gastes ändern
	 * 
	 * @param kontonummer
	 * @param blz
	 * @param iban
	 * @param bic
	 * @throws FokusException 
	 * @throws WrongParameterException 
	 */
	public void setKontodaten(String kontonummer, String blz, String iban,
			String bic) throws WrongParameterException, FokusException;

	/**
	 * Telefonnummer des Gastes ändern
	 * 
	 * @param telefonnummer
	 * @throws FokusException 
	 */
	public void setTelefonnummer(String telefonnummer) throws FokusException;

	/**
	 * Nummer des Gastes ändern
	 * 
	 * @param nummer
	 * @throws EmptyParameterException 
	 * @throws FokusException 
	 */
	public void setNummer(String nummer) throws FokusException, EmptyParameterException ;

	/**
	 * Zimmer des Gastes ändern
	 * 
	 * @param zimmer
	 * @throws EmptyParameterException 
	 * @throws FokusException 
	 */
	public void setZimmer(IZimmer zimmer) throws FokusException, EmptyParameterException;

	/**
	 * Adresse zum Gast hinzufügen
	 * 
	 * @param adresse
	 * @throws EmptyParameterException 
	 * @throws FokusException 
	 */
	public void addAdresse(IAdresse adresse) throws FokusException, EmptyParameterException ;

	/**
	 * Adresse vom Gast entfernen
	 * 
	 * @param adresse
	 * @throws FokusException 
	 * @throws NotContainExeption 
	 */
	public void removeAdresse(IAdresse adresse) throws NotContainExeption, FokusException;

	/**
	 * Datum von für den Aufenthalt
	 * 
	 * @param date
	 */

	public void setVon(Date date);

	/**
	 * Datum bis für den Aufenthalt
	 * 
	 * @param date
	 */
	public void setBis(Date date);

	/**
	 * Holt alle Pfandtypen die in der Datenbank vorhanden sind
	 * 
	 * @return List<IPfandtyp>
	 * @throws DatabaseException
	 */
	public List<IPfandtyp> getPfandtyps() throws DatabaseException, FokusException;

	/**
	 * Gibt alle verfügbaren Zimmer einer Kategorie zurück
	 * 
	 * @param k
	 * @return List<IZimmer>
	 * @throws FokusException 
	 * @throws DatabaseException 
	 * @throws NotContainExeption 
	 */
	public List<IZimmer> getVerfügbareZimmerFürGegebeneKategorie(IKategorie k)
			throws FokusException, DatabaseException, NotContainExeption ;

	/**
	 * Methode um alle verfügbaren Zimmer zu erhalten
	 * @return List<IZimmer>
	 * @throws DatabaseException
	 * @throws FokusException 
	 */
	public List<IZimmer> getVerfügbareZimmer() throws DatabaseException, FokusException;

	/**
	 * Methode um den Aufenthalt in der Datenbank zu speichern.
	 * 
	 * @param preis
	 * @param von
	 * @param bis
	 * @param schluessel
	 * @param gast
	 * @param zimmer
	 * @param pfand
	 * @param pfandnummer
	 * @throws DatabaseException
	 * @throws FokusException 
	 * @throws WrongParameterException 
	 * @throws EmptyParameterException 
	 * @throws NotContainExeption 
	 */
	public void saveAufenthalt(float preis, Date von, Date bis,
			boolean schluessel, IGast gast, IZimmer zimmer, IPfandtyp pfand,
			String pfandnummer) throws DatabaseException, FokusException, WrongParameterException, EmptyParameterException, NotContainExeption;

	/**
	 * Methode um ein Land anhand eines Kuerzel zu erhalten
	 * @param kuerzel
	 * @return ILand
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 * @throws NotContainExeption
	 */
	public ILand getLandByKuerzel(String kuerzel) throws DatabaseException, EmptyParameterException, NotContainExeption;
	
	/**
	 * Methode um alle Aufenthalte des Hoteles abzurufen
	 * @return List<IAufenthalt>
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	public List<IAufenthalt> getAufenthalte() throws DatabaseException, EmptyParameterException;
	
	
	/**
	 * Metode um alle Zimmer pro Kategorie auszuwählen
	 * @return Hasmap<IKategorie,List<IZimmer>>
	 * @throws DatabaseException
	 * @throws FokusException
	 */
	public HashMap<IKategorie, List<IZimmer>> getVerfuegbareZimmer() throws DatabaseException, FokusException;
	
	/**
	 * Methode um ein Zimmer zur ausgewählten Zimmerlist hinzuzufügen
	 * @param z
	 * @throws WrongParameterException
	 */
	public void addZimmer(IZimmer z) throws WrongParameterException;
	
	/**
	 * Methode um ein Zimmer von der ausgewählten Zimmerlist zu löschen
	 * @param z
	 * @throws WrongParameterException
	 */
	public void remove(IZimmer z) throws WrongParameterException;
	
	/**
	 * Methode um die Ausgewählten Zimmer abzurufen
	 * @return List<IZimmer>
	 * @throws NotContainExeption
	 */
	public List<IZimmer> getAusgewählteZimmer() throws NotContainExeption;
	
	/**
	 * Methode um die Listen im CheckInController  zu löschen
	 */
	public void clearLists();
	
	/**
	 * Methode um die Verfuegbaren Zimmer in den Cache zu laden
	 * @throws DatabaseException
	 * @throws FokusException
	 */
	public void initVerfuegbareZimmer() throws DatabaseException, FokusException;
	
	/**
	 * Methode um ein Land über eine Bezeichnung zu suchen
	 * @param bezeichnung
	 * @return ILand
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 * @throws NotContainExeption
	 */
	public ILand getLandByBezeichnung(String bezeichnung) throws DatabaseException, EmptyParameterException, NotContainExeption;
	
	
	/**
	 * Methode um die Gaeste die Momentan einen Aufenthalt haben holen
	 * @return List<IGast>
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	public List<IGast> getGaesteVonAuftenhalt() throws DatabaseException, EmptyParameterException;
	
	/**
	 * Methode um eine Zimmerpreis einer Kategorie zu erhalten
	 * @param k
	 * @return IZimmerpreis
	 * @throws DatabaseEntryNotFoundException
	 * @throws EmptyParameterException
	 */
	public IZimmerpreis getZimmerpreisProKategorie(IKategorie k) throws DatabaseEntryNotFoundException, EmptyParameterException;
	
	/**
	 * Methode um den Gesamtpreis eines Aufenthaltes zu berechnen
	 * @param von
	 * @param bis
	 * @return float preis
	 * @throws FokusException
	 * @throws DatabaseEntryNotFoundException
	 * @throws EmptyParameterException
	 */
	public float berechneZimmerpreis(Date von,Date bis) throws FokusException, DatabaseEntryNotFoundException, EmptyParameterException;
	
	
	
	
	

}