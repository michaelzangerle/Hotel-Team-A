/**
 * 
 */
package projekt.fhv.teama.integrate;

import projekt.fhv.teama.classes.leistungen.Artikel;

/**
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public interface IAZimmer {

	/**
	 * @return
	 */
	String getNummer();

	/**
	 * @return
	 */
	IAKategorie getAKategorie();

}
