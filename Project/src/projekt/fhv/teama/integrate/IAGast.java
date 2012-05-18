/**
 * 
 */
package projekt.fhv.teama.integrate;

import java.util.Set;

/**
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public interface IAGast {

	String getNummer();
	
	String getNachname();
	
	String getVorname();

	int getID();

	/**
	 * @return
	 */
	String getTelefonnummer();

	/**
	 * @return
	 */
	String getEmail();

	/**
	 * @return
	 */
	Set<IAAdresse> getAAdressen();

}
