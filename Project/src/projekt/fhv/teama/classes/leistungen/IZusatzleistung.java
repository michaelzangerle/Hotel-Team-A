package projekt.fhv.teama.classes.leistungen;


/**
 * Interface f�r die Klasse Zusatzleistung
 * @author Team A
 * @version 1.8
 */
public interface IZusatzleistung extends ILeistung {

	/**
	 * Setzt das Attribut Beschreibung
	 * @param beschreibung String-Wert f�r das Attribut Beschreibung
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zur�ck
	 * @return Gibt die Beschreibung als String zur�ck
	 */
	public String getBeschreibung();

	/**
	 * Setzt das Attribut Warengruppe
	 * @param warengruppe IWarengruppe-Objekt f�r das Attribut Warengruppe
	 */
	public void setWarengruppe(IWarengruppe warengruppe);

	/**
	 * Gibt den Wert des Attributs Warengruppe zur�ck
	 * @return Gibt die Warengruppe als IWarengruppe zur�ck
	 */
	public IWarengruppe getWarengruppe();

	/**
	 * Setzt das Attribut Preis
	 * @param preis Float-Wert f�r das Attribut Preis
	 */
	public void setPreis(float preis);

	/**
	 * Gibt den Wert des Attributs Preis zur�ck 
	 * @return Gibt den Preis als float zur�ck
	 */
	public float getPreis();

	/**
	 * Setzt das Attribut Extern
	 * @param extern Boolean-Wert f�r das Attribut Extern
	 */
	public void setExtern(boolean extern);

	/**
	 * Gibt den Wert des Attributs Extern zur�ck
	 * @return Gibt Extern als boolean zur�ck
	 */
	public boolean isExtern();
}
