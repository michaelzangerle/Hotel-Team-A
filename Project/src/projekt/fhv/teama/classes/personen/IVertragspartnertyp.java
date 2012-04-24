package projekt.fhv.teama.classes.personen;

/**
 * Beschreibt die Methoden die für den Vertragpartner benötigt werden
 * @author Team-A
 * @version 1.5
 */
public interface IVertragspartnertyp {
	
	/**
	 * Gibt die Bezeichnung des Vertragspartnertyps zurück
	 * @return String
	 */
	public String getBezeichnung();

	/**
	 * Mit dieser Methode kann man die Bezeichnung des Vertragspartners setzten
	 * @param bezeichnung
	 */
	public void setBezeichnung(String bezeichnung);
}
