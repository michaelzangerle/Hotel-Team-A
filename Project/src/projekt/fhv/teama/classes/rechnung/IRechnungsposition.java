package projekt.fhv.teama.classes.rechnung;

import java.sql.Date;

import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import roomanizer.teamb.service.integrate.IBRechnungsPosition;

/**
 * Interface f�r eine Rechnungsposition 
 * @author Team A
 * @version 1.9
 */
public interface IRechnungsposition extends IModel,IBRechnungsPosition {
	
	/**
	 * Setzt den Wert des Attributs Leistung auf den �bergebenen Wert
	 * @param leistung ILeistung
	 */
	public void setLeistung(ILeistung leistung);

	/**
	 * Gibt den Wert des Attributs Leistung zur�ck
	 * @return ILeistung
	 */
	public ILeistung getLeistung();

	/**
	 * Setzt den Wert des Attributs Einzelpreis auf den �bergebenen Wert
	 * @param einzelpreis float
	 */
	public void setEinzelpreis(float einzelpreis);

	/**
	 * Gibt den Wert des Attributs Einzelpreis zur�ck
	 * @return float
	 */
	public float getEinzelpreis();

	/**
	 * Setzt das Attribut Anzahl auf den �bergebenen Wert
	 * @param anzahl int
	 */
	public void setAnzahl(int anzahl);

	/**
	 * Gibt den Wert des Attributs Anzahl zur�ck
	 * @return int 
	 */
	public int getAnzahl();

	/**
	 * Setzt das Attribut Steuersatz auf den �bergebenen Wert
	 * @param steuersatz short
	 */
	public void setSteuersatz(short steuersatz);

	/**
	 * Gibt den Wert des Attributs Steuersatz zur�ck
	 * @return short
	 */
	public short getSteuersatz();

	/**
	 * Gibt den Wert des Attributs Summe zur�ck
	 * @return float
	 */
	public float getSumme();

	/**
	 * Setzt das Attribut Summe auf den �bergebenen Wert
	 * @param summe float
	 */
	public void setSumme(float summe);

	/**
	 * Setzt das Attribut Erstellung auf den �bergebenen Wert
	 * @param erstellung java.sql.Date
	 */
	public void setErstellung(Date erstellung);

	/**
	 * Gibt den Wert des Attributs Erstellung zur�ck
	 * @return java.sql.Date
	 */
	public Date getErstellung();

	/**
	 * Setzt das Attribut Zimmer auf den �bergebenen Wert
	 * @param zimmer IZimmer
	 */
	public void setZimmer(IZimmer zimmer);

	/**
	 * Gibt den Wert Attributs Zimmer zur�ck
	 * @return IZimmer
	 */
	public IZimmer getZimmer();

	/**
	 * Setzt das Attribut Beglichen auf den �bergebenen Wert
	 * @param beglichen boolean
	 */
	public void setBeglichen(boolean beglichen);

	/**
	 * Gibt den Wert des Attributs Beglichen zur�ck
	 * @return boolean
	 */
	public boolean getBeglichen();

	/**
	 * Setzt das Attribut Gast auf den �bergebenen Wert
	 * @param gast IGast
	 */
	public void setGast(IGast gast);

	/**
	 * Gibt den Wert des Attributs Gast zur�ck
	 * @return IGast
	 */
	public IGast getGast();

	/**
	 * Setzt das Attribut Rechnung auf den �bergeben Wert
	 * @param rechnung IRechnung
	 */
	public void setRechnung(IRechnung rechnung);

	/**
	 * Gibt den Wert des Attributs Rechnung zur�ck
	 * @return IRechnung
	 */
	public IRechnung getRechnung();

}
