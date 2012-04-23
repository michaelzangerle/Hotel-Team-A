package projekt.fhv.teama.controller.usecasecontroller;

import java.sql.Date;
import java.util.List;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.interfaces.IControllerAdresse;
import projekt.fhv.teama.controller.interfaces.IControllerAufenthalt;
import projekt.fhv.teama.controller.interfaces.IControllerGast;
import projekt.fhv.teama.controller.interfaces.IControllerKategorie;
import projekt.fhv.teama.controller.interfaces.IControllerKontodaten;
import projekt.fhv.teama.controller.interfaces.IControllerPfandTyp;
import projekt.fhv.teama.controller.interfaces.IControllerReservierung;
import projekt.fhv.teama.controller.interfaces.IControllerTeilreservierung;
import projekt.fhv.teama.controller.interfaces.IControllerZimmer;
import projekt.fhv.teama.controller.interfaces.IControllerZimmerstatus;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class ControllerCheckIn implements IControllerCheckIn {

	IControllerReservierung controllerReservierung;
	IControllerAufenthalt controllerAufenthalt;
	IControllerGast controllerGast;
	IControllerTeilreservierung controllerTeilreservierung;
	IControllerKategorie controllerKategorie;
	IControllerPfandTyp controllerPfandtyp;
	IControllerZimmer controllerZimmer;
	IControllerZimmerstatus controllerZimmerstatus;
	IControllerKontodaten controllerKontodaten;
	IControllerAdresse controllerAdresse;

	/**
	 * 
	 * Konstruktor ControllerCheckIn CeckIn Kontroller ist für den Usercase
	 * Check In zuständig
	 */
	public ControllerCheckIn(IControllerReservierung cres, IControllerAufenthalt cauf, IControllerGast cgast,
			IControllerTeilreservierung ctres, IControllerKategorie ckat, IControllerKontodaten ckonto,
			IControllerPfandTyp cpfandTyp, IControllerZimmer czimmer, IControllerZimmerstatus czimmerStatus,
			IControllerAdresse cadr) {

		controllerReservierung = cres;
		controllerAufenthalt = cauf;
		controllerGast = cgast;
		controllerTeilreservierung = ctres;
		controllerKategorie = ckat;
		controllerPfandtyp = cpfandTyp;
		controllerZimmer = czimmer;
		controllerZimmerstatus = czimmerStatus;
		controllerKontodaten = ckonto;
		controllerAdresse = cadr;
	}

	/**
	 * Methode um alle Reservierungen zu holen
	 * 
	 * @return List<IReservierung>
	 */
	public List<IReservierung> getAllReservierungen() {
		return controllerReservierung.getAllReservierungen();
	}

	/**
	 * Methode um dem Controller mitzuteilen welche Reservierung behandelt wird
	 * 
	 * @param reservierung
	 */
	public void setAktuelleReservierung(IReservierung reservierung) {
		controllerReservierung.setAktuelleReservierung(reservierung);
	}

	/**
	 * Die Referenz der aktuellen reservierung zu erhalten
	 * 
	 * @return IReservierung
	 */
	public IReservierung getAktuelleReservierung() {
		return controllerReservierung.getAktuelleReservierung();
	}

	/**
	 * Die Referenz auf den aktuellen Gast setzen
	 * 
	 * @param IGast
	 */
	public void setGast(IGast gast) {
		controllerGast.setAktuellGast(gast);
	}

	/**
	 * Die Referenz des aktuellen Gast zu erhalten
	 * 
	 */
	public IGast getGast() {
		return controllerGast.getAktuellGast();
	}

	// Änderungen am Gast

	/**
	 * Vorname des Gastes ändern
	 * 
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		controllerGast.setVorname(vorname);
	}

	/**
	 * Nachname des Gastes ändern
	 * 
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		controllerGast.setNachname(nachname);

	}

	/**
	 * Geschlecht des Gastes ändern
	 * 
	 * @param geschlecht
	 */
	public void setGeschlecht(char geschlecht) {
		controllerGast.setGeschlecht(geschlecht);
	}

	/**
	 * Geburtsdatum des Gastes ändern
	 * 
	 * @param geburtsdatum
	 */
	public void setGeburtsdatum(Date geburtsdatum) {
		controllerGast.setGeburtsdatum(geburtsdatum);
	}

	/**
	 * Email des Gastes ändern
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		controllerGast.setEmail(email);
	}

	/**
	 * Kontodaten des Gastes ändern
	 * 
	 * @param kontonummer
	 * @param blz
	 * @param iban
	 * @param bic
	 */
	public void setKontodaten(String kontonummer, String blz, String iban, String bic) {
		controllerGast.setKontodaten(kontonummer, blz, iban, bic);
	}

	/**
	 * Telefonnummer des Gastes ändern
	 * 
	 * @param telefonnummer
	 */
	public void setTelefonnummer(String telefonnummer) {
		controllerGast.setTelefonnummer(telefonnummer);
	}

	/**
	 * Nummer des Gastes ändern
	 * 
	 * @param nummer
	 */
	public void setNummer(String nummer) {
		controllerGast.setNummer(nummer);
	}

	/**
	 * Zimmer des Gastes ändern
	 * 
	 * @param zimmer
	 */
	public void setZimmer(IZimmer zimmer) {
		controllerGast.setZimmer(zimmer);
	}

	/**
	 * Adresse zum Gast hinzufügen
	 * 
	 * @param adresse
	 */
	public void addAdresse(IAdresse adresse) {
		controllerGast.addAdresse(adresse);
	}

	/**
	 * Adresse vom Gast entfernen
	 * 
	 * @param adresse
	 */
	public void removeAdresse(IAdresse adresse) {
		controllerGast.removeAdresse(adresse);
	}

	/**
	 * Datum von für den Aufenthalt
	 * 
	 * @param date
	 */

	public void setVon(Date date) {
		controllerReservierung.setVon(date);
	}

	/**
	 * Datum bis für den Aufenthalt
	 * 
	 * @param date
	 */
	public void setBis(Date date) {
		controllerReservierung.setBis(date);

	}

	/**
	 * Holt alle Pfandtypen die in der Datenbank vorhanden sind
	 * 
	 * @return List<IPfandtyp>
	 * @throws DatabaseException
	 */
	public List<IPfandtyp> getPfandtyps() throws DatabaseException {
		return controllerPfandtyp.getPfandtyps();
	}

	/**
	 * Gibt alle verfügbaren Zimmer einer Kategorie zurück
	 * 
	 * @param k
	 * @return List<IZimmer>
	 * @throws DatabaseEntryNotFoundException
	 */
	public List<IZimmer> getVerfügbareZimmerFürGegebeneKategorie(IKategorie k) throws DatabaseEntryNotFoundException {
		return controllerZimmer.getVerfuegbareZimmerFürGegebeneKategorie(k);
	}

	public List<IZimmer> getVerfügbareZimmer() {
		return controllerZimmer.getVerfügbareZimmer();
	}

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
	 */
	public void saveAufenthalt(float preis, Date von, Date bis, boolean schluessel, IGast gast, IZimmer zimmer,
			IPfandtyp pfand, String pfandnummer) {

		controllerKontodaten.save(gast.getKontodaten());
		controllerZimmer.save(zimmer);
		for (IAdresse adr : gast.getAdressen()) {
			controllerAdresse.save(adr);
		}
		controllerGast.save(gast);
		controllerAufenthalt.create(preis, von, bis, schluessel, gast, zimmer, pfand, pfandnummer);

	}

}