package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.classes.IModel;
import roomanizer.teamb.service.integrate.IBZahlungsmethode;

/**
 * Interface für eine Zahlungsmethode 
 * @author Team A
 * @version 1.9
 */
public interface IZahlungsmethode extends IModel,IBZahlungsmethode {
	
	/**
	 * Setzt das Attribut Bezeichnung auf den übergebenen Wert
	 * @param bezeichnung String 
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Gibt den Wert des Attributs Bezeichnung zurück
	 * @return String
	 */
	public String getBezeichnung();

	/**
	 * Setzt das Attribut Beschreibung auf den übergebenen Wert
	 * @param beschreibung String
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zurück
	 * @return Strin
	 */
	public String getBeschreibung();

	/**
	 * Setzt das Attribut Kürzel auf den übergebenen Wert
	 * @param kuerzel String
	 */
	public void setKuerzel(String kuerzel);

	/**
	 * Gibt den Wert des Attributs Kuerzel zurück
	 * @return String
	 */
	public String getKuerzel();
}
