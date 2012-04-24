package projekt.fhv.teama.classes;

/**
 * Interface f�r die Klasse Pfandtyp
 * @author Team A
 * @version 1.8
 */
public interface IPfandtyp extends IModel {
	
	/**
	 * Setzt den Wert f�r das Attribut Bezeichnung
	 * @param bezeichnung String-Wert f�r das Attributs Bezeichnung
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zur�ck
	 * @return String-Wert des Attributs Bezeichnung
	 */
	public String getBezeichnung();

	/**
	 * Setzt den Wert f�r das Attribut Beschreibung
	 * @param beschreibung String-Wert f�r das Attribut Beschreibung
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zur�ck
	 * @return String-Wert des Attributs Beschreibung
	 */
	public String getBeschreibung();
}
