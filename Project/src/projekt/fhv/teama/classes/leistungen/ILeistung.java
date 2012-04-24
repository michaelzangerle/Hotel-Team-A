package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface für die Klasse Leistung
 * @author Team A
 * @version 1.8
 */
public interface ILeistung extends IModel {
	
	/**
	 * Setzt das Attribut Bezeichnung
	 * @param beschreibung String-Wert für das Attribut Bezeichnung
	 */
	public void setBezeichnung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Bezeichnung zurück
	 * @return Gibt das Attribut als String-Wert zurück
	 */
	public String getBezeichnung();
}
