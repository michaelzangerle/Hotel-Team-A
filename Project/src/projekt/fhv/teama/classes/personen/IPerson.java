package projekt.fhv.teama.classes.personen;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.zimmer.IReservierung;



/**
 * Dieses Interface wiederspiegelt eine Person
 * @author Team-A
 * @version 1.5
 */
public interface IPerson extends IModel {
	
	/**
	 * Um den Vornamen einer Person zu ändern
	 * @param vorname String
	 */
	public void setVorname(String vorname);

	/**
	 * Um den Vornamen einer Person zu erhalten
	 * @return String vorname
	 */
	public String getVorname();

	/**
	 * Um den Nachnamen einer Person zu ändern
	 * @param nachname String
	 */
	public void setNachname(String nachname);

	/**
	 * Um den Nachnamen einer Perosn zu erhalten
	 * @return String nachname
	 */
	public String getNachname();

	/**
	 * Um das Geschlecht einer Person zu ändern
	 * @param geschlecht Char
	 */
	public void setGeschlecht(char geschlecht);

	/**
	 * Um das Geschlecht einer Person zu erhalten
	 * @return Character geschlecht
	 */
	public Character getGeschlecht();

	/**
	 * Um das Geburtsdatum einer Person 
	 * @param geburtsdatum Date 
	 */
	public void setGeburtsdatum(Date geburtsdatum);

	/**
	 * Um ein Geburtsdatum einer Person zu erhalten
	 * @return Date Geburtsdatum
	 */
	public Date getGeburtsdatum();

	/**
	 * Um die Telefonnummer einer Person zu ändern
	 * @param telefonnummer String
	 */
	public void setTelefonnummer(String telefonnummer);

	/**
	 * Um die Telefonnummer einer Person zu erhalten
	 * @return String
	 */
	public String getTelefonnummer();

	/**
	 * Um die Emailadresse der Person zu ändern
	 * @param email String
	 */
	public void setEmail(String email);

	/**
	 * Um die Emailadresse einer Person zu erhalten
	 * @return String email
	 */
	public String getEmail();

	/**
	 * Um die Kontodaten einer Person zu ändern
	 * @param kontodaten IKontodaten
	 */
	public void setKontodaten(IKontodaten kontodaten);

	/**
	 * Holt die Kontodaten eines Gastes
	 * @return IKontodaten kontodaten
	 */
	public IKontodaten getKontodaten();

	/**
	 * Um der Person eine Adresse hinzuzufügen
	 * @param adresse IAdresse
	 */
	public void addAdresse(IAdresse adresse);

	/**
	 * Um die Adressen zu einer Person zu erhalten
	 * @return adressen Set<IAdresse>
	 */
	public Set<IAdresse> getAdressen();

	/**
	 * Um eine Adresse einer Person zu löschen
	 * @param adresse IAdresse
	 */
	public void removeAdresse(IAdresse adresse);

	/**
	 * Um einen Adressensatz zu setzen
	 * @param adresse Set<IAdresse>
	 */
	public void setAdressen(Set<IAdresse> adresse);
	
	/**
	 * Um eine Reservierung zur Person hinzuzufügen
	 * @param reservierung IReservierung
	 */
	public void addReserviert(IReservierung reservierung);
	
	/**
	 * Um die Reservierungen für die Person zu erhalten
	 * @return Set<IReservierung>
	 */
	public Set<IReservierung> getReserviert();

	/**
	 * Um eine Reservierung zu löschen
	 * @param reservierung IReservierung
	 */
	public void removeReserviert(IReservierung reservierung);
	/**
	 * Um ein Set von Reservierungen zu setzen
	 * @param reservierungen Set<IReservierung>
	 */
	public void setReserviert(Set<IReservierung> reservierungen);
}
