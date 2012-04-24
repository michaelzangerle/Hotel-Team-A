package projekt.fhv.teama.classes.personen;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.zimmer.IReservierung;



/**
 * Diese Klasse wiederspiegelt eine Person
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
	 * @param geburtsdatum
	 */
	public void setGeburtsdatum(Date geburtsdatum);

	public Date getGeburtsdatum();

	public void setTelefonnummer(String telefonnummer);

	public String getTelefonnummer();

	public void setEmail(String email);

	public String getEmail();

	public void setKontodaten(IKontodaten kontodaten);

	public IKontodaten getKontodaten();

	public void addAdresse(IAdresse adresse);

	public Set<IAdresse> getAdressen();

	public void removeAdresse(IAdresse adresse);

	public void setAdressen(Set<IAdresse> adresse);
	
	public void addReserviert(IReservierung reservierung);
	
	public Set<IReservierung> getReserviert();

	public void removeReserviert(IReservierung reservierung);

	public void setReserviert(Set<IReservierung> reservierungen);
}
