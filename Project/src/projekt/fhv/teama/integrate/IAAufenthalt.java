package projekt.fhv.teama.integrate;

import java.sql.Date;

/**
 * Interface f�r die Integration f�r die Aufenthalt-Klasse
 * 
 * @author Team A
 * @version 1.3
 */
public interface IAAufenthalt {

	/**
	 * Gibt den Gast zur�ck
	 * @return IGast
	 */
	IAGast getAGast();

	/**
	 * Gibt das Zimmer zur�ck
	 * @return IAZimmer
	 */
	IAZimmer getAZimmer();

	/**
	 * Gibt gibt das Von-Datum zur�ck
	 * @return Date
	 */
	Date getAVon();

	/**
	 * Gibt das Bis-Datum zur�ck
	 * @return Date
	 */
	Date getABis();

	/**
	 * Gibt gibt den Pfandtyp zur�ck
	 * @return IAPfandtyp
	 */
	IAPfandtyp getAPfandtyp();

	/**
	 * Gibt die Pfand-Nummer zur�ck
	 * @return String
	 */
	String getPfandNr();

	/**
	 * Gibt die ID zur�ck
	 * @return int
	 */
	int getID();
	
	/**
	 * Setzen des Werts f�r das PfandNr Attribut
	 * @param pfandNr String-Wert welcher dem Attribut zugewiesen wird
	 */
	public void setPfandNr(String pfandNr);
	
	void setCheckedOut(boolean b);
	
	boolean getCheckedOut();
}
