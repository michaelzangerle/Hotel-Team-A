package projekt.fhv.teama.classes.rechnung;

import java.util.Set;

import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.personen.IMitarbeiter;

/**
 * Interface f�r eine Rechnung
 * 
 * @author Team A
 * @version 1.9
 */
public interface IRechnung extends IModel {

	/**
	 * Gibt den Wert des Attributs Nummer zur�ck
	 * @return String
	 */
	public String getNummer();

	/**
	 * Setzt das Attribut Nummer auf den �bergebenen Wert
	 * @param nummer String
	 */
	public void setNummer(String nummer);

	/**
	 * F�gt eine Rechnungsposition zu dem Attribut Rechnungspositionen hinzu
	 * @param rePos IRechnungsposition
	 */
	public void addRechnungsposition(IRechnungsposition rePos);

	/**
	 * Entfernt eine Rechnungsposition vom Attribut Rechnungspositionen
	 * @param rePos IRechnungsposition
	 */
	public void removeRechnungsposition(IRechnungsposition rePos);

	/**
	 * Gibt den Wert des Attributs Rechnungspositionen zur�ck
	 * @return Set<IRechnungsposition>
	 */
	public Set<IRechnungsposition> getRechnungspositionen();

	/**
	 * Setzt das Attribut Summe auf den �bergebenen Wert
	 * @param summe float-Wert
	 */
	public void setSumme(float summe);

	/**
	 * Gibt den Wert des Attributs Summe zur�ck
	 * @return float-Wert des Attributs
	 */
	public float getSumme();

	/**
	 * F�gt dem Attribut Teilzahlung einen Wert hinzu
	 * @param teilzahl ITeilzahlung-Objekt
	 */
	public void addTeilzahlung(ITeilzahlung teilzahl);

	/**
	 * Entfernt den �bergebenen Wert vom Attribut Teilzahlungen
	 * @param teilzahl ITeilzahlung-Objekt
	 */
	public void removeTeilzahlung(ITeilzahlung teilzahl);

	/**
	 * Gibt den Wert des Attributs Teilzahlungen zur�ck
	 * @return Set<ITeilzahlung>-Objekt des Attributs
	 */
	public Set<ITeilzahlung> getTeilzahlungen();

	/**
	 * Setzt das Attribut Mitarbeiter auf den �bergebenen Wert
	 * @param mitarbeiter IMitarbeiter
	 */
	public void setMitarbeiter(IMitarbeiter mitarbeiter);

	/**
	 * Gibt den Wert des Attributs Mitarbeiter zur�ck
	 * @return IMitarbeiter
	 */
	public IMitarbeiter getMitarbeiter();

	/**
	 * Setzt das Attribut Bezahler-Vorname auf den �bergebenen Wert
	 * @param bezahlerVorname String
	 */
	public void setBezahlerVorname(String bezahlerVorname);

	/**
	 * Gibt den Wert des Attributs Bezahler-Vorname zur�ck
	 * @return String
	 */
	public String getBezahlerVorname();

	/**
	 * Setzt das Attribut Bezahler-Nachname auf den �bergebenen Wert
	 * @param bezahlerNachname String
	 */
	public void setBezahlerNachname(String bezahlerNachname);

	/**
	 * Gibt den Wert des Attributs Bezahler-Nachname zur�ck
	 * @return String
	 */
	public String getBezahlerNachname();

	/**
	 * Setzt das Attribut Bezahler-Strasse auf den �bergebenen Wert
	 * @param bezahlerStrasse String
	 */
	public void setBezahlerStrasse(String bezahlerStrasse);

	/**
	 * Gibt den Wert des Attributs Bezahler-Stra�e zur�ck
	 * @return String
	 */
	public String getBezahlerStrasse();

	/**
	 * Setzt das Attribut Bezahler-Ort auf den �bergebenen Wert
	 * @param bezahlerOrt String
	 */
	public void setBezahlerOrt(String bezahlerOrt);

	/**
	 * Gibt den Wert des Attributs Bezahler-Ort zur�ck
	 * @return String
	 */
	public String getBezahlerOrt();

	/**
	 * Setzt das Attribut BezahlerPLZ auf den �bergebenen Wert
	 * @param bezahlerPLZ String
	 */
	public void setBezahlerPLZ(String bezahlerPLZ);

	/**
	 * Gibt den Wert des Attributs Bezahler-PLZ zur�ck
	 * @return String
	 */
	public String getBezahlerPLZ();

	/**
	 * Gibt den Wert des Attributs Bezahler-Land zur�ck
	 * @return ILand
	 */
	public ILand getBezahlerLand();

	/**
	 * Setzt das Attribut Bezahler-Land auf den �bergebenen Wert
	 * @param bezahlerLand ILand
	 */
	public void setBezahlerLand(ILand bezahlerLand);
}
