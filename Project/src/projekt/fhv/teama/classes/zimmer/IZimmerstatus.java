package projekt.fhv.teama.classes.zimmer;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface für die Klasse Zimmerstatus 
 * @author Team A
 * @version 1.2
 */
public interface IZimmerstatus extends IModel {
	
	/**
	 * Setzt den übergebenen Wert für das Attribut Bezeichnung
	 * @param bezeichnung String
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Retourniert den Wert des Attributs Bezeichnung
	 * @return String
	 */
	public String getBezeichnung();

	/**
	 * Setzt den übergebenen Wert für das Attribut Kürzel
	 * @param kuerzel String
	 */
	public void setKuerzel(String kuerzel);

	/**
	 * Retourniert den Wert des Attributs Kürzel
	 * @return String
	 */
	public String getKuerzel();
}
