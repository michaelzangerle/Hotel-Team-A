package projekt.fhv.teama.classes.leistungen;

import java.util.Set;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface für die Klasse Warengruppe
 * @author Team A
 * @version 1.8
 *
 */
public interface IWarengruppe extends IModel {

	/**
	 * Setzt das Attribut Bezeichnung 
	 * @param bezeichnung String-Wert für das Attribut Bezeichnung
	 */
	public void setBezeichnung(String bezeichnung);

	/**
	 * Gibt den Wert des Attributs Bezeichnung zurück
	 * @return String-Wert des Attributs Bezeichnung
	 */
	public String getBezeichnung();

	/**
	 * Setzt das Attribut Beschreibung 
	 * @param beschreibung String-Wert für das Attribut Beschreibung
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Gibt den Wert des Attributs Beschreibung zurück
	 * @return String-Wert des Attributs Beschreibung
	 */
	public String getBeschreibung();

	/**
	 * Fügt dem Attribut Artikel einen weiteren hinzu 
	 * @param artikel IArtikel-Objekt für das Attribut Artikel
	 */
	public void addArtikel(IArtikel artikel);

	/**
	 * Entfernt aus dem Attribut Artikel einen Artikel
	 * @param artikel IArtikel-Objekt das entfernt werden soll
	 */
	public void removeArtikel(IArtikel artikel);

	/**
	 * Gibt den Wert des Attributs zurück
	 * @return
	 */
	public Set<IArtikel> getArtikel();

	/**
	 * Setzt das Attribut Artikel
	 * @param artikel Set<IArtikel>-Objekt für das Attribut Artikel
	 */
	public void setArtikel(Set<IArtikel> artikel);

	/**
	 * Setzt das Attribut Steuersatz
	 * @param steuersatz Short-Wert für das Attribut Steuersatz
	 */
	public void setSteuersatz(short steuersatz);

	/**
	 * Gibt den Wert des Attributs Steuersatz zurück
	 * @return Gibt den Short-Wert vom Attribut Steuersatz zurück
	 */
	public short getSteuersatz();

	/**
	 * Fügt eine Zusatzleistung zu dem Attribut ZUsatzleistungen hinzu
	 * @param zusatzleistung IZusatzleistung-Objekt das zum Attribut Zusatzleistungen hinzugefügt wird
	 */
	public void addZusatzleistung(IZusatzleistung zusatzleistung);

	/**
	 * Entfernt eine Zusatzleistung aus dem Attribut Zusatzleistungen
	 * @param zusatzleistung IZusatzleistung-Objekt das aus dem Attribut Zusatzleistungen entfernt wird
	 */
	public void removeZusatzleistung(IZusatzleistung zusatzleistung);

	/**
	 * Setzt das Attribut Zusatzleistung
	 * @param zusatzleistungen Set<IZusatzleistung>-Objekt für das Attribut Zusatzleistungen 
	 */
	public void setZusatzleistungen(Set<IZusatzleistung> zusatzleistungen);

	/**
	 * Gibt den Wert des Attributs Zusatzleistung zurück
	 * @return Gibt ein Set<IZusatzleistung> zurück 
	 */
	public Set<IZusatzleistung> getZusatzleistungen();
}
