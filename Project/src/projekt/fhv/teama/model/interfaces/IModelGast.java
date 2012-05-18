package projekt.fhv.teama.model.interfaces;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAdresse;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.model.integration.IAModelGast;


/**
 * Beschreibt das Interface für das Gast Model, beinhaltet alle wichtigen Methoden um mit einem Gast arbeiten zukönne
 * @author Team-A
 * @version 1.5
 */
public interface IModelGast extends IAModelGast{

	/**
	 * Um den Fokus auf einen Gast zu setzen
	 * @param gast IGast
	 */
	void setAktuellGast(IAGast gast);

	/**
	 * Um den fokusierten Gast abzurufen
	 * @return IGast
	 * @throws FokusException
	 */
	IAGast getAktuellGast() throws FokusException;

	/**
	 * Um den Vornamen zu ändern
	 * @param vorname String
	 * @throws EmptyParameterException
	 * @throws FokusException
	 */
	void setVorname(String vorname) throws EmptyParameterException, FokusException;


	/**
	 * Um den Nachname zu ändern
	 * @param nachname String
	 * @throws EmptyParameterException
	 * @throws FokusException
	 */
	void setNachname(String nachname) throws FokusException, EmptyParameterException;

	/**
	 * Um das Geschlecht zu ändern
	 * @param geschlecht char m oder w
	 */
	void setGeschlecht(char geschlecht);

	/**
	 * Um das Geburtsdatum zu ändern
	 * @param geburtsdatum Date
	 */
	void setGeburtsdatum(Date geburtsdatum);

	/**
	 * Um die Kontodaten zu ändern
	 * @param kontonummer
	 * @param blz
	 * @param iban
	 * @param bic
	 * @throws WrongParameterException
	 * @throws FokusException
	 */
	void setKontodaten(String kontonummer, String blz, String iban, String bic) throws WrongParameterException, FokusException;

	/**
	 * Um die Emailadresse zu ändern
	 * @param email
	 * @throws FokusException
	 * @throws EmptyParameterException
	 */
	void setEmail(String email) throws FokusException, EmptyParameterException;

	/**
	 * Um eine Adresse zu löschen
	 * @param adresse
	 * @throws NotContainExeption
	 * @throws FokusException
	 */
	void removeAdresse(IAdresse adresse) throws NotContainExeption, FokusException;
	/**
	 * Um eine Adresse hinzuzufügne
	 * @param adresse
	 * @throws NotContainExeption
	 * @throws FokusException
	 */
	void addAdresse(IAdresse adresse) throws FokusException, EmptyParameterException;

	/**
	 * Um die Gastnummer zu setzen
	 * @param nummer
	 * @throws FokusException
	 * @throws EmptyParameterException
	 */
	void setNummer(String nummer) throws FokusException, EmptyParameterException;

	/**
	 * Um eine Zimmer beim Gast zu stetzen
	 * @param zimmer
	 * @throws FokusException
	 * @throws EmptyParameterException
	 */
	void setZimmer(IZimmer zimmer) throws FokusException, EmptyParameterException;

	/**
	 * Um die Telefonnummer zu setzen
	 * @param telefonnummer
	 * @throws FokusException
	 */
	void setTelefonnummer(String telefonnummer) throws FokusException;

	/**
	 * Um einen Gast zu setzen
	 * @param gast
	 * @throws DatabaseException
	 * @throws EmptyParameterException
	 */
	void save(IGast gast) throws DatabaseException, EmptyParameterException;



}
