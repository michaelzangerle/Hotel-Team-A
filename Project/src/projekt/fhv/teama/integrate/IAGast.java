package projekt.fhv.teama.integrate;

import java.util.Set;

/**
 * Interface f�r die Integration f�r die Gast-Klasse
 * 
 * @author Team A
 * @version 1.3
 */
public interface IAGast {

	/**
	 * Gibt die Gast-Nummer zur�ck
	 * @return String
	 */
	String getNummer();

	/**
	 * Gibt den Nachnamen zur�ck
	 * @return String
	 */
	String getNachname();

	/**
	 * Gibt den Vornamen zur�ck
	 * @return String
	 */
	String getVorname();

	/**
	 * Gibt die ID zur�ck
	 * @return int
	 */ 
	int getID();

	/**
	 * Gibt die Telefonnummer zur�ck
	 * @return String
	 */
	String getTelefonnummer();

	/**
	 * Gibt die E-Mail-Adresse zur�ck
	 * @return String
	 */
	String getEmail();

	/**
	 * Gibt die Adressen zur�ck
	 * @return Set<IAAdresse>
	 */ 
	Set<IAAdresse> getAAdressen();

}
