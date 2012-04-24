package projekt.fhv.teama.controller.usecasecontroller;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.IPfandtyp;
import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IStatusentwicklung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.model.interfaces.IModelAdresse;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;
import projekt.fhv.teama.model.interfaces.IModelGast;
import projekt.fhv.teama.model.interfaces.IModelKategorie;
import projekt.fhv.teama.model.interfaces.IModelKontodaten;
import projekt.fhv.teama.model.interfaces.IModelLand;
import projekt.fhv.teama.model.interfaces.IModelPfandTyp;
import projekt.fhv.teama.model.interfaces.IModelReservierung;
import projekt.fhv.teama.model.interfaces.IModelStatusentwicklung;
import projekt.fhv.teama.model.interfaces.IModelTeilreservierung;
import projekt.fhv.teama.model.interfaces.IModelZimmer;
import projekt.fhv.teama.model.interfaces.IModelZimmerstatus;

public class ControllerCheckIn implements IControllerCheckIn {

	IModelReservierung modelReservierung;
	IModelAufenthalt modelAufenthalt;
	IModelGast modelGast;
	IModelTeilreservierung modelTeilreservierung;
	IModelKategorie modelKategorie;
	IModelPfandTyp modelPfandtyp;
	IModelZimmer modelZimmer;
	IModelZimmerstatus modelZimmerstatus;
	IModelKontodaten modelKontodaten;
	IModelAdresse modelAdresse;
	IModelLand modelLand;
	IModelStatusentwicklung modelStatusentwicklung;

	/**
	 * 
	 * Konstruktor ControllerCheckIn CeckIn Kontroller ist für den Usercase
	 * Check In zuständig
	 */
	public ControllerCheckIn(IModelReservierung cres, IModelAufenthalt cauf,
			IModelGast cgast, IModelTeilreservierung ctres,
			IModelKategorie ckat, IModelKontodaten ckonto,
			IModelPfandTyp cpfandTyp, IModelZimmer czimmer,
			IModelZimmerstatus czimmerStatus, IModelAdresse cadr,
			IModelLand cland, IModelStatusentwicklung cstaent) {

		modelReservierung = cres;
		modelAufenthalt = cauf;
		modelGast = cgast;
		modelTeilreservierung = ctres;
		modelKategorie = ckat;
		modelPfandtyp = cpfandTyp;
		modelZimmer = czimmer;
		modelZimmerstatus = czimmerStatus;
		modelKontodaten = ckonto;
		modelAdresse = cadr;
		modelLand = cland;
		modelStatusentwicklung = cstaent;
	}

	/**
	 * Methode um alle Reservierungen zu holen
	 * 
	 * @return List<IReservierung>
	 * @throws DatabaseException 
	 */
	public List<IReservierung> getAllReservierungen() throws DatabaseException {
		return modelReservierung.getAllReservierungen();
	}

	/**
	 * Methode um dem Controller mitzuteilen welche Reservierung behandelt wird
	 * 
	 * @param reservierung
	 */
	public void setAktuelleReservierung(IReservierung reservierung) {
		modelReservierung.setAktuelleReservierung(reservierung);
	}

	/**
	 * Die Referenz der aktuellen reservierung zu erhalten
	 * 
	 * @return IReservierung
	 * @throws FokusException 
	 */
	public IReservierung getAktuelleReservierung() throws FokusException {
		return modelReservierung.getAktuelleReservierung();
	}

	public List<IReservierung> getCheckInReservierungen() throws DatabaseException {
		return modelReservierung.getCheckInReservierungen(MyLittleDate.getDate(2012, 3, 24));
	}

	/**
	 * Die Referenz auf den aktuellen Gast setzen
	 * 
	 * @param IGast
	 */
	public void setGast(IGast gast) {
		modelGast.setAktuellGast(gast);
	}

	/**
	 * Die Referenz des aktuellen Gast zu erhalten
	 * 
	 */
	public IGast getGast() {
		return modelGast.getAktuellGast();
	}

	// Änderungen am Gast

	/**
	 * Vorname des Gastes ändern
	 * 
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		modelGast.setVorname(vorname);
	}

	/**
	 * Nachname des Gastes ändern
	 * 
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		modelGast.setNachname(nachname);

	}

	/**
	 * Geschlecht des Gastes ändern
	 * 
	 * @param geschlecht
	 */
	public void setGeschlecht(char geschlecht) {
		modelGast.setGeschlecht(geschlecht);
	}

	/**
	 * Geburtsdatum des Gastes ändern
	 * 
	 * @param geburtsdatum
	 */
	public void setGeburtsdatum(Date geburtsdatum) {
		modelGast.setGeburtsdatum(geburtsdatum);
	}

	/**
	 * Email des Gastes ändern
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		modelGast.setEmail(email);
	}

	/**
	 * Kontodaten des Gastes ändern
	 * 
	 * @param kontonummer
	 * @param blz
	 * @param iban
	 * @param bic
	 */
	public void setKontodaten(String kontonummer, String blz, String iban,
			String bic) {
		modelGast.setKontodaten(kontonummer, blz, iban, bic);
	}

	/**
	 * Telefonnummer des Gastes ändern
	 * 
	 * @param telefonnummer
	 */
	public void setTelefonnummer(String telefonnummer) {
		modelGast.setTelefonnummer(telefonnummer);
	}

	/**
	 * Nummer des Gastes ändern
	 * 
	 * @param nummer
	 */
	public void setNummer(String nummer) {
		modelGast.setNummer(nummer);
	}

	/**
	 * Zimmer des Gastes ändern
	 * 
	 * @param zimmer
	 */
	public void setZimmer(IZimmer zimmer) {
		modelGast.setZimmer(zimmer);
	}

	/**
	 * Adresse zum Gast hinzufügen
	 * 
	 * @param adresse
	 */
	public void addAdresse(IAdresse adresse) {
		modelGast.addAdresse(adresse);
	}

	/**
	 * Adresse vom Gast entfernen
	 * 
	 * @param adresse
	 */
	public void removeAdresse(IAdresse adresse) {
		modelGast.removeAdresse(adresse);
	}

	/**
	 * Datum von für den Aufenthalt
	 * 
	 * @param date
	 */

	public void setVon(Date date) {
		modelReservierung.setVon(date);
	}

	/**
	 * Datum bis für den Aufenthalt
	 * 
	 * @param date
	 */
	public void setBis(Date date) {
		modelReservierung.setBis(date);

	}

	/**
	 * Holt alle Pfandtypen die in der Datenbank vorhanden sind
	 * 
	 * @return List<IPfandtyp>
	 * @throws DatabaseException
	 */
	public List<IPfandtyp> getPfandtyps() throws DatabaseException {
		return modelPfandtyp.getPfandtyps();
	}

	/**
	 * Gibt alle verfügbaren Zimmer einer Kategorie zurück
	 * 
	 * @param k
	 * @return List<IZimmer>
	 * @throws DatabaseEntryNotFoundException
	 * @throws FokusException 
	 */
	public List<IZimmer> getVerfügbareZimmerFürGegebeneKategorie(IKategorie k)
			throws DatabaseEntryNotFoundException, FokusException {
		return modelZimmer.getVerfuegbareZimmerFürGegebeneKategorie(k,
				getAktuelleReservierung());
	}

	public List<IZimmer> getVerfügbareZimmer() {
		return modelZimmer.getVerfügbareZimmer();
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
	 * @throws DatabaseException
	 * @throws FokusException 
	 * @throws WrongParameterException 
	 * @throws EmptyParameterException 
	 */
	public void saveAufenthalt(float preis, Date von, Date bis,
			boolean schluessel, IGast gast, IZimmer zimmer, IPfandtyp pfand,
			String pfandnummer) throws DatabaseException, FokusException, WrongParameterException, EmptyParameterException {

		modelKontodaten.save(gast.getKontodaten());
		modelZimmer.setAktullesZimmer(zimmer);
		
		IZimmerstatus b = modelZimmerstatus.getStatusByKuerzel("BNG");
		
		modelZimmer.setStatus(b);

		modelStatusentwicklung.add(modelZimmer.getAktullesZimmer(), b,
				getAktuelleReservierung());
		
				
		modelZimmer.save(modelZimmer.getAktullesZimmer());
		
		
		for (IAdresse adr : gast.getAdressen()) {
			modelAdresse.save(adr);

			modelGast.save(gast);
			modelAufenthalt.create(preis, von, bis, schluessel, gast, zimmer,
					pfand, pfandnummer);
			modelReservierung.setBearbeitet(true);
			modelReservierung.save(getAktuelleReservierung());
		}

	}

	public ILand getLandByKuerzel(String kuerzel) throws DatabaseException {
		return modelLand.getLandByKuerzel(kuerzel);
	}

}