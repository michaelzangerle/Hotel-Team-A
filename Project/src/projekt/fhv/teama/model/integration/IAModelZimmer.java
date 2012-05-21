/**
 * 
 */
package projekt.fhv.teama.model.integration;

import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.exception.FokusException;

/**
 * Integrationsklasse für den Zimmeradapter 
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public interface IAModelZimmer {

	/**
	 * Methode um den Fokus auf das aktuelle Zimmer zu setzen
	 * @param zimmer
	 */
	void setAktullesZimmer(IAZimmer zimmer);

	/**
	 * Hohlt sich das fokusierte Zimmer 
	 * @return IAZimmer
	 * @throws FokusException 
	 */
	IAZimmer getAAktullesZimmer() throws FokusException;

}
