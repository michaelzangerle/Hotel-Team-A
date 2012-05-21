package projekt.fhv.teama.integrate;

import java.sql.Date;

/**
 * Interface für die Integration für die Aufenthalt-Klasse
 * 
 * @author Team A
 * @version 1.3
 */
public interface IAAufenthalt {

	/**
	 * Gibt den Gast zurück
	 * @return IGast
	 */
	IAGast getAGast();

	/**
	 * Gibt das Zimmer zurück
	 * @return IAZimmer
	 */
	IAZimmer getAZimmer();

	/**
	 * Gibt gibt das Von-Datum zurück
	 * @return Date
	 */
	Date getAVon();

	/**
	 * Gibt das Bis-Datum zurück
	 * @return Date
	 */
	Date getABis();

	/**
	 * Gibt gibt den Pfandtyp zurück
	 * @return IAPfandtyp
	 */
	IAPfandtyp getAPfandtyp();

	/**
	 * Gibt die Pfand-Nummer zurück
	 * @return String
	 */
	String getPfandNr();

	/**
	 * Gibt die ID zurück
	 * @return int
	 */
	int getID();
	
	/**
	 * Setzen des Werts für das PfandNr Attribut
	 * @param pfandNr String-Wert welcher dem Attribut zugewiesen wird
	 */
	public void setPfandNr(String pfandNr);
	
	void setCheckedOut(boolean b);
	
	boolean getCheckedOut();
}
