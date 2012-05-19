package projekt.fhv.teama.integrate;

import projekt.fhv.teama.classes.personen.ILand;

/**
 * Interface f�r die Integration f�r die Adress-Klasse
 * 
 * @author Team A
 * @version 1.3
 */
public interface IAAdresse {

	/**
	 * Gibt die PLZ zur�ck
	 * @return String
	 */
	String getPlz();

	/**
	 * Gibt die Stra�e zur�ck
	 * @return String
	 */
	String getStrasse();

	/**
	 * Gibt das Land zur�ck
	 * @return IALand
	 */
	IALand getALand();

	/**
	 * Gibt den Ort zur�ck
	 * @return String
	 */
	String getOrt();

	/**
	 * Gib das Land zur�ck
	 * @return ILand
	 */
	ILand getLand();

}
