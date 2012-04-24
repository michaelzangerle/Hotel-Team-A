package projekt.fhv.teama.classes.rechnung;

import java.util.Set;

import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.personen.IMitarbeiter;

/**
 * Interface für eine Rechnung
 * 
 * @author Team A
 * @version 1.9
 */
public interface IRechnung extends IModel {

	/**
	 * Gibt den Wert des Attributs Nummer zurück
	 * @return String
	 */
	public String getNummer();

	/**
	 * Setzt das Attribut Nummer auf den übergebenen Wert
	 * @param nummer String
	 */
	public void setNummer(String nummer);

	/**
	 * Fügt eine Rechnungsposition zu dem Attribut Rechnungspositionen hinzu
	 * @param rePos IRechnungsposition
	 */
	public void addRechnungsposition(IRechnungsposition rePos);

	/**
	 * Entfernt eine Rechnungsposition vom Attribut Rechnungspositionen
	 * @param rePos IRechnungsposition
	 */
	public void removeRechnungsposition(IRechnungsposition rePos);

	/**
	 * Gibt den Wert des Attributs Rechnungspositionen zurück
	 * @return Set<IRechnungsposition>
	 */
	public Set<IRechnungsposition> getRechnungspositionen();

	/**
	 * Setzt das Attribut Summe auf den übergebenen Wert
	 * @param summe float-Wert
	 */
	public void setSumme(float summe);

	/**
	 * Gibt den Wert des Attributs Summe zurück
	 * @return float-Wert des Attributs
	 */
	public float getSumme();

	/**
	 * Fügt dem Attribut Teilzahlung einen Wert hinzu
	 * @param teilzahl ITeilzahlung-Objekt
	 */
	public void addTeilzahlung(ITeilzahlung teilzahl);

	/**
	 * Entfernt den übergebenen Wert vom Attribut Teilzahlungen
	 * @param teilzahl ITeilzahlung-Objekt
	 */
	public void removeTeilzahlung(ITeilzahlung teilzahl);

	/**
	 * Gibt den Wert des Attributs Teilzahlungen zurück
	 * @return Set<ITeilzahlung>-Objekt des Attributs
	 */
	public Set<ITeilzahlung> getTeilzahlungen();

	/**
	 * Setzt das Attribut Mitarbeiter auf den übergebenen Wert
	 * @param mitarbeiter IMitarbeiter
	 */
	public void setMitarbeiter(IMitarbeiter mitarbeiter);

	/**
	 * Gibt den Wert des Attributs Mitarbeiter zurück
	 * @return IMitarbeiter
	 */
	public IMitarbeiter getMitarbeiter();

	/**
	 * Setzt das Attribut Bezahler-Vorname auf den übergebenen Wert
	 * @param bezahlerVorname String
	 */
	public void setBezahlerVorname(String bezahlerVorname);

	/**
	 * Gibt den Wert des Attributs Bezahler-Vorname zurück
	 * @return String
	 */
	public String getBezahlerVorname();

	/**
	 * Setzt das Attribut Bezahler-Nachname auf den übergebenen Wert
	 * @param bezahlerNachname String
	 */
	public void setBezahlerNachname(String bezahlerNachname);

	/**
	 * Gibt den Wert des Attributs Bezahler-Nachname zurück
	 * @return String
	 */
	public String getBezahlerNachname();

	/**
	 * Setzt das Attribut Bezahler-Strasse auf den übergebenen Wert
	 * @param bezahlerStrasse String
	 */
	public void setBezahlerStrasse(String bezahlerStrasse);

	/**
	 * Gibt den Wert des Attributs Bezahler-Straße zurück
	 * @return String
	 */
	public String getBezahlerStrasse();

	/**
	 * Setzt das Attribut Bezahler-Ort auf den übergebenen Wert
	 * @param bezahlerOrt String
	 */
	public void setBezahlerOrt(String bezahlerOrt);

	/**
	 * Gibt den Wert des Attributs Bezahler-Ort zurück
	 * @return String
	 */
	public String getBezahlerOrt();

	/**
	 * Setzt das Attribut BezahlerPLZ auf den übergebenen Wert
	 * @param bezahlerPLZ String
	 */
	public void setBezahlerPLZ(String bezahlerPLZ);

	/**
	 * Gibt den Wert des Attributs Bezahler-PLZ zurück
	 * @return String
	 */
	public String getBezahlerPLZ();

	/**
	 * Gibt den Wert des Attributs Bezahler-Land zurück
	 * @return ILand
	 */
	public ILand getBezahlerLand();

	/**
	 * Setzt das Attribut Bezahler-Land auf den übergebenen Wert
	 * @param bezahlerLand ILand
	 */
	public void setBezahlerLand(ILand bezahlerLand);
}
