package projekt.fhv.teama.model.integration;

import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.model.exception.FokusException;

/**
 * Interface für die Adapterklasse ModelGast
 *
 * @author Team-A
 * @version 1.5
 */
public interface IAModelGast {

	/**
	 * Set den Fokus auf den aktuellen gast
	 * @param gast
	 */
	public void setAktuellGast(IAGast gast);
	
	/**
	 * holt den fokusierten Gast
	 * @return IAGast
	 * @throws FokusException
	 */
	IAGast getAktuellGast() throws FokusException;
	
}
