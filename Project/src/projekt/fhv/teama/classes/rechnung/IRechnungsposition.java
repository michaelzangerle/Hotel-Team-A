package projekt.fhv.teama.classes.rechnung;

import java.sql.Date;

import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;

/**
 * Interface für eine Rechnungsposition 
 * @author Team A
 * @version 1.9
 */
public interface IRechnungsposition extends IModel,IBRechnungsPosition {
	
	/**
	 * Setzt den Wert des Attributs Leistung auf den übergebenen Wert
	 * @param leistung ILeistung
	 */
	public void setLeistung(ILeistung leistung);

	/**
	 * Gibt den Wert des Attributs Leistung zurück
	 * @return ILeistung
	 */
	public ILeistung getLeistung();

	/**
	 * Setzt den Wert des Attributs Einzelpreis auf den übergebenen Wert
	 * @param einzelpreis float
	 */
	public void setEinzelpreis(float einzelpreis);

	/**
	 * Gibt den Wert des Attributs Einzelpreis zurück
	 * @return float
	 */
	public float getEinzelpreis();

	/**
	 * Setzt das Attribut Anzahl auf den übergebenen Wert
	 * @param anzahl int
	 */
	public void setAnzahl(int anzahl);

	/**
	 * Gibt den Wert des Attributs Anzahl zurück
	 * @return int 
	 */
	public int getAnzahl();

	/**
	 * Setzt das Attribut Steuersatz auf den übergebenen Wert
	 * @param steuersatz short
	 */
	public void setSteuersatz(short steuersatz);

	/**
	 * Gibt den Wert des Attributs Steuersatz zurück
	 * @return short
	 */
	public short getSteuersatz();

	/**
	 * Gibt den Wert des Attributs Summe zurück
	 * @return float
	 */
	public float getSumme();

	/**
	 * Setzt das Attribut Summe auf den übergebenen Wert
	 * @param summe float
	 */
	public void setSumme(float summe);

	/**
	 * Setzt das Attribut Erstellung auf den übergebenen Wert
	 * @param erstellung java.sql.Date
	 */
	public void setErstellung(Date erstellung);

	/**
	 * Gibt den Wert des Attributs Erstellung zurück
	 * @return java.sql.Date
	 */
	public Date getErstellung();

	/**
	 * Setzt das Attribut Zimmer auf den übergebenen Wert
	 * @param zimmer IZimmer
	 */
	public void setZimmer(IZimmer zimmer);

	/**
	 * Gibt den Wert Attributs Zimmer zurück
	 * @return IZimmer
	 */
	public IZimmer getZimmer();

	/**
	 * Setzt das Attribut Beglichen auf den übergebenen Wert
	 * @param beglichen boolean
	 */
	public void setBeglichen(boolean beglichen);

	/**
	 * Gibt den Wert des Attributs Beglichen zurück
	 * @return boolean
	 */
	public boolean getBeglichen();

	/**
	 * Setzt das Attribut Gast auf den übergebenen Wert
	 * @param gast IGast
	 */
	public void setGast(IGast gast);

	/**
	 * Gibt den Wert des Attributs Gast zurück
	 * @return IGast
	 */
	public IGast getGast();

	/**
	 * Setzt das Attribut Rechnung auf den übergeben Wert
	 * @param rechnung IRechnung
	 */
	public void setRechnung(IRechnung rechnung);

	/**
	 * Gibt den Wert des Attributs Rechnung zurück
	 * @return IRechnung
	 */
	public IRechnung getRechnung();

}
