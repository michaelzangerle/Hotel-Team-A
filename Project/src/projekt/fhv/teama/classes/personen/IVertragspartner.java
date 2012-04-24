package projekt.fhv.teama.classes.personen;

import java.util.Set;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.zimmer.IReservierung;


/**
 * Beschreibt die Methoden eines  Vertragspartners unseres Hoteles
 * @author Team-A
 * @version 1.5
 */
public interface IVertragspartner extends IModel {
	
	/**
	 * Um den Namen des Vertragpartners zu �ndern
	 * @param name String
	 */
	public void setName(String name);

	/**
	 * Um den Namen des Gastes zu holen
	 * @return String
	 */
	public String getName();

	/**
	 * Um die Telefonnummer einer Person zu �ndern
	 * @param telefonnummer String
	 */
	public void setTelefonNummer(String telefonnummer);

	/**
	 * Um die Telefonnummer einer Person zu erhalten
	 * @return String
	 */
	public String getTelefonNummer();

	/**
	 * Um die Emailadresse der Person zu �ndern
	 * @param email String
	 */
	public void setEmail(String email);

	/**
	 * Um die Emailadresse einer Person zu erhalten
	 * @return String email
	 */
	public String getEmail();

	/**
	 * Um die Kontodaten einer Person zu �ndern
	 * @param kontodaten IKontodaten
	 */
	public void setKontodaten(IKontodaten kontodaten);

	/**
	 * Holt die Kontodaten eines Gastes
	 * @return IKontodaten kontodaten
	 */
	public IKontodaten getKontodaten();

	/**
	 * Um der Person eine Adresse hinzuzuf�gen
	 * @param adresse IAdresse
	 */
	public void addAdresse(IAdresse adresse);

	/**
	 * Um die Adressen zu einer Person zu erhalten
	 * @return adressen Set<IAdresse>
	 */
	public Set<IAdresse> getAdressen();

	/**
	 * Um eine Adresse einer Person zu l�schen
	 * @param adresse IAdresse
	 */
	public void removeAdresse(IAdresse adresse);

	/**
	 * Um einen Adressensatz zu setzen
	 * @param adresse Set<IAdresse>
	 */
	public void setAdressen(Set<IAdresse> adresse);

	/**
	 * Um das Kontigent f�r den Vertragpartner abzurufen
	 * @return Set<IKontigent>
	 */
	public Set<IKontingent> getKontingente();

	/**
	 * Um das Kontigent zu setzen
	 * @param kontingent Set<IKontigent>
	 */
	public void setKontingente(Set<IKontingent> kontingent);

	/**
	 * Um ein Kontigent hinzuzuf�gen
	 * @param kontingent IKontigent
	 */
	public void addKontingent(IKontingent kontingent);
	/**
	 * Um ein Kontigent zu l�schen
	 * @param kontingent IKontigent
	 */
	public void removeKontingent(IKontingent kontingent);

	/**
	 * Um die Reservierungen f�r die Person zu erhalten
	 * @return Set<IReservierung>
	 */
	public Set<IReservierung> getReservierungen();

	/**
	 * Um ein Set von Reservierungen zu setzen
	 * @param reservierungen Set<IReservierung>
	 */
	public void setReservierungen(Set<IReservierung> reservierungen);

	/**
	 * Um eine Reservierung zur Person hinzuzuf�gen
	 * @param reservierung IReservierung
	 */
	public void addReservierung(IReservierung reservierung);

	/**
	 * Um eine Reservierung zu l�schen
	 * @param reservierung IReservierung
	 */
	public void removeReservierung(IReservierung reservierung);

	
	public IVertragspartnertyp getTyp();

	public void setTyp(IVertragspartnertyp typ);
}
