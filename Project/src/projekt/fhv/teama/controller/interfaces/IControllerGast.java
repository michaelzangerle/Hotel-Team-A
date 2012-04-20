package projekt.fhv.teama.controller.interfaces;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;

public interface IControllerGast {

	void setAktuellGast(IGast gast);

	IGast getAktuellGast();

	void setVorname(String vorname);

	void setNachname(String nachname);

	void setGeschlecht(char geschlecht);

	void setGeburtsdatum(Date geburtsdatum);

	void setKontodaten(String kontonummer, String blz, String iban, String bic);

	void setEmail(String email);

	void removeAdresse(IAdresse adresse);
	
	void addAdresse(IAdresse adresse);

	void setNummer(String nummer);

	void setZimmer(IZimmer zimmer);

	void setTelefonnummer(String telefonnummer);



}
