package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.integrate.IAAufenthalt;

/**
 * Interface für die Klasse Aufenthalt
 * @author Team A
 * @version 1.9
 */
public interface IAufenthalt extends IModel,IAAufenthalt {
	
	/**
	 * Setzt den Preis den Aufenthalt fest
	 * @param preis
	 */
	public void setPreis(Float preis);

	/**
	 * Gibt den Wert des Attributs Preis zurück
	 * @return Float-Wert des Preis Attributs
	 */
	public Float getPreis();

	/**
	 * Setzen des Werts für das Pfandtyp Attribut
	 * @param pfandtyp IPfandTyp-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setPfandtyp(IPfandtyp pfandtyp);

	/**
	 * Gibt den Wert des Attributs Pfand zurück
	 * @return PfandTyp-Objekt des Pfand-Typ Attributs
	 */
	public IPfandtyp getPfandtyp();

	/**
	 * Setzen des Werts für das Von Attribut
	 * @param von Date-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setVon(Date von);

	/**
	 * Gibt den Wert des Attributs Von zurück
	 * @return Date-Objekt des Attributs
	 */
	public Date getVon();

	/**
	 * Setzen des Werts für das Bis Attribut
	 * @param bis Date-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setBis(Date bis);

	/**
	 * Gibt den Wert des Attributs Bis zurück
	 * @return Date-Objekt des Attributs
	 */
	public Date getBis();

	/**
	 * Setzen des Werts für das Schlüssel Attribut
	 * @param schluessel Schlüssel-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setSchluessel(boolean schluessel);

	/**
	 * Setzen des Werts für das Schlüssel Attribut
	 * @return Schluessel-Wert des Schlüssel Attributs
	 */
	public boolean getSchluessel();

	/**
	 * Setzen des Werts für das PfandNr Attribut
	 * @param pfandNr String-Wert welcher dem Attribut zugewiesen wird
	 */
	public void setPfandNr(String pfandNr);

	/**
	 * Gibt den Wert des Attributs PfandNr zurück
	 * @return String-Wert des PfandNr Attributs
	 */
	public String getPfandNr();

	/**
	 * Gibt den Wert des Attributs Gast zurück
	 * @return IGast-Objekt des Gast Attributs
	 */
	public IGast getGast();

	/**
	 * Setzen des Werts für das Gast Attribut
	 * @param gast IGast-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setGast(IGast gast);

	/**
	 * Gibt den Wert des Attributs Zimmer zurück
	 * @return IZimmer-Objekt des Attributs
	 */
	public IZimmer getZimmer();

	/**
	 * Setzen des Werts für das Zimmer Attribut
	 * @param zimmer IZimmer-Objekt welcher dem Attribut zugewiesen wird
	 */
	public void setZimmer(IZimmer zimmer);

}
