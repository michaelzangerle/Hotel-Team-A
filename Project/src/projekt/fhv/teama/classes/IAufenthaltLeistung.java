package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.leistungen.ILeistung;

/**
 * Interface für die Klasse AufenthaltLeistung
 *  
 * @author Team A
 * @version 1.2
 */
public interface IAufenthaltLeistung extends IModel {
	
	/**
	 * Gibt die Leistung zurück
	 * @return ILeistung
	 */
	public ILeistung getLeistung();

	/**
	 * Setzt die Leistung
	 * @param leistung ILeistung
	 */
	public void setLeistung(ILeistung leistung);

	/**
	 * Gibt den Aufenthalt zurück
	 * @return IAufenthalt
	 */
	public IAufenthalt getAufenthalt();

	/**
	 * Setzt den Aufenthalt
	 * @param aufenthalt IAufenthalt
	 */
	public void setAufenthalt(IAufenthalt aufenthalt);

	/**
	 * Gibt die Anzahl der Leistung zurück
	 * @return int
	 */
	public int getAnzahl();

	/**
	 * Setzt die Anzahl der Leistung
	 * @param anzahl
	 */
	public void setAnzahl(int anzahl);

	/**
	 * Gibt das Datum zurück
	 * @return Date
	 */
	public Date getDatum();

	/**
	 * Setzt das Datum
	 * @param datum Date
	 */
	public void setDatum(Date datum);

}
