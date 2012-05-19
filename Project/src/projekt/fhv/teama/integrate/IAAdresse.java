package projekt.fhv.teama.integrate;

import projekt.fhv.teama.classes.personen.ILand;

/**
 * Interface für die Integration für die Adress-Klasse
 * 
 * @author Team A
 * @version 1.3
 */
public interface IAAdresse {

	/**
	 * Gibt die PLZ zurück
	 * @return String
	 */
	String getPlz();

	/**
	 * Gibt die Straße zurück
	 * @return String
	 */
	String getStrasse();

	/**
	 * Gibt das Land zurück
	 * @return IALand
	 */
	IALand getALand();

	/**
	 * Gibt den Ort zurück
	 * @return String
	 */
	String getOrt();

	/**
	 * Gib das Land zurück
	 * @return ILand
	 */
	ILand getLand();

}
