package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;

/**
 * Interface für die Klasse Aufenthalt
 * @author Team A
 * @version 1.9
 */
public interface IAufenthalt extends IModel {
	public void setPreis(Float preis);

	/**
	 * Gibt den Wert des Attributs Preis zurück
	 * @return
	 */
	public Float getPreis();

	/**
	 * @param pfandtyp
	 */
	public void setPfandtyp(IPfandtyp pfandtyp);

	/**
	 * Gibt den Wert des Attributs Pfand zurück
	 * @return
	 */
	public IPfandtyp getPfandtyp();

	/**
	 * @param von
	 */
	public void setVon(Date von);

	/**
	 * Gibt den Wert des Attributs zurück
	 * @return
	 */
	public Date getVon();

	/**
	 * @param bis
	 */
	public void setBis(Date bis);

	/**
	 * Gibt den Wert des Attributs zurück
	 * @return
	 */
	public Date getBis();

	/**
	 * @param schluessel
	 */
	public void setSchluessel(boolean schluessel);

	/**
	 * @return
	 */
	public boolean isSchluessel();

	/**
	 * @param pfandNr
	 */
	public void setPfandNr(String pfandNr);

	/**
	 * Gibt den Wert des Attributs zurück
	 * @return
	 */
	public String getPfandNr();

	/**
	 * Gibt den Wert des Attributs zurück
	 * @return
	 */
	public IGast getGast();

	/**
	 * @param gast
	 */
	public void setGast(IGast gast);

	/**
	 * Gibt den Wert des Attributs zurück
	 * @return
	 */
	public IZimmer getZimmer();

	/**
	 * @param zimmer
	 */
	public void setZimmer(IZimmer zimmer);

}
