package projekt.fhv.teama.classes.zimmer;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface für die Klasse Teilreservierung
 * 
 * @author Team A
 * @version 1.2
 */
public interface ITeilreservierung extends IModel {
	
	/**
	 * Setzt den übergebenen Wert für das Attribut Reservierung
	 * @param res IReservierung
	 */
	public void setReservierung(IReservierung res);

	/**
	 * Retourniert den Wert des Attributs Reservierung
	 * @return IReservierung
	 */
	public IReservierung getReservierung();

	/**
	 * Setzt den übergebenen Wert für das Attribut Kategorie
	 * @param kat IKategorie
	 */
	public void setKategorie(IKategorie kat);

	/**
	 * Retourniert den Wert des Attributs Kategorie
	 * @return IKategorie
	 */
	public IKategorie getKategorie();

	/**
	 * Setzt den übergebenen Wert für das Attribut Anzahl
	 * @param anzahl int
	 */
	public void setAnzahl(int anzahl);

	/**
	 * Retourniert den Wert des Attributs Anzahl
	 * @return int
	 */
	public int getAnzahl();

}
