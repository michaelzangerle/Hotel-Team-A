package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface für die Klasse  
 * @author Team A
 * @version 1.2
 */
public interface IReservierungsOption extends IModel {
	
	/**
	 * Setzt den übergebenen Wert für das Attribut Prozentsatz
	 * @param prozentsatz short
	 */
	public void setProzentsatz(short prozentsatz);

	/**
	 * Retourniert den Wert des Attributs Prozentsatz
	 * @return short
	 */
	public short getProzentsatz();

	/**
	 * Setzt den übergebenen Wert für das Attribut Erfüllung
	 * @param erfuellung java.sql.Date
	 */
	public void setErfuellung(Date erfuellung);

	/**
	 * Retourniert den Wert des Attributs Erfüllung
	 * @return java.sql.Date
	 */
	public Date getErfuellung();

	/**
	 * Setzt den übergebenen Wert für das Attribut Reservierung
	 * @param reservierung IReservierung
	 */
	public void setReservierung(IReservierung reservierung);

	/**
	 * Retourniert den Wert des Attributs Reservierung
	 * @return IReservierung
	 */
	public IReservierung getReservierung();

	/**
	 * Setzt den übergebenen Wert für das Attribut Erfüllt
	 * @param erfuellt boolean
	 */
	public void setErfuellt(boolean erfuellt);

	/**
	 * Retourniert den Wert des Attributs Erfüllt
	 * @return boolean
	 */
	public boolean getErfuellt();
	
}
