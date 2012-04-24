package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface f�r die Klasse Statusentwicklung
 * 
 * @author Team A
 * @version 1.2
 */
public interface IStatusentwicklung extends IModel {

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Von
	 * @param von java.sql.Date
	 */
	public void setVon(Date von);

	/**
	 * Retourniert den Wert des Attributs Von
	 * @return
	 */
	public Date getVon();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Bis
	 * @param bis java.sql.Date
	 */
	public void setBis(Date bis);

	/**
	 * Retourniert den Wert des Attributs Bis
	 * @return
	 */
	public Date getBis();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut  Beschreibung
	 * @param beschreibung String
	 */
	public void setBeschreibung(String beschreibung);

	/**
	 * Retourniert den Wert des Attributs Beschreibung
	 * @return String
	 */
	public String getBeschreibung();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Zimmerstatus
	 * @param zimmerStatus IZimmerstatus
	 */
	public void setZimmerStatus(IZimmerstatus zimmerStatus);

	/**
	 * Retourniert den Wert des Attributs Status
	 * @return IZimmerstatus
	 */
	public IZimmerstatus getZimmerStatus();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Zimmer
	 * @param zimmer IZimmer
	 */
	public void setZimmer(IZimmer zimmer);

	/**
	 * Retourniert den Wert des Attributs Zimmer
	 * @return IZimmer
	 */
	public IZimmer getZimmer();
}
