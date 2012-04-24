package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.classes.IModel;

/**
 * Interface f�r die Klasse  
 * @author Team A
 * @version 1.2
 */
public interface IReservierungsOption extends IModel {
	
	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Prozentsatz
	 * @param prozentsatz short
	 */
	public void setProzentsatz(short prozentsatz);

	/**
	 * Retourniert den Wert des Attributs Prozentsatz
	 * @return short
	 */
	public short getProzentsatz();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Erf�llung
	 * @param erfuellung java.sql.Date
	 */
	public void setErfuellung(Date erfuellung);

	/**
	 * Retourniert den Wert des Attributs Erf�llung
	 * @return java.sql.Date
	 */
	public Date getErfuellung();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Reservierung
	 * @param reservierung IReservierung
	 */
	public void setReservierung(IReservierung reservierung);

	/**
	 * Retourniert den Wert des Attributs Reservierung
	 * @return IReservierung
	 */
	public IReservierung getReservierung();

	/**
	 * Setzt den �bergebenen Wert f�r das Attribut Erf�llt
	 * @param erfuellt boolean
	 */
	public void setErfuellt(boolean erfuellt);

	/**
	 * Retourniert den Wert des Attributs Erf�llt
	 * @return boolean
	 */
	public boolean getErfuellt();
	
}
