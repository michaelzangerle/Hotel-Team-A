package projekt.fhv.teama.model.interfaces;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;

public interface IModelGast {

	void setAktuellGast(IGast gast);

	IGast getAktuellGast() throws FokusException;

	void setVorname(String vorname) throws EmptyParameterException, FokusException;

	void setNachname(String nachname) throws FokusException, EmptyParameterException;

	void setGeschlecht(char geschlecht);

	void setGeburtsdatum(Date geburtsdatum);

	void setKontodaten(String kontonummer, String blz, String iban, String bic) throws WrongParameterException, FokusException;

	void setEmail(String email) throws FokusException, EmptyParameterException;

	void removeAdresse(IAdresse adresse) throws NotContainExeption, FokusException;
	
	void addAdresse(IAdresse adresse) throws FokusException, EmptyParameterException;

	void setNummer(String nummer) throws FokusException, EmptyParameterException;

	void setZimmer(IZimmer zimmer) throws FokusException, EmptyParameterException;

	void setTelefonnummer(String telefonnummer) throws FokusException;

	void save(IGast gast) throws DatabaseException, EmptyParameterException;



}
