package projekt.fhv.teama.classes.leistungen;


/**
 * Interface f�r die Klasse Artikel
 * 
 * @author Team A
 * @version 1.8
 */
public interface IArtikel extends ILeistung {

	/**
	 * Setzt das Attribut Beschreibung
	 * 
	 * @param beschreibung
	 *            String-Wert f�r das Attribut Beschreibung
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zur�ck
	 * 
	 * @return Gibt die Beschreibung als String zur�ck
	 */
	public String getBeschreibung();

	/**
	 * Setzt das Attribut Preis
	 * 
	 * @param preis
	 *            Float-Wert f�r das Attribut Preis
	 */
	public void setPreis(float preis);

	/**
	 * Gibt den Wert des Attributs Preis zur�ck
	 * 
	 * @return Gibt den Preis als Float zur�ck
	 */
	public float getPreis();

	/**
	 * Setzt das Attribut Warengruppe
	 * 
	 * @param warengruppe
	 *            IWarengruppe-Objekt f�r das Attribut Warengruppe
	 */
	public void setWarengruppe(IWarengruppe warengruppe);

	/**
	 * Gibt den Wert des Attributs Warengruppe zur�ck
	 * 
	 * @return Gibt die Warengruppe als IWarengruppe zur�ck
	 */
	public IWarengruppe getWarengruppe();
}
