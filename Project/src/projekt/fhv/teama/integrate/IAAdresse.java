/**
 * 
 */
package projekt.fhv.teama.integrate;

import projekt.fhv.teama.classes.personen.ILand;

/**
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public interface IAAdresse {

	/**
	 * @return
	 */
	String getPlz();

	/**
	 * @return
	 */
	String getStrasse();

	/**
	 * @return
	 */
	IALand getALand();
	/**
	 * @return
	 */
	String getOrt();

	ILand getLand();

}
