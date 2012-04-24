package projekt.fhv.teama.classes.leistungen;


/**
 * Interface für die Klasse Artikel
 * 
 * @author Team A
 * @version 1.8
 */
public interface IArtikel extends ILeistung {

	/**
	 * Setzt das Attribut Beschreibung
	 * 
	 * @param beschreibung
	 *            String-Wert für das Attribut Beschreibung
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zurück
	 * 
	 * @return Gibt die Beschreibung als String zurück
	 */
	public String getBeschreibung();

	/**
	 * Setzt das Attribut Preis
	 * 
	 * @param preis
	 *            Float-Wert für das Attribut Preis
	 */
	public void setPreis(float preis);

	/**
	 * Gibt den Wert des Attributs Preis zurück
	 * 
	 * @return Gibt den Preis als Float zurück
	 */
	public float getPreis();

	/**
	 * Setzt das Attribut Warengruppe
	 * 
	 * @param warengruppe
	 *            IWarengruppe-Objekt für das Attribut Warengruppe
	 */
	public void setWarengruppe(IWarengruppe warengruppe);

	/**
	 * Gibt den Wert des Attributs Warengruppe zurück
	 * 
	 * @return Gibt die Warengruppe als IWarengruppe zurück
	 */
	public IWarengruppe getWarengruppe();
}
