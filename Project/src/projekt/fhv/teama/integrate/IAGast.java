package projekt.fhv.teama.integrate;

import java.util.Set;

/**
 * Interface für die Integration für die Gast-Klasse
 * 
 * @author Team A
 * @version 1.3
 */
public interface IAGast {

	/**
	 * Gibt die Gast-Nummer zurück
	 * @return String
	 */
	String getNummer();

	/**
	 * Gibt den Nachnamen zurück
	 * @return String
	 */
	String getNachname();

	/**
	 * Gibt den Vornamen zurück
	 * @return String
	 */
	String getVorname();

	/**
	 * Gibt die ID zurück
	 * @return int
	 */ 
	int getID();

	/**
	 * Gibt die Telefonnummer zurück
	 * @return String
	 */
	String getTelefonnummer();

	/**
	 * Gibt die E-Mail-Adresse zurück
	 * @return String
	 */
	String getEmail();

	/**
	 * Gibt die Adressen zurück
	 * @return Set<IAAdresse>
	 */ 
	Set<IAAdresse> getAAdressen();

}
