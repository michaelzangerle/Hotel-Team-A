/**
 * 
 */
package projekt.fhv.teama.model.integration;

import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.exception.FokusException;

/**
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public interface IAModelZimmer {

	/**
	 * @param zimmer
	 */
	void setAktullesZimmer(IAZimmer zimmer);

	/**
	 * @return
	 * @throws FokusException 
	 */
	IAZimmer getAAktullesZimmer() throws FokusException;

}
