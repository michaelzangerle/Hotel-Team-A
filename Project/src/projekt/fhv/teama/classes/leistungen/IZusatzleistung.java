package projekt.fhv.teama.classes.leistungen;


/**
 * Interface für die Klasse Zusatzleistung
 * @author Team A
 * @version 1.8
 */
public interface IZusatzleistung extends ILeistung {

	/**
	 * Setzt das Attribut Beschreibung
	 * @param beschreibung String-Wert für das Attribut Beschreibung
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zurück
	 * @return Gibt die Beschreibung als String zurück
	 */
	public String getBeschreibung();

	/**
	 * Setzt das Attribut Warengruppe
	 * @param warengruppe IWarengruppe-Objekt für das Attribut Warengruppe
	 */
	public void setWarengruppe(IWarengruppe warengruppe);

	/**
	 * Gibt den Wert des Attributs Warengruppe zurück
	 * @return Gibt die Warengruppe als IWarengruppe zurück
	 */
	public IWarengruppe getWarengruppe();

	/**
	 * Setzt das Attribut Preis
	 * @param preis Float-Wert für das Attribut Preis
	 */
	public void setPreis(float preis);

	/**
	 * Gibt den Wert des Attributs Preis zurück 
	 * @return Gibt den Preis als float zurück
	 */
	public float getPreis();

	/**
	 * Setzt das Attribut Extern
	 * @param extern Boolean-Wert für das Attribut Extern
	 */
	public void setExtern(boolean extern);

	/**
	 * Gibt den Wert des Attributs Extern zurück
	 * @return Gibt Extern als boolean zurück
	 */
	public boolean isExtern();
}
