package projekt.fhv.teama.model.integration;

import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.model.exception.FokusException;

public interface IAModelGast {

	public void setAktuellGast(IAGast gast);
	
	IAGast getAktuellGast() throws FokusException;
}
