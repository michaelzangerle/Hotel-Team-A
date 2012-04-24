package projekt.fhv.teama.classes;

import projekt.fhv.teama.classes.zimmer.IKategorie;

/**
 * Interface für die Kategoriekontingent-Klasse
 * @author Team A
 * @version 1.9
 */
public interface IKategoriekontingent extends IModel {
	
	/**
	 * Gibt den Wert des Attributs Kategorie zurück
	 * @return IKategorie-Wert des Attributs
	 */
	public IKategorie getKategorie();

	/**
	 * Setzt den Wert des Attributs Kategorie
	 * @param kategorie IKategorie-Objekt des Attributs Kategorie
	 */
	public void setKategorie(IKategorie kategorie);

	/**
	 * Gibt den Wert des Attributs Kontingent zurück
	 * @return IKontingent-Wert des Attributs
	 */
	public IKontingent getKontingent();

	/**
	 * Setzt den Wert des Attributs Kontingent
	 * @param kontingent IKontingent-Objekt
	 */
	public void setKontingent(IKontingent kontingent);

	/**
	 * Gibt den Wert des Attributs Anzahl zurück
	 * @return int-Wert des Attributs
	 */
	public int getAnzahl();

	/**
	 * Setzt de n Wert des Attributs Anzahl
	 * @param anzahl int-Wert des Attributs
	 */
	public void setAnzahl(int anzahl);

	/**
	 * Gibt den Wert des Attributs Verfügbar zurück 
	 * @return int-Wert des Attributs
	 */ 
	public int getVerfuegbar();

	/**
	 * Setzt den Wert des Attributs Verfügbar 
	 * @param verfuegbar int-Wert des Attributs
	 */
	public void setVerfuegbar(int verfuegbar);

}
