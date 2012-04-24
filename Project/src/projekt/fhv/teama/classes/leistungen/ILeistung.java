package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface f�r die Klasse Leistung
 * @author Team A
 * @version 1.8
 */
public interface ILeistung extends IModel {
	
	/**
	 * Setzt das Attribut Bezeichnung
	 * @param beschreibung String-Wert f�r das Attribut Bezeichnung
	 */
	public void setBezeichnung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Bezeichnung zur�ck
	 * @return Gibt das Attribut als String-Wert zur�ck
	 */
	public String getBezeichnung();
}
