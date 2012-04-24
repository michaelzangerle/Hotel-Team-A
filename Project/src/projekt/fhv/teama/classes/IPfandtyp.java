package projekt.fhv.teama.classes;

/**
 * Interface für die Klasse Pfandtyp
 * @author Team A
 * @version 1.8
 */
public interface IPfandtyp extends IModel {
	
	/**
	 * Setzt den Wert für das Attribut Bezeichnung
	 * @param bezeichnung String-Wert für das Attributs Bezeichnung
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zurück
	 * @return String-Wert des Attributs Bezeichnung
	 */
	public String getBezeichnung();

	/**
	 * Setzt den Wert für das Attribut Beschreibung
	 * @param beschreibung String-Wert für das Attribut Beschreibung
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zurück
	 * @return String-Wert des Attributs Beschreibung
	 */
	public String getBeschreibung();
}
